package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Undo {
    private IChess.ChessPosition sourcePosition;
    private IChess.ChessPosition finalPosition;
    private Piece removedPiece;
    private Piece pieceToMove;
    public void setUndo(IChess.ChessPosition p0,IChess.ChessPosition p1, Piece removedPiece,Piece pieceToUndo){
        this.sourcePosition =p0;
        this.finalPosition =p1;
        this.removedPiece=removedPiece;
        this.pieceToMove=pieceToUndo;
    }
    public Piece getPieceToMove(){
        return pieceToMove;
    }

    public IChess.ChessPosition getFinalPosition(){
        return finalPosition;
    }
    public IChess.ChessPosition getSourcePosition(){
        return sourcePosition;
    }
    public Piece getRemovedPiece(){
        return removedPiece;
    }
}
