package com.example.ChessApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void validateCaptureMoveInsideBoardInAllPossiblePlaces() {
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[1][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[1][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[2][2].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[2][6].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[4][2].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[4][6].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][3], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][2], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][2], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][3], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][5], helper));

    }
    @Test
    void sholudNotCptureSameColorPieces(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[1][3].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[1][5].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[2][2].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[2][6].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[4][2].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[4][6].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        Piece knight = board.spot[3][4].getPiece();
        assertFalse(knight.validateMove(board, board.spot[3][4], board.spot[1][3], helper), "Scenario 1");
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][5], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][2], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][6], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][2], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][6], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][3], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][5], helper));

    }
    @Test
    void shouldMoveToEmptySpot(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][3], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[1][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][2], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[2][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][2], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][6], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][3], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][5], helper));

    }
    @Test
    void shouldNotMoveToWrongSpots(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[0][0], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[3][4], helper));
        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][4], helper));

    }

    @Test
    void isCheckWhenSameColorKingIsAttackedDueToMovement() {
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[5][2].setPiece(board.pieceFactory.getNewPiece("Bishop","b"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("king","w"));
//        board.spot[6][3].setPiece(board.pieceFactory.getNewPiece("king","b"));

//        assertFalse(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[4][5], helper));
        assertTrue(board.spot[3][4].getPiece().validateMove(board, board.spot[3][4], board.spot[5][5], helper));


    }
    @Test
    void isCheckThisFunction(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertTrue(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[5][5],helper));

    }

    @Test
    void notGiveCheckToItsOwnKing(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King","w"));
        assertFalse(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[5][5],helper));

    }
    @Test
    void falseIsCheck(){
        Board board = new Board();
        Helper helper = new Helper();
        board.resetBoard();
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight","w"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertFalse(board.spot[3][4].getPiece().isCheck(board,board.spot[3][4],board.spot[2][5],helper));

    }
}