package com.example.ChessApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BishopTest {

    @Test
    void validateMoveBishopMovement() {
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[0][1].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[1][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[1][2].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[1][6].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[2][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][6].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[5][2].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[5][6].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[3][4], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[0][1], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[0][7], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][4], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][2], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][6], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[3][3], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[3][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][2], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][3], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][3], helper));
//        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][3], helper));

    }

    @Test
    void isCheckWhenSameColorKingIsAttackedDueToMovement() {
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[5][2].setPiece(board.pieceFactory.getNewPiece("Bishop","b"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("king","w"));
        board.spot[6][3].setPiece(board.pieceFactory.getNewPiece("king","b"));

//        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][5], helper));



    }
    @Test
    void isCheckThisFunction(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[5][6].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertTrue(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[5][6],helper));

    }
    @Test
    void falseISCheck(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[2][6].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertFalse(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[2][6],helper));

    }
    @Test
    void notGiveCheckToItsOwnKing(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[5][6].setPiece(board.pieceFactory.getNewPiece("King","w"));
        assertFalse(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[5][6],helper));

    }
    @Test
    void notGiveCheckToWithoutKingSpot(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop","w"));
        board.spot[5][6].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertFalse(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[0][0],helper),"not in Bishop Route");

    }
}