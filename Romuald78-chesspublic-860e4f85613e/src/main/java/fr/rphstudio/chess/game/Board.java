package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.ChessException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_WHITE;

public class Board {
    private List<Piece> pieceList;
    public Undo undo = new Undo();

    public Board() {
        IChess.ChessColor color;
        IChess.ChessType type = null;
        IMove move = new Pawn();
        pieceList = new ArrayList<Piece>();
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                IChess.ChessPosition cPosition = new IChess.ChessPosition(x, y);
                if (cPosition.y >= 6) {
                    color = CLR_WHITE;
                } else if (cPosition.y <= 1) {
                    color = CLR_BLACK;
                } else {
                    continue;
                }
                if (cPosition.y == 6 || cPosition.y == 1) {
                    move = new Pawn();
                    type = IChess.ChessType.TYP_PAWN;
                } else if (cPosition.x == 0 || cPosition.x == 7) {
                    move = new Rook();
                    type = IChess.ChessType.TYP_ROOK;
                } else if (cPosition.x == 1 || cPosition.x == 6) {
                    move = new Knight();
                    type = IChess.ChessType.TYP_KNIGHT;
                } else if (cPosition.x == 2 || cPosition.x == 5) {
                    move = new Bishop();
                    type = IChess.ChessType.TYP_BISHOP;
                } else if (cPosition.x == 4) {
                    move = new Queen();
                    type = IChess.ChessType.TYP_QUEEN;
                } else if (cPosition.x == 3) {
                    move = new King();
                    type = IChess.ChessType.TYP_KING;
                }
                pieceList.add(new Piece(color, type, (IChess.ChessPosition) cPosition, move));
            }
        }
    }

    public Piece getPiece(IChess.ChessPosition p) {
        for (Piece piece : pieceList) {
            if (piece != null) {
                if (piece.getPosition().equals(p)) {
                    return piece;
                }
            }
        }
        return null;
    }

    public Piece movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1) {
        Piece piece = null;
        try {
            piece = this.movePiece(p0, p1, false);
        } catch (ChessException e) {

        }
        return piece;
    }

    public Piece movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1, boolean isFakeMove) throws ChessException {
        Piece pieceToMove = getPiece(p0);
        Piece pieceToRemove = getPiece(p1);
        pieceToMove.setPosition(p1);
        if (pieceToRemove != null) {
            pieceList.remove(pieceToRemove);
        }
        if (isFakeMove) {
            IChess.ChessKingState status = kingState(pieceToMove.getColor());
            pieceToMove.setPosition(p0);
            if (pieceToRemove != null) {
                pieceList.add(pieceToRemove);
            }
            if (status == IChess.ChessKingState.KING_THREATEN) {
                throw new ChessException();
            }
        }
        else{
            undo.setUndo(p0, p1, pieceToRemove);
        }
        return pieceToRemove;
    }
    public void moveUndo(IChess.ChessPosition p0, IChess.ChessPosition p1) {
        Piece pieceToMove = getPiece(p1);
        pieceToMove.setPosition(p0);

    }
    public int getRemainingPieces(IChess.ChessColor color) {
        int count = 0;
        for (Piece piece : pieceList) {
            if (piece != null) {
                if (piece.getColor().equals(color)) {
                    count++;
                }
            }


        }
        return count;
    }

    public IChess.ChessKingState kingState(IChess.ChessColor color) {
        IChess.ChessPosition kingPosition = new IChess.ChessPosition();
        for (Piece piece : pieceList) {
            if (piece.getType().equals(IChess.ChessType.TYP_KING) && piece.getColor().equals(color)) {
                kingPosition = piece.getPosition();
                break;
            }

        }
        for (Piece piece : pieceList) {
            if (piece != null) {
                if (piece.getColor() != color) {
                    List<IChess.ChessPosition> enemyList = piece.getPossibleMoves(this);
                    for (IChess.ChessPosition enemyPosition : enemyList) {
                        if (enemyPosition.equals(kingPosition)) {
                            return IChess.ChessKingState.KING_THREATEN;
                        }
                    }
                }
            }
        }
        return IChess.ChessKingState.KING_SAFE;

    }

    public List<IChess.ChessPosition> checkMoves(IChess.ChessPosition p, List<IChess.ChessPosition> possibleMoves) {
        List<IChess.ChessPosition> realMoves = new ArrayList<IChess.ChessPosition>();
        for (IChess.ChessPosition position : possibleMoves) {
            try {
                movePiece(p, position, true);
                realMoves.add(position);
            } catch (ChessException e) {
            }
        }
        return realMoves;

    }

    public void addPieces(Piece piece) {
        pieceList.add(piece);
    }
}
