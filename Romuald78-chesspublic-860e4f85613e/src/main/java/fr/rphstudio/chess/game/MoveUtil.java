package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class MoveUtil {

    public static List<IChess.ChessPosition> Diagonal(IChess.ChessPosition p, Board board) {
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir++) {
            int dx = 1;
            int dy = 1;
            if (dir % 2 == 0) {
                dx = -1;
            }
            if (dir < 2) {
                dy = -1;
            }
            for (int dis = 1; dis <= 7; dis++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                if (p.x + (dx * dis) == 8 || p.x + (dx * dis) == -1 || p.y + (dx * dis) == 8 || p.y + (dx * dis) == -1) {
                    break;
                }
                if (board.getPiece(pos) == null){
                    list.add(pos);
                }
                if (board.getPiece(pos) != null){
                    if (board.getPiece(pos).GetColor() != board.getPiece(p).GetColor()){
                        list.add(pos);
                    }
                    else{
                        break;
                    }
                }
                return list;
            }
        }
        return list;
    }

    public static List<IChess.ChessPosition> Horizontal(IChess.ChessPosition p, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir ++){
            int dx = 0;
            int dy = 0;
            switch (dir){
                case 0:
                    dy = -1;
                    break;
                case 1:
                    dx = -1;
                    break;
                case 2:
                    dx = 1;
                    break;
                case 3:
                    dy = 1;
                    break;
            }
            for (int dis = 1; dis <= 7; dis++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                if (p.x + (dx * dis) == 8 || p.x + (dx * dis) == -1 || p.y + (dx * dis) == 8 || p.y + (dx * dis) == -1) {
                    break;
                }
                if (board.getPiece(pos) == null){
                    list.add(pos);
                }
                if (board.getPiece(pos) != null){
                    if (board.getPiece(pos).GetColor() != board.getPiece(p).GetColor()){
                        list.add(pos);
                    }
                    else{
                        break;
                    }
                }
                return list;
            }
        }
        return list;
    }
}
