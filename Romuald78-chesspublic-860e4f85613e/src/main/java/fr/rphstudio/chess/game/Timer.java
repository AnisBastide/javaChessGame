package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Timer {
    private int whiteTimer=0;
    private int blackTimer=0;
    public int getTimer(IChess.ChessColor color, boolean isPlaying){
        if(color== IChess.ChessColor.CLR_WHITE){
            if(isPlaying){
                whiteTimer++;
                return whiteTimer*17;
            }
            else{
                return whiteTimer*17;
            }
        }
        else if(color== IChess.ChessColor.CLR_BLACK){
            if(isPlaying){
                blackTimer++;
                return blackTimer*17;
            }
            else{
                return blackTimer*17;
            }
        }
        return 0;
    }
}
