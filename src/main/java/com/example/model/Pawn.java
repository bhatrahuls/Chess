package com.example.model;

import com.example.ChessGameService.ModelService;
import com.example.ChessGameService.PawnService;
import org.springframework.beans.factory.annotation.Autowired;


public class Pawn extends Piece{
    private final PawnService validationService;

    @Autowired
    public Pawn(PawnService pawnService){
        this.validationService=pawnService;
    }

    public PawnService getValidationService() {
        return validationService;
    }
}
