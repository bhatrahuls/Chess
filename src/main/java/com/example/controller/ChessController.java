package com.example.controller;

import com.example.ChessGameService.ChessGameService;
import com.example.ChessGameService.Helper;
import com.example.model.Board;
import com.example.model.MoveRequest;
import com.example.model.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChessController {

    private ChessGameService chessGameService;
    private Board board;

    private Helper helper;

    private int count=0;


    @Autowired
    public ChessController(ChessGameService chessGameService, Board board, Helper helper){
        this.chessGameService=chessGameService;
        this.board=board;
        this.helper=helper;
        board.resetBoard();
        board.initialize();
    }

    @PostMapping("move")
    public ResponseEntity<String> movePiece(@RequestBody MoveRequest moveRequest) {
        board.displayBoard();
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
            if (board.spot[srcX][srcY].getPiece() == null)
                return ResponseEntity.badRequest().body("Invalid move.");


            if (chessGameService.isValidSpot(srcX, srcY, desX, desY)) {
                if (chessGameService.isMoveValid(srcX, srcY, desX, desY)) {
                    if (count % 2 == 0) {
                        if (!board.spot[srcX][srcY].getPiece().isWhite()) {
                            return ResponseEntity.badRequest().body("Invalid move.");
                        }

                        Piece temp = board.spot[desX][desY].getPiece();
                        chessGameService.movePiece(srcX, srcY, desX, desY);

                        if (chessGameService.isCheckSelf(board.whiteKing[0], board.whiteKing[1])) {
                            board.spot[srcX][srcY].setPiece(board.spot[desX][desY].getPiece());
                            board.spot[desX][desY].setPiece(temp);
                            return ResponseEntity.badRequest().body("You will get a check");
                        }

                        if (chessGameService.isCheck(board.blackKing[0], board.blackKing[1])) {
                            return ResponseEntity.ok("Piece moved successfully. And there is a check to the opposite king.");
                        }
                    }
                    else {
                        if (board.spot[srcX][srcY].getPiece().isWhite()) {
                            return ResponseEntity.badRequest().body("Invalid move.");
                        }

                        Piece temp = board.spot[desX][desY].getPiece();
                        chessGameService.movePiece(srcX, srcY, desX, desY);

                        if (chessGameService.isCheckSelf(board.blackKing[0], board.blackKing[1])) {
                            board.spot[srcX][srcY].setPiece(board.spot[desX][desY].getPiece());
                            board.spot[desX][desY].setPiece(temp);
                            return ResponseEntity.badRequest().body("You will get a check");
                        }

                        if (chessGameService.isCheck(board.whiteKing[0], board.whiteKing[1])) {
                            return ResponseEntity.ok("Piece moved successfully. And there is a check to the opposite king.");
                        }
                    }
                    count++;
                    // Return appropriate response
                    board.displayBoard();
                    return ResponseEntity.ok("Piece moved successfully.");
                }
                return ResponseEntity.badRequest().body("Invalid move.");
            }
            return ResponseEntity.badRequest().body("Invalid positions.");
        }
    }
}




