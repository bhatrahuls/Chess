package com.example.model;
import com.example.ChessGameService.KnightService;
import org.springframework.beans.factory.annotation.Autowired;

public class Knight extends Piece{

    private final KnightService validationService;

    @Autowired
    public Knight(KnightService knightService){
        this.validationService=knightService;
    }

    public KnightService getValidationService() {
        return validationService;
    }

}
