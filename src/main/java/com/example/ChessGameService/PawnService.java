package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Pawn;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PawnService extends ModelService{

    private final Board board;
    private Spots[][] spot;

    @Autowired
    public PawnService(Board board){
        this.board=board;
        this.spot=board.getSpot();
    }
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot) {
        //destination
        int destX=desSpot.getX();
        int destY=desSpot.getY();

        //source
        int curX = curSpot.getX();
        int curY = curSpot.getY();


        boolean valid = false;
        boolean destOccupied = spot[destX][destY].getPiece() != null;
        boolean isSrcWhite = curSpot.getPiece().isWhite();
        int flag = isSrcWhite? -1: 1;
        if(destY == curY && !destOccupied){
            if(destX - curX == flag){
                valid = true;
            }
            else if(destX - curX == (2 * flag) && !curSpot.getPiece().isEverMoved() && spot[curX + flag][destY].getPiece() == null){
                valid = true;
            }
        }
        else if(destX - curX == flag && Math.abs(destY-curY) == 1 && destOccupied){
            boolean isDestWhite = spot[destX][destY].getPiece().isWhite();
            if(isDestWhite != isSrcWhite){
                valid = true;
            }
        }
        //double step cancellation functionality to be added
        return valid;
    }

    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {
        return this.validateMove(board,curSpot,desSpot);

    }
}
