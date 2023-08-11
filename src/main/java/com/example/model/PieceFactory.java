package com.example.model;
import org.springframework.beans.factory.annotation.Autowired;


public class PieceFactory{
    private PieceFactory pieceFactory;

    @Autowired
    public PieceFactory(PieceFactory pieceFactory){
        this.pieceFactory=pieceFactory;
    }

}