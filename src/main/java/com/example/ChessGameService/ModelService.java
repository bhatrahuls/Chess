package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;

public abstract class ModelService {

    private ModelService validationService;

    public ModelService getValidationService() {
        return validationService;
    }

    public void setValidationService(ModelService validationService) {
        this.validationService = validationService;
    }

    public abstract boolean validateMove(Board board, Spots curSpot, Spots desSpot);
    public abstract boolean isCheck(Board board, Spots curSpot, Spots desSpot);
}
