package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class LostPieces {
    private List<Piece> lostPieces = new ArrayList<>();

    public LostPieces() {
        lostPieces = new ArrayList<Piece>();

    }

    public void lostPieces(Piece piece) {
        lostPieces.add(piece);
    }

    public List<IChess.ChessType> getLostPiecesType(IChess.ChessColor color) {
        List<IChess.ChessType> lostPiecesType = new ArrayList<>();
        for (Piece piece : lostPieces) {
            if (piece.getColor() == color) {
                lostPiecesType.add(piece.getType());
            }
        }
        return lostPiecesType;
    }
}
