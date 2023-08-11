package com.example.model;

import com.example.ChessGameService.BishopService;
import com.example.ChessGameService.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

public class Bishop extends Piece {

    private final BishopService validationService;
    @Autowired
    public Bishop(BishopService bishopService){
        this.validationService= bishopService;
    }

    public BishopService getValidationService() {
        return validationService;
    }


}
