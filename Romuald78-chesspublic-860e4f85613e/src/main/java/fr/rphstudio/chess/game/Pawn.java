package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board) {
        IChess.ChessPosition position;
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        switch (board.getPiece(p).getColor()) {
            case CLR_WHITE:
                if (true) {
                    list.add(new IChess.ChessPosition(p.x, p.y - 2));
                }
                break;
            case CLR_BLACK:
                if (true) {
                    list.add(new IChess.ChessPosition(p.x, p.y + 2));
                }
                break;
        }
        return list;
    }
}
