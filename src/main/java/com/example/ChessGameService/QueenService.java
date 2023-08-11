package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueenService extends ModelService{

    private final Board board;
    private Spots[][] spot;

    @Autowired
    public QueenService(Board board){
        this.board=board;
        this.spot= board.getSpot();
    }

    public boolean validateMove(Board board, Spots curSpot, Spots desSpot) {
        //destination
        int desX = desSpot.getX();
        int desY = desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();


        //In case of horizontal/vertical moves
        //check for hurdles(other pieces) in the way
        if (spot[desX][desY].getPiece() == null || spot[desX][desY].getPiece().isWhite() != spot[curX][curY].getPiece().isWhite()) {
            if ((desX == curX) || (desY == curY)) {
                if (desX > curX) {
                    for (int i = curX + 1; i < desX; i++) {
                        if (!(spot[i][desY].getPiece() == null))
                            return false;
                    }
                } else if (desX < curX) {
                    for (int i = curX - 1; i > desX; i--) {
                        if (!(spot[i][desY].getPiece() == null))
                            return false;
                    }
                } else if (desY > curY) {
                    for (int i = curY+1; i < desY; i++) {
                        if (!(spot[desX][i].getPiece() == null))
                            return false;
                    }
                } else {
                    for (int i = curY-1; i > desY; i--) {
                        if (!(spot[desX][i].getPiece() == null))
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
                    if (spot[curX][curY].getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {


        return (this.validateMove(board,curSpot,desSpot));



    }
}
