package com.example.ChessApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Board board;
    private Helper helper;
    @BeforeEach
    void setup(){
        board=new Board();
        helper=new Helper();
        board.resetBoard();
    }

    /*
    ************************************************************************************************************
    WITHOUT ANY HURDLES
    *************************************************************************************************************
     */
    @Test
    @DisplayName("Without any hurdles")
    void validateMove1() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][0],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }
    /*
    ************************************************************************************************************
    WITH HURDLE PAWN OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Pawn of same color")
    void validateMove2() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE ROOK OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Rook of same color")
    void validateMove3() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE KNIGHT OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Knight of same color")
    void validateMove4() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE BISHOP OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Bishop of same color")
    void validateMove5() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }


    /*
    ************************************************************************************************************
    WITH HURDLE KING OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle King of same color")
    void validateMove6() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("King", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("King", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }


    /*
    ************************************************************************************************************
    WITH HURDLE QUEEN OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Queen of same color")
    void validateMove7() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE PAWN OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Pawn of different color")
    void validateMove8() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");


    }

    /*
    ************************************************************************************************************
    WITH HURDLE ROOK OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Rook of different color")
    void validateMove9() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE KNIGHT OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Knight of different color")
    void validateMove10() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITH HURDLE BISHOP OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Bishop of different color")
    void validateMove11() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }


    /*
    ************************************************************************************************************
    WITH HURDLE KING OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle King of different color")
    void validateMove12() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("King", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("King", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }


    /*
    ************************************************************************************************************
    WITH HURDLE QUEEN OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("With hurdle Queen of different color")
    void validateMove13() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][6],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][6],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards to destination ");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][2],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][2],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][5],helper),"Horizontally Right to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][3],helper),"Horizontally Left to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[2][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards to destination");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[6][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().validateMove(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }



    /*
    ************************************************************************************************************
    WITHOUT ANY HURDLES BUT OF SAME COLOR
    *************************************************************************************************************
     */



    @Test
    @DisplayName("Check without any hurdles but of same color")
    void isCheck1() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));

        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[7][0].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[4][6].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[4][2].setPiece(board.pieceFactory.getNewPiece("King","w"));
        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));


        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][0],helper),"Diagonally Left Corner downwards");

        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    WITHOUT ANY HURDLES BUT OF DIFFERENT COLOR
    *************************************************************************************************************
     */



    @Test
    @DisplayName("Check without any hurdles but of different color")
    void isCheck2() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));

        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[7][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][6].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[4][2].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[0][4].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("King","b"));
        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));


        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][5],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][5],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right Corner downwards");

        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][3],helper),"Diagonally Left upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Left Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][3],helper),"Diagonally Left downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][0],helper),"Diagonally Left Corner downwards");

        assertTrue(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][6],helper),"Horizontally Right");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Horizontally Right Corner");
        assertTrue(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][2],helper),"Horizontally Left");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Horizontally Left Corner");

        assertTrue(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[3][4],helper),"Vertically upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][4],helper),"Vertically upwards Corner");
        assertTrue(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[5][4],helper),"Vertically downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Vertically downwards Corner");

    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE PAWN OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Pawn of same color")
    void isCheck3() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[5][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "w"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE ROOK OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Rook of same color")
    void isCheck4() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Rook", "w"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE KNIGHT OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Knight of same color")
    void isCheck5() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Knight", "w"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE BISHOP OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Bishop of same color")
    void isCheck6() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "w"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE QUEEN OF SAME COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Queen of same color")
    void isCheck7() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Queen", "w"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","w"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","w"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE PAWN OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Pawn of different color")
    void isCheck8() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Pawn", "b"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE ROOK OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Rook of different color")
    void isCheck9() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Rook", "b"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE KNIGHT OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Knight of different color")
    void isCheck10() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Knight", "b"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE BISHOP OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Bishop of different color")
    void isCheck11() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Bishop", "b"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

    /*
    ************************************************************************************************************
    CHECK WITH HURDLE QUEEN OF DIFFERENT COLOR
    *************************************************************************************************************
     */

    @Test
    @DisplayName("Check with hurdle Queen of different color")
    void isCheck12() {

        board.spot[4][4].setPiece(board.pieceFactory.getNewPiece("Rook","w"));
        board.spot[3][3].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[3][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[3][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[4][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][5].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[5][4].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));
        board.spot[4][3].setPiece(board.pieceFactory.getNewPiece("Queen", "b"));

        board.spot[0][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][0].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][1].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][4].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[7][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[4][7].setPiece(board.pieceFactory.getNewPiece("King","b"));

        board.spot[1][7].setPiece(board.pieceFactory.getNewPiece("King","b"));



        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[0][0],helper),"Diagonally Right upwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][0],helper),"Diagonally Right upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][1],helper),"Diagonally Right Corner upwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][4],helper),"Diagonally Right downwards to destination");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[7][7],helper),"Diagonally Right downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[4][7],helper),"Diagonally Right Corner downwards");
        assertFalse(board.spot[4][4].getPiece().isCheck(board, board.spot[4][4],board.spot[1][7],helper),"Diagonally Right Corner downwards");


    }

}