package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.List;

public class Queen implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition position, Board board) {
        return null;
    }
}
