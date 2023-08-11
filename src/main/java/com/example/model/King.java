package com.example.model;


import com.example.ChessGameService.KingService;
import org.springframework.beans.factory.annotation.Autowired;

public class King extends Piece{
    private final KingService validationService;

    @Autowired
    public King(KingService kingService){
        this.validationService=kingService;
    }

    public KingService getValidationService() {
        return validationService;
    }
}
