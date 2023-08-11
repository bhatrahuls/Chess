package com.example.model;

import com.example.ChessGameService.QueenService;
import org.springframework.beans.factory.annotation.Autowired;

public class Queen extends Piece{

    private final QueenService validationService;

    @Autowired
    public Queen(QueenService queenService){
        this.validationService=queenService;
    }

    public QueenService getValidationService() {
        return validationService;
    }
}

