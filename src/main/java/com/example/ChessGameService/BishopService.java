package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BishopService extends ModelService{

    private final Board board;
    private Spots[][] spot;

    @Autowired
    public BishopService(Board board){
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


        if (((curX - desX) == (curY - desY)) || ((curX - desX) == (-1) * (curY - desY))) {
            if (spot[desX][desY].getPiece() == null || spot[desX][desY].getPiece().isWhite() != spot[curX][curY].getPiece().isWhite()) {
                int incrementX = (curX > desX) ? -1 : 1;
                int incrementY = (curY > desY) ? -1 : 1;
                while (curX != (desX - incrementX) && curY != (desY - incrementY)) {
                    curX = curX + incrementX;
                    curY = curY + incrementY;
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
        return this.validateMove(board,curSpot,desSpot);

    }
}
