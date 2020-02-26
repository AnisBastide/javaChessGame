package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {
    private static ChessModel instance = new ChessModel();
    private LostPieces lostPieces;
    private Board board;


    private ChessModel() {
        reinit();
    }

    public static IChess getInstance() {
        return ChessModel.instance;
    }

    @Override
    public void reinit() {
        board = new Board();
        lostPieces = new LostPieces();
    }


    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        try {
            return board.getPiece(p).getType();
        } catch (NullPointerException npe) {
            throw new EmptyCellException();
        }

    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        try {
            return board.getPiece(p).getColor();
        } catch (NullPointerException npe) {
            throw new EmptyCellException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return board.getRemainingPieces(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        try {
            return board.getPiece(p).getPossibleMoves(board);
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        }

    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece lostPiece = board.movePiece(p0, p1);
        if (lostPiece != null) {
            lostPieces.lostPieces(lostPiece);
        }
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return board.kingState(color, board);
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        if (lostPieces != null) {
            return lostPieces.getLostPiecesType(color);
        }
        return new ArrayList<ChessType>();
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }


}
