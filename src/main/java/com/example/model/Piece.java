package com.example.model;

import com.example.ChessGameService.ModelService;

public abstract class Piece {
    private boolean isWhite=false;
    private boolean everMoved=false;

    private ModelService validationService;


    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
    public boolean isEverMoved() {
        return everMoved;
    }

    public void setEverMoved(boolean everMoved) {
        this.everMoved = everMoved;
    }

    public ModelService getValidationService() {
        return validationService;
    }

    public void setValidationService(ModelService validationService) {
        this.validationService = validationService;
    }
}
