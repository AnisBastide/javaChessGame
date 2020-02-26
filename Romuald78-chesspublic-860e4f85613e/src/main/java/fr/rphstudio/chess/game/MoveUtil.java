package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;

public class MoveUtil {

    public static boolean isValidPosition(IChess.ChessPosition pos){
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmpty(IChess.ChessPosition pos, Board board){
        if (board.getPiece(pos) == null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEnemy(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        if (board.getPiece(pos).GetColor() != board.getPiece(p).GetColor()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmptyOrEnemy(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        if (board.getPiece(pos).GetColor() != board.getPiece(p).GetColor() || board.getPiece(pos) == null){
            return true;
        }else{
            return false;
        }
    }

    public static List<IChess.ChessPosition> Diagonal(IChess.ChessPosition p, Board board, int u) {
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir++) {
            int i = 1;
            int dx = 1;
            int dy = 1;
            if (dir % 2 == 0) {
                dx = -1;
            }
            if (dir < 2) {
                dy = -1;
            }
            for (int dis = 1; dis <= 7; dis++) {
                do {
                    IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                    u++;
                    return PossibleMove(p, pos, board);
                }while (i < u);
            }
        }
        return list;
    }

    public static List<IChess.ChessPosition> Horizontal(IChess.ChessPosition p, Board board, int u){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir ++){
            int i = 1;
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
                do {
                    IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                    u++;
                    return PossibleMove(p, pos, board);
                }while (i < u);
            }
        }
        return list;
    }

    public static List<IChess.ChessPosition> PossibleMove(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0) {
            if (board.getPiece(pos) == null){
                list.add(pos);
            }
            if (board.getPiece(pos) != null){
                if (board.getPiece(pos).GetColor() != board.getPiece(p).GetColor()){
                    list.add(pos);
                }
            }
            return list;
        }
        return list;
    }
}
