package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

    @Override
    public List<IChess.ChessPosition> getPieceMoves(IChess.ChessPosition p, Board board) {
        IChess.ChessPosition pos;
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        switch (board.getPiece(p).getColor()) {
            case CLR_WHITE:
                if (p.y == 6) {
                    list.add(new IChess.ChessPosition(p.x, p.y - 2));
                    list.add(new IChess.ChessPosition(p.x, p.y - 1));
                }
                else if (p.y < 6){
                    list.add(new IChess.ChessPosition(p.x, p.y - 1));
                    if (board.getPiece(new IChess.ChessPosition(p.x + 1, p.y - 1)).getColor() != board.getPiece(p).getColor()){
                        list.add(new IChess.ChessPosition(p.x + 1, p.y - 1));
                    }
                    if (board.getPiece(new IChess.ChessPosition(p.x - 1, p.y - 1)).getColor() != board.getPiece(p).getColor()){
                        list.add(new IChess.ChessPosition(p.x - 1, p.y - 1));
                    }
                }
                break;
            case CLR_BLACK:
                if (p.y == 1) {
                    list.add(new IChess.ChessPosition(p.x, p.y + 2));
                    list.add(new IChess.ChessPosition(p.x, p.y + 1));
                }
                else if (p.y > 1){
                    list.add(new IChess.ChessPosition(p.x, p.y + 1));
                    if (board.getPiece(new IChess.ChessPosition(p.x + 1, p.y + 1)).getColor() != board.getPiece(p).getColor()){
                        list.add(new IChess.ChessPosition(p.x + 1, p.y + 1));
                    }
                    if (board.getPiece(new IChess.ChessPosition(p.x - 1, p.y + 1)).getColor() != board.getPiece(p).getColor()){
                        list.add(new IChess.ChessPosition(p.x - 1, p.y + 1));
                    }
                }
                break;
        }
        return list;
    }
}
