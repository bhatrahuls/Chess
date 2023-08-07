package com.example.ChessApplication;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.lang.Math;

public class Knight extends Piece{
    //Function to validate the given move for Knight
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {

        //destination
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        //source
        int curX=curSpot.getX();
        int curY=curSpot.getY();

        if((board.spot[desX][desY].getPiece() == null || board.spot[desX][desY].getPiece().isWhite() != board.spot[curX][curY].getPiece().isWhite()))
        {
            //logic
            return Math.abs(desX-curX)*Math.abs(desY-curY)==2;
        }
        return false;
    }

    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot, Helper helper) {

        return this.validateMove(board,curSpot,desSpot,helper);
    }
}
