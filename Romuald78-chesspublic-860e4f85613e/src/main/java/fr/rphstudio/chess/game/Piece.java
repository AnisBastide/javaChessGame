package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.List;

public class Piece {
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IChess.ChessPosition position;
    private IMove imove;

    public Piece(IChess.ChessColor ChessColor, IChess.ChessType ChessType, IChess.ChessPosition position, IMove move) {
        this.color = ChessColor;
        this.type = ChessType;
        this.position = position;
        this.imove = move;
    }

    public IChess.ChessPosition getPosition() {
        return position;
    }

    public IChess.ChessType GetType() {
        return type;
    }

    public IChess.ChessType getType() {
        return type;
    }

    public IChess.ChessColor getColor() {

        return color;
    }
    public void setPosition(IChess.ChessPosition p1) {
        this.position.x = p1.x;
        this.position.y = p1.y;
    }

    public List<IChess.ChessPosition> getPossibleMoves(Board board){
        try{
            return imove.getPieceMoves(position, board);
        } catch (OutOfBoardException e) {

        }
        return null;
    }

}
