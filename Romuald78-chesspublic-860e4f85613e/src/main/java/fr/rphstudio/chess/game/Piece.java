package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.awt.*;
import java.util.List;

public class Piece {
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IChess.ChessPosition position;
    private IMove imove;

    public Piece(IChess.ChessColor ChessColor, IChess.ChessType ChessType, IChess.ChessPosition position,IMove move){
        this.color=ChessColor;
        this.type=ChessType;
        this.position=position;
        this.imove=move;
    }

    public IChess.ChessPosition getPosition(){
        return position;
    }
    public IChess.ChessType GetType(){
        return type;
    }
    public IChess.ChessColor GetColor(){
        return color;
    }
    public List<IChess.ChessPosition> GetPossibleMoves(Board board){
        return imove.getPieceMoves(position, board);
    }
}