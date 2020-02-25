package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Queen implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board) {
        IChess.ChessPosition position;
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        switch (board.getPiece(p).GetColor()) {
            case CLR_WHITE:
                if (p.y == 7 && board.getPiece(p).GetType() == IChess.ChessType.TYP_QUEEN) {
                    for (int i = 7; i>= 0; i--){
                        list.add(new IChess.ChessPosition(p.x, p.y - i));
                        list.add(new IChess.ChessPosition(p.x, p.y + i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y));
                        list.add(new IChess.ChessPosition(p.x + i, p.y));
                        list.add(new IChess.ChessPosition(p.x + i, p.y + i));
                        list.add(new IChess.ChessPosition(p.x + i, p.y - i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y + i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y - i));
                    }
//                    for (int i = 0; i <= 7; i++){
//
//                    }
                }
                break;
            case CLR_BLACK:
                if (p.y == 0 && board.getPiece(p).GetType() == IChess.ChessType.TYP_QUEEN) {
                    for (int i = 7; i>= 0; i--){
                        list.add(new IChess.ChessPosition(p.x, p.y - i));
                        list.add(new IChess.ChessPosition(p.x, p.y + i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y));
                        list.add(new IChess.ChessPosition(p.x + i, p.y));
                        list.add(new IChess.ChessPosition(p.x + i, p.y + i));
                        list.add(new IChess.ChessPosition(p.x + i, p.y - i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y + i));
                        list.add(new IChess.ChessPosition(p.x - i, p.y - i));
                    }
                }
                break;
        }
        return list;
    }
}
