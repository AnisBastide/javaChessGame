package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_WHITE;

public class Board {
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private List<Piece> board;
    public Board(List<IChess.ChessPosition> position){
        board=new ArrayList<Piece>();
        for ( IChess.ChessPosition cPosition:position){
            if(cPosition.y <=1){
                color=CLR_WHITE;
            }
            else if (cPosition.y >=6){
                color=CLR_BLACK;
            }
            if (cPosition.y == 6 && cPosition.y ==1){
                type= IChess.ChessType.TYP_PAWN;
            }
            else if (cPosition.x == 0 || cPosition.y==7  ){
                type= IChess.ChessType.TYP_ROOK;
            }
            else if (cPosition.x == 1 || cPosition.y == 6){
                type = IChess.ChessType.TYP_KNIGHT;
            }
            else if (cPosition.x == 2 || cPosition.y == 5){
                type = IChess.ChessType.TYP_BISHOP;
            }
            else if ( cPosition.y == 4){
                type = IChess.ChessType.TYP_QUEEN;
            }
            else if (cPosition.y == 3){
                type = IChess.ChessType.TYP_KING;
            }
            board.add(new Piece(color,type, (IChess.ChessPosition) position));



        }
    }
}
