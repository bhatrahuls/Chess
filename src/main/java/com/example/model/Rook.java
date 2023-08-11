package com.example.model;


import com.example.ChessGameService.RookService;
import org.springframework.beans.factory.annotation.Autowired;

public class Rook extends Piece{
    private final RookService validationService;

    @Autowired
    public Rook(RookService rookService){
        this.validationService=rookService;
    }

    public RookService getValidationService() {
        return validationService;
    }
}