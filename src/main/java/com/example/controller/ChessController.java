package com.example.controller;

import com.example.ChessGameService.BoardService;
import com.example.ChessGameService.ChessGameHelperService;
import com.example.model.Board;
import com.example.model.MoveRequest;
import com.example.model.Piece;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChessController {

    private ChessGameHelperService chessGameHelperService;
    private BoardService boardService;
    private Board board;
    private Spots[][] spot;
    private int count=0;
    private int[] whiteKing;
    private int[] blackKing;

    @Autowired
    public ChessController(ChessGameHelperService chessGameHelperService, BoardService boardService, Board board){
        this.chessGameHelperService = chessGameHelperService;
        this.boardService=boardService;
        this.board=board;
        this.spot= board.getSpot();
        this.whiteKing= board.getWhiteKing();
        this.blackKing=board.getBlackKing();
        boardService.resetBoard();
        boardService.initialize();
    }

    @PostMapping("move")
    public ResponseEntity<String> movePiece(@RequestBody MoveRequest moveRequest) {
        boardService.displayBoard();
        while (true) {
            int srcX = moveRequest.getSrcX();
            int srcY = moveRequest.getSrcY();
            int desX = moveRequest.getDesX();
            int desY = moveRequest.getDesY();

            if(count % 2 ==0){
                System.out.println("White turn");
            }
            else
            {
                System.out.println("Black turn");
            }

            System.out.print(srcX+" "+srcY+" "+desX+" "+desY);
            if (board.getSpot()[srcX][srcY].getPiece() == null)
                return ResponseEntity.badRequest().body("Invalid move.");


            if (chessGameHelperService.isValidSpot(srcX, srcY, desX, desY)) {
                if (chessGameHelperService.isMoveValid(srcX, srcY, desX, desY)) {
                    if (count % 2 == 0) {
                        if (!board.getSpot()[srcX][srcY].getPiece().isWhite()) {
                            return ResponseEntity.badRequest().body("Invalid move.");
                        }

                        Piece temp = spot[desX][desY].getPiece();
                        chessGameHelperService.movePiece(srcX, srcY, desX, desY);

                        if (chessGameHelperService.isCheckSelf(whiteKing[0], whiteKing[1])) {
                            spot[srcX][srcY].setPiece(spot[desX][desY].getPiece());
                            spot[desX][desY].setPiece(temp);
                            return ResponseEntity.badRequest().body("You will get a check");
                        }

                        if (chessGameHelperService.isCheck(blackKing[0], blackKing[1])) {
                            board.setSpot(spot);
                            return ResponseEntity.ok("Piece moved successfully. And there is a check to the opposite king.");
                        }
                        board.setSpot(spot);
                    }
                    else {
                        if (spot[srcX][srcY].getPiece().isWhite()) {
                            return ResponseEntity.badRequest().body("Invalid move.");
                        }

                        Piece temp = spot[desX][desY].getPiece();
                        chessGameHelperService.movePiece(srcX, srcY, desX, desY);

                        if (chessGameHelperService.isCheckSelf(blackKing[0], blackKing[1])) {
                            spot[srcX][srcY].setPiece(spot[desX][desY].getPiece());
                            spot[desX][desY].setPiece(temp);
                            return ResponseEntity.badRequest().body("You will get a check");
                        }

                        if (chessGameHelperService.isCheck(whiteKing[0], whiteKing[1])) {
                        if (chessGameHelperService.isCheck(whiteKing[0], whiteKing[1])) {
                            board.setSpot(spot);
                            return ResponseEntity.ok("Piece moved successfully. And there is a check to the opposite king.");
                        }
                        board.setSpot(spot);
                    }
                    count++;
                    // Return appropriate response
                    boardService.displayBoard();
                    return ResponseEntity.ok("Piece moved successfully.");
                }
                return ResponseEntity.badRequest().body("Invalid move.");
            }
            return ResponseEntity.badRequest().body("Invalid positions.");
        }
    }
}
}





