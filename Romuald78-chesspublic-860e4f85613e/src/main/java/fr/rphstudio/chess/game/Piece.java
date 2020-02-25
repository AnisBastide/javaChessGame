package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.awt.*;
import java.util.List;

public class Piece {
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IChess.ChessPosition position;
    public Piece(IChess.ChessColor ChessColor, IChess.ChessType ChessType, IChess.ChessPosition position){
    this.color=ChessColor;
    this.type=ChessType;
    this.position=position;
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
}
