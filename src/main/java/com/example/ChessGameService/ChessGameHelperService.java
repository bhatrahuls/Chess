package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessGameHelperService {

    private final Board board;
    private Spots[][] spot;
    private int[] whiteKing;
    private int[] blackKing;
    @Autowired
    public ChessGameHelperService(Board board){
        this.board=board;
        this.spot= board.getSpot();
        this.blackKing= board.getBlackKing();
        this.whiteKing=board.getWhiteKing();
    }

    public void movePiece(int srcX, int srcY, int desX, int desY) {

        //setting destination to the piece at source
        spot[desX][desY].setPiece(spot[srcX][srcY].getPiece());

        //setting the source position as empty
        spot[srcX][srcY].setPiece(null);

        //get color

        //if the piece moved is King, store its new position
        if("King".equals(spot[desX][desY].getPiece().getClass().getSimpleName())){
            if(spot[desX][desY].getPiece().isWhite()){
                whiteKing[0]=desX;
                whiteKing[1]=desY;
                board.setWhiteKing(whiteKing);
            }
            else{
                blackKing[0]=desX;
                blackKing[1]=desY;
                board.setBlackKing(blackKing);
            }
        }
        //to know if the piece was moved anytime in game
        if(!spot[desX][desY].getPiece().isEverMoved()){
            spot[desX][desY].getPiece().setEverMoved(true);
        }
        board.setSpot(spot);

    }

    public boolean isMoveValid(int srcX, int srcY, int desX, int desY) {
        // Implement logic to check if a move is valid
        ModelService validationService=spot[srcX][srcY].getPiece().getValidationService();
        return validationService.validateMove(board,spot[srcX][srcY],spot[desX][desY]);
    }

    public boolean isCheck(int desX,int desY) {
        // Implement logic to check if a player is in check
        boolean flag=false;
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if((spot[i][j].getPiece()!=null) && (spot[i][j].getPiece().isWhite() != spot[desX][desY].getPiece().isWhite())){
                    if(spot[i][j].getPiece().getValidationService().isCheck(board,spot[i][j],spot[desX][desY])){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        return flag;
    }

    public boolean isCheckSelf(int desX,int desY) {
        // Implement logic to check if a player is in check
        boolean flag=false;
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if((spot[i][j].getPiece()!=null) && (spot[i][j].getPiece().isWhite() != spot[desX][desY].getPiece().isWhite())){
                    if(spot[i][j].getPiece().getValidationService().isCheck(board,spot[i][j],spot[desX][desY])){
                        flag=true;
                        System.out.println("It is a check from"+spot[i][j].getPiece() );
                        System.out.println(spot[i][j].getPiece().isWhite());
                        System.out.print(i+" "+j);
                        System.out.println();
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        return flag;
    }


    public boolean isValidSpot(int srcX,  int srcY, int desX, int desY){
        if (desX>7 || desX<0 || desY<0 || desY>7) {
            System.out.println("Invalid destination");
            return false;
        }

        //If source and destination are same, don't do anything
        if(srcX==desX && srcY==desY)
            return false;

        //Move is invalid is source is empty
        if(this.isEmpty(srcX, srcY)){
            System.out.println("Source is empty");
            return false;
        }


        //check if the destination spot has a King
        if(spot[desX][desY].getPiece()!=null){
            if("King".equals(spot[desX][desY].getPiece().getClass().getSimpleName())){
                System.out.println("Invalid move");
                return false;
            }
        }
        return true;
    }


    public boolean isEmpty(int srcX, int srcY){
        try{
            spot[srcX][srcY].getPiece().isWhite();
        }
        catch(Exception e){
            System.out.println("Source is empty");
            return true;
        }
        return false;
    }

}
