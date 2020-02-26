package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.List;

public class Bishop implements IMove{

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board){
        return MoveUtil.Diagonal(p, board, 7);
    }
}
