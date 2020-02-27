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
        if (board.getPiece(pos).getColor() != board.getPiece(p).getColor()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmptyOrEnemy(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        if (board.getPiece(pos).getColor() != board.getPiece(p).getColor() || board.getPiece(pos) == null){
            return true;
        }else{
            return false;
        }
    }

    private static boolean check = true;

    public static List<IChess.ChessPosition> Diagonal(IChess.ChessPosition p, Board board) {
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 4; dir++) {
            int dx = 1;
            int dy = 1;
            check = true;
            if (dir % 2 == 0) {
                dx = -1;
            }
            if (dir < 2) {
                dy = -1;
            }
            for (int dis = 1; dis <= 7; dis++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                list.addAll(PossibleMove(p, pos, board));
                if (dir == 4){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<IChess.ChessPosition> Horizontal(IChess.ChessPosition p, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 4; dir ++){
            int dx = 0;
            int dy = 0;
            check = true;
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
                list.addAll(PossibleMove(p, pos, board));
                if (dir == 4){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<IChess.ChessPosition> DiagonalKing(IChess.ChessPosition p, Board board) {
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir++) {
            int dx = 1;
            int dy = 1;
            check = true;
            if (dir % 2 == 0) {
                dx = -1;
            }
            if (dir < 2) {
                dy = -1;
            }
            for (int dis = 1; dis <= 1; dis++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                list.addAll(PossibleMove(p, pos, board));
                if (dir == 3){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<IChess.ChessPosition> HorizontalKing(IChess.ChessPosition p, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        for (int dir = 0; dir <= 3; dir ++){
            int dx = 0;
            int dy = 0;
            check = true;
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
            for (int dis = 1; dis <= 1; dis++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + (dx * dis), p.y + (dy * dis));
                list.addAll(PossibleMove(p, pos, board));
                if (dir == 3){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<IChess.ChessPosition> PossibleMove(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0 && check == true) {
            if (board.getPiece(pos) == null){
                list.add(pos);
            }
            if (board.getPiece(pos) != null){
                if (board.getPiece(pos).getColor() == board.getPiece(p).getColor()){
                    check = false;
                }
                if (board.getPiece(pos).getColor() != board.getPiece(p).getColor()){
                    list.add(pos);
                    check = false;
                }
            }
            return list;
        }
        return list;
    }

    public static List<IChess.ChessPosition> PossibleMoveKnight(IChess.ChessPosition p, IChess.ChessPosition pos, Board board){
        List<IChess.ChessPosition> list = new ArrayList<IChess.ChessPosition>();
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0) {
            if (board.getPiece(pos) == null){
                list.add(pos);
            }
            if (board.getPiece(pos) != null){
                if (board.getPiece(pos).getColor() != board.getPiece(p).getColor()){
                    list.add(pos);
                }
            }
            return list;
        }
        return list;
    }

    public static List<IChess.ChessPosition> MoveStartPawn(IChess.ChessPosition p, IChess.ChessPosition pos, Board board, int dy) {
        List<IChess.ChessPosition> list = new ArrayList<>();
        int cy = 0;
        switch (dy){
            case (1):
                cy = 1;
                break;
            case (-1):
                cy = 6;
        }
        if (p.y == cy && board.getPiece(new IChess.ChessPosition(p.x, p.y + dy)) == null){
            list.add(new IChess.ChessPosition(p.x, p.y + dy));
            if (p.y == cy && board.getPiece(new IChess.ChessPosition(p.x, p.y + dy)) == null){
                list.add(new IChess.ChessPosition(p.x, p.y + (dy * 2)));
            }
        }
        try {
            pos = new IChess.ChessPosition(p.x + 1, p.y + dy);
            if (board.getPiece(new IChess.ChessPosition(p.x + 1, p.y + dy)).getColor() != board.getPiece(p).getColor() && MoveUtil.isValidPosition(pos)) {
                list.add(new IChess.ChessPosition(p.x + 1, p.y + dy));
            }
        } catch (Exception e){

        }
        try {
            pos = new IChess.ChessPosition(p.x - 1, p.y + dy);
            if (board.getPiece(new IChess.ChessPosition(p.x - 1, p.y + dy)).getColor() != board.getPiece(p).getColor() && MoveUtil.isValidPosition(pos)) {
                list.add(new IChess.ChessPosition(p.x - 1, p.y + dy));
            }
        } catch(Exception e) {

        }
        return list;
    }

    public static List<IChess.ChessPosition> MoveOtherPawn(IChess.ChessPosition p, IChess.ChessPosition pos, Board board, int dy) {
        List<IChess.ChessPosition> list = new ArrayList<>();
        int cy = 0;
        switch (dy){
            case (1):
                cy = 1;
                break;
            case (-1):
                cy = 6;
        }
        if (MoveUtil.isValidPosition(pos)) {
            if (p.y != cy && board.getPiece(new IChess.ChessPosition(p.x, p.y + dy)) == null){
                list.add(new IChess.ChessPosition(p.x, p.y + dy));
            }
            try {
                pos = new IChess.ChessPosition(p.x + 1, p.y + dy);
                if (board.getPiece(new IChess.ChessPosition(p.x + 1, p.y + dy)).getColor() != board.getPiece(p).getColor() && MoveUtil.isValidPosition(pos)) {
                    list.add(new IChess.ChessPosition(p.x + 1, p.y + dy));
                }
            } catch (Exception e) {

            }
            try {
                pos = new IChess.ChessPosition(p.x - 1, p.y + dy);
                if (board.getPiece(new IChess.ChessPosition(p.x - 1, p.y + dy)).getColor() != board.getPiece(p).getColor() && MoveUtil.isValidPosition(pos)) {
                    list.add(new IChess.ChessPosition(p.x - 1, p.y + dy));
                }
            } catch (Exception e) {

            }
        }
        return list;
    }
}
