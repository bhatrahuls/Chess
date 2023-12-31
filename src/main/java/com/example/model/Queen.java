package com.example.model;

import com.example.ChessGameService.Helper;

public class Queen extends Piece{
    @Override
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot, Helper helper) {
        //destination
        int desX = desSpot.getX();
        int desY = desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();


        //In case of horizontal/vertical moves
        //check for hurdles(other pieces) in the way
        if (board.spot[desX][desY].getPiece() == null || board.spot[desX][desY].getPiece().isWhite() != board.spot[curX][curY].getPiece().isWhite()) {
            if ((desX == curX) || (desY == curY)) {
                if (desX > curX) {
                    for (int i = curX + 1; i < desX; i++) {
                        if (!(board.spot[i][desY].getPiece() == null))
                            return false;
                    }
                } else if (desX < curX) {
                    for (int i = curX - 1; i > desX; i--) {
                        if (!(board.spot[i][desY].getPiece() == null))
                            return false;
                    }
                } else if (desY > curY) {
                    for (int i = curY+1; i < desY; i++) {
                        if (!(board.spot[desX][i].getPiece() == null))
                            return false;
                    }
                } else {
                    for (int i = curY-1; i > desY; i--) {
                        if (!(board.spot[desX][i].getPiece() == null))
                            return false;
                    }
                }
                return true;

            }


            //in case of diagonal moves
            //check for hurdles(other pieces) in the way
            else if (((curX - desX) == (curY - desY)) || ((curX - desX) == (-1) * (curY - desY))) {
                int incementX = (curX > desX) ? -1 : 1;
                int incementY = (curY > desY) ? -1 : 1;
                while (curX != (desX-incementX)  && curY != (desY-incementY)) {
                    curX = curX + incementX;
                    curY = curY + incementY;
                    if (board.spot[curX][curY].getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean isCheck(Board board, Spots curSpot, Spots desSpot,Helper helper) {


        return (this.validateMove(board,curSpot,desSpot,helper));



    }

}

