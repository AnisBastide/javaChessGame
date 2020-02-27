package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Undo {
    private IChess.ChessPosition p0;
    private IChess.ChessPosition p1;
    private Piece removedPiece;
    public void setUndo(IChess.ChessPosition p0,IChess.ChessPosition p1, Piece removedPiece){
        this.p0=p0;
        this.p1=p1;
        this.removedPiece=removedPiece;
    }
    public boolean undo(Board board){
        try {
            board.moveUndo(this.p1, this.p0);
           board.addPieces(removedPiece);
            return true;
        } catch (Exception e) {
            System.out.println("t nul");
            return false;
        }

    }
}
