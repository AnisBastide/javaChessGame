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
        switch (board.getPiece(p).GetColor()) {
            case CLR_WHITE:
                if (p.y == 6 && board.getPiece(new IChess.ChessPosition(p.x, p.y - 1)) == null) {
                    list.add(new IChess.ChessPosition(p.x, p.y - 6));
                }
                break;
            case CLR_BLACK:
                if (p.y == 1 && board.getPiece(new IChess.ChessPosition(p.x, p.y + 1)) == null) {
                    list.add(new IChess.ChessPosition(p.x, p.y + 6));
                }
                break;
        }
        return list;
    }
}
