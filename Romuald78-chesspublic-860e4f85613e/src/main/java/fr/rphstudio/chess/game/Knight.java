package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Knight implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board) {
        IChess.ChessPosition position;
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        switch (board.getPiece(p).GetColor()) {
            case CLR_WHITE:
                if (p.y == 7 && board.getPiece(p).GetType() == IChess.ChessType.TYP_KNIGHT) {
                    list.add(new IChess.ChessPosition(p.x + 1, p.y - 2));
                    list.add(new IChess.ChessPosition(p.x - 1, p.y - 2));
                    list.add(new IChess.ChessPosition(p.x + 2, p.y - 1));
                    list.add(new IChess.ChessPosition(p.x - 2, p.y - 1));
                }
                break;
            case CLR_BLACK:
                if (p.y == 0 && board.getPiece(p).GetType() == IChess.ChessType.TYP_KNIGHT) {
                    list.add(new IChess.ChessPosition(p.x - 1, p.y + 2));
                    list.add(new IChess.ChessPosition(p.x + 1, p.y + 2));
                    list.add(new IChess.ChessPosition(p.x - 2, p.y + 1));
                    list.add(new IChess.ChessPosition(p.x + 2, p.y + 1));
                }
                break;
        }
        return list;
    }
}
