package com.example.ChessApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    private Board board;
    private Helper helper;


//    @BeforeAll
//    void Setup(){
//        board = new Board();
//        helper = new Helper();
//        board.resetBoard();
//    }

    @BeforeEach
    void beforeEach(){
        board = new Board();
        helper = new Helper();
        board.resetBoard();

    }

    @Test
    void validateMoveQueenInAllDirectionCapture() {
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen","w"));
        board.spot[3][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][0].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][1].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[7][0].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[6][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        Piece queen = board.spot[3][4].getPiece();
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[3][7], helper),"Moving Right");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper),"moving Left");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][4], helper),"moving Up");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[7][4], helper),"moving down");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][7], helper),"moving up right diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][1], helper),"moving up left diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[7][0], helper),"moving down left diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[6][7], helper),"moving down right diagonally");
    }
    @Test
    void validateMoveQueenInAllDirectionShouldNotCaptureSameColorPiece() {
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen","w"));
        board.spot[3][7].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[3][0].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[0][4].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[0][7].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[0][1].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[7][0].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[6][7].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));

        Piece queen = board.spot[3][4].getPiece();
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][7], helper),"Moving Right");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper),"moving Left");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][4], helper),"moving Up");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][4], helper),"moving down");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][7], helper),"moving up right diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][1], helper),"moving up left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][0], helper),"moving down left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[6][7], helper),"moving down right diagonally");
    }


    @Test
    void validateMoveQueenInAllDirectionShouldNotJumpOverPiece() {
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen","w"));
//        white pieces srounding Queen
        board.spot[2][3].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[2][4].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn","w"));
//        black target pieces
        board.spot[3][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][0].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[0][1].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[7][0].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[6][7].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        Piece queen = board.spot[3][4].getPiece();
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][7], helper),"Moving Right");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper),"moving Left");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][4], helper),"moving Up");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][4], helper),"moving down");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][7], helper),"moving up right diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][1], helper),"moving up left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][0], helper),"moving down left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[6][7], helper),"moving down right diagonally");

//        black pieces surrounding queen
        board.spot[2][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[2][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn","b"));
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][7], helper),"Moving Right");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper),"moving Left");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][4], helper),"moving Up");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][4], helper),"moving down");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][7], helper),"moving up right diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][1], helper),"moving up left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[7][0], helper),"moving down left diagonally");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[6][7], helper),"moving down right diagonally");
    }
    @Test
    void shouldMoveToEmptySpot(){
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen","w"));
        Piece queen = board.spot[3][4].getPiece();
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[3][7], helper),"Moving Right");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper),"moving Left");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][4], helper),"moving Up");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[7][4], helper),"moving down");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][7], helper),"moving up right diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[0][1], helper),"moving up left diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[7][0], helper),"moving down left diagonally");
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[6][7], helper),"moving down right diagonally");

    }
    @Test
    void shouldNotMoveToWrongSpot(){
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen","w"));
        Piece queen = board.spot[3][4].getPiece();
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[3][4], helper),"moved to it's own spot");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[5][5], helper),"knight Move");
        assertFalse(queen.validateMove(board, board.spot[3][4], board.spot[0][0], helper),"can not go there");

    }
    @Test
    void isCheckWhenSameColorKingIsAttackedDueToMovement() {
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        Piece queen = board.spot[3][4].getPiece();

        board.spot[5][2].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[2][5].setPiece(board.pieceFactory.getNewPiece("king", "w"));
        assertTrue(queen.validateMove(board, board.spot[3][4], board.spot[3][0], helper));
    }


    @Test
    void isCheckThisFunction(){
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        Piece queen = board.spot[3][4].getPiece();

        board.spot[3][0].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[3][7].setPiece(board.pieceFactory.getNewPiece("King","w"));
        assertTrue(queen.isCheck(board,board.spot[3][4],board.spot[3][0],helper),"check to opponent king");
        assertFalse(queen.isCheck(board,board.spot[3][4],board.spot[3][7],helper),"check to self king");
        board.spot[2][0].setPiece(board.pieceFactory.getNewPiece("King","b"));
        assertFalse(queen.isCheck(board,board.spot[3][4],board.spot[3][7],helper),"check Not Possible, Not in attack line");
    }

}