package com.example.model;

import com.example.ChessGameService.BoardService;
import com.example.ChessGameService.PieceFactoryService;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Board {

    //Spots are the squares on chessboard
    private Spots[][] spot=new Spots[8][8];
    private int whiteKing[]= new int[2];
    private int blackKing[]= new int[2];

    public Spots[][] getSpot() {
        return spot;
    }

    public void setSpot(Spots[][] spot) {
        this.spot = spot;
    }

    public int[] getWhiteKing() {
        return whiteKing;
    }

    public void setWhiteKing(int[] whiteKing) {
        this.whiteKing = whiteKing;
    }

    public int[] getBlackKing() {
        return blackKing;
    }

    public void setBlackKing(int[] blackKing) {
        this.blackKing = blackKing;
    }
}