package com.example.ChessGameService;

import com.example.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessGameService {

    public Board board;
    public Helper helper;
    @Autowired
    public ChessGameService(Board board, Helper helper){
        this.board=board;
        this.helper=helper;
    }

    public void movePiece(int srcX, int srcY, int desX, int desY) {

        helper.movePiece(board,board.spot[srcX][srcY],board.spot[desX][desY]);

    }

    public boolean isMoveValid(int srcX, int srcY, int desX, int desY) {
        // Implement logic to check if a move is valid
        return board.spot[srcX][srcY].getPiece().validateMove(board,board.spot[srcX][srcY],board.spot[desX][desY],helper);
    }

    public boolean isCheck(int desX,int desY) {
        // Implement logic to check if a player is in check
        return helper.checkHelper(board,board.spot[desX][desY],helper);
    }

    public boolean isCheckSelf(int desX,int desY) {
        // Implement logic to check if a player is in check
        return helper.checkHelperSelf(board,board.spot[desX][desY],helper);
    }

    public boolean isValidSpot(int srcX,  int srcY, int desX, int desY){
        return helper.isValidSpot(board,desX,srcX,desY,srcY);
    }

    public boolean isEmpty(int srcX, int srcY){
        return helper.isEmpty(board.spot[srcX][srcY]);
    }

}
