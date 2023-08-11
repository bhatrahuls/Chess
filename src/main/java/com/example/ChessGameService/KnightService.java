package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Math;

@Service
public class KnightService extends ModelService{

    private final Board board;
    private Spots[][] spot;

    @Autowired
    public KnightService(Board board){
        this.board=board;
        this.spot=board.getSpot();
    }

    public boolean validateMove(Board board, Spots curSpot, Spots desSpot) {

        //destination
        int desX=desSpot.getX();
        int desY=desSpot.getY();

        //source
        int curX=curSpot.getX();
        int curY=curSpot.getY();

        if((spot[desX][desY].getPiece() == null || spot[desX][desY].getPiece().isWhite() != spot[curX][curY].getPiece().isWhite()))
        {
            //logic
            return Math.abs(desX-curX)*Math.abs(desY-curY)==2;
        }
        return false;
    }

    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {

        return this.validateMove(board,curSpot,desSpot);
    }
}
