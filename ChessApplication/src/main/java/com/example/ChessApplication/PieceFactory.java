package com.example.ChessApplication;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


public class PieceFactory{

    public Piece getNewPiece(String type,String color) {
        Piece p=null;

        switch(type){
            case "Pawn":
                p=new Pawn();
                break;
            case "King":
                p=new King();
                break;
            case "Queen":
                p=new Queen();
                break;
            case "Knight":
                p = new Knight();
                break;
            case "Rook":
                p = new Rook();
                break;
            case "Bishop":
                p=new Bishop();
                break;
        }
        if(color.equals("w")){
            try{
                p.setWhite(true);
            }
            catch (Exception e){
                
            }
        }

        return p;
    }


}
