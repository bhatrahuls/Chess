package com.example.model;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PieceFactory{
    public Piece piece;
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
        if(p!=null && color.equals("w")){
                p.setWhite(true);
        }
        return p;
    }
}