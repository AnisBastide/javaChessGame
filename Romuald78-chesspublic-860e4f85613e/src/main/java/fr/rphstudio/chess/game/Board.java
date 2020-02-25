package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_WHITE;

public class Board {
    private List<Piece> pieceList;
    public Board() {
        IChess.ChessColor color;
        IChess.ChessType type=null;
        IMove move= new Pawn();
        pieceList = new ArrayList<Piece>();
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                IChess.ChessPosition cPosition=new IChess.ChessPosition(x,y);
                if (cPosition.y >=6) {
                    color = CLR_WHITE;
                } else if (cPosition.y <=1) {
                    color = CLR_BLACK;
                }
                else{
                    continue;
                }
                if (cPosition.y == 6 || cPosition.y == 1) {
                    type = IChess.ChessType.TYP_PAWN;
                } else if (cPosition.x == 0 || cPosition.x == 7) {
                    type = IChess.ChessType.TYP_ROOK;
                } else if (cPosition.x == 1 || cPosition.x == 6) {
                    type = IChess.ChessType.TYP_KNIGHT;
                } else if (cPosition.x == 2 || cPosition.x == 5) {
                    type = IChess.ChessType.TYP_BISHOP;
                } else if (cPosition.x == 4) {
                    type = IChess.ChessType.TYP_QUEEN;
                } else if (cPosition.x == 3) {
                    type = IChess.ChessType.TYP_KING;
                }
                pieceList.add(new Piece(color, type, (IChess.ChessPosition) cPosition,move));
            }
        }
    }
    public Piece getPiece(IChess.ChessPosition p){
        for(Piece piece: pieceList) {
            if(piece.getPosition().equals(p)){
                return piece;

            }
        }
        return null;
    }
}
