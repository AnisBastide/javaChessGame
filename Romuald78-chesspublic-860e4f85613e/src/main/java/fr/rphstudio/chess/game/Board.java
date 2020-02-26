package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_WHITE;

public class Board {
    private List<Piece> pieceList;

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
                    type = IChess.ChessType.TYP_PAWN;
                } else if (cPosition.x == 0 || cPosition.x == 7) {
                    type = IChess.ChessType.TYP_ROOK;
                } else if (cPosition.x == 1 || cPosition.x == 6) {
                    type = IChess.ChessType.TYP_KNIGHT;
                } else if (cPosition.x == 2 || cPosition.x == 5) {
                    type = IChess.ChessType.TYP_BISHOP;
                } else if (cPosition.x == 4) {
                    type = IChess.ChessType.TYP_QUEEN;
                } else if (cPosition.x == 3) {
                    type = IChess.ChessType.TYP_KING;
                }
                pieceList.add(new Piece(color, type, (IChess.ChessPosition) cPosition, move));
            }
        }
    }

    public Piece getPiece(IChess.ChessPosition p) {
        for (Piece piece : pieceList) {
            if (piece.getPosition().equals(p)) {
                return piece;

            }
        }
        return null;
    }

    public Piece movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1) {
        return this.movePiece(p0, p1, false);
    }

    public Piece movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1, boolean isFakeMove) {
        Piece pieceToMove = getPiece(p0);
        Piece pieceToRemove = getPiece(p1);
        pieceToMove.setPosition(p1);
        if (pieceToRemove != null) {
            pieceList.remove(pieceToRemove);
        }
        if (isFakeMove) {
            pieceList.add(pieceToRemove);
        }
        return pieceToRemove;
    }

    public int getRemainingPieces(IChess.ChessColor color) {
        int count = 0;
        for (Piece piece : pieceList
        ) {
            if (piece.getColor().equals(color)) {
                count++;
            }

        }
        return count;
    }

    public IChess.ChessKingState kingState(IChess.ChessColor color, Board board) {
        IChess.ChessPosition kingPosition = new IChess.ChessPosition();
        for (Piece piece : pieceList) {
            if (piece.getType().equals(IChess.ChessType.TYP_KING) && piece.getColor().equals(color)) {
                kingPosition = piece.getPosition();
                break;
            }

        }
        for (Piece piece : pieceList) {
            if (piece.getColor() != color) {
                List<IChess.ChessPosition> enemyList = piece.getPossibleMoves(board);
                for (IChess.ChessPosition enemyPosition : enemyList) {
                    if (enemyPosition.equals(kingPosition)) {
                        return IChess.ChessKingState.KING_THREATEN;
                    }
                }
            }
        }
        return IChess.ChessKingState.KING_SAFE;

    }

    public List<IChess.ChessPosition> checkMoves(IChess.ChessPosition p, List<IChess.ChessPosition> possibleMoves, Board board) {
        for (IChess.ChessPosition moves : possibleMoves) {
            movePiece(p, moves,true);
            IChess.ChessColor color = board.getPiece(p).getColor();
            IChess.ChessKingState status = kingState(color, board);
            movePiece(moves, p, true);
            if (status == IChess.ChessKingState.KING_THREATEN) {
                possibleMoves.remove(moves);
            }
        }
        return possibleMoves;

    }
}
