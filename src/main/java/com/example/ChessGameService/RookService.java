package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Rook;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RookService extends ModelService {

    private final Board board;
    private Spots[][] spot;

    @Autowired
    public RookService(Board board){
        this.board=board;
        this.spot=board.getSpot();
    }
    public boolean validateMove(Board board, Spots curSpot, Spots desSpot) {
        //destination
        int desX=desSpot.getX();
        int desY= desSpot.getY();

        //Source
        int curX= curSpot.getX();
        int curY=curSpot.getY();

        //Check if the rook is moving in a single direction (horizontal/vertical and not both at a time)
        if(!(desX==curX || desY==curY))
            return false;

        //if the destination spot is empty
        if((spot[desX][desY].getPiece() == null) || (spot[desX][desY].getPiece().isWhite() != spot[curX][curY].getPiece().isWhite())){
            //check if there are any hurdles(other pieces) between the source and destination\
            if(desX>curX){
                for(int i=curX+1;i<desX;i++) {
                    if (spot[i][desY].getPiece() != null)
                        return false;
                }
            }
            else if(desX<curX){
                for(int i=curX-1;i>desX;i--){
                    if (spot[i][desY].getPiece() != null)
                        return false;
                }
            }
            else if(desY>curY){
                for(int i=curY+1;i<desY;i++){
                    if(spot[desX][i].getPiece()!=null)
                        return false;
                }
            }
            else{
                for(int i=curY-1;i>desY;i--){
                    if(spot[desX][i].getPiece()!=null)
                        return false;
                }
            }
            return true;
        }
        return false;
    }


    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {
        if(spot[desSpot.getX()][desSpot.getY()].getPiece() == null)
            return false;
        return this.validateMove(board,curSpot,desSpot);
    }

}
