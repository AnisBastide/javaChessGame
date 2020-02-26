package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.List;

public class Rook implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board) {
        return MoveUtil.Horizontal(p, board, 7);
    }
}
