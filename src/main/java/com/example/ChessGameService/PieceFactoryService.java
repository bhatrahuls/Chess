package com.example.ChessGameService;

import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PieceFactoryService {
    private Piece piece;

    @Autowired
    private KnightService knightService;
    @Autowired
    private BishopService bishopService;
    @Autowired
    private KingService kingService;
    @Autowired
    private PawnService pawnService;
    @Autowired
    private QueenService queenService;
    @Autowired
    private RookService rookService;

    public Piece getNewPiece(String type,String color) {
        Piece p=null;
        switch(type){
            case "Pawn":
                p=new Pawn(pawnService);
                break;
            case "King":
                p=new King(kingService);
                break;
            case "Queen":
                p=new Queen(queenService);
                break;
            case "Knight":
                p = new Knight(knightService);
                break;
            case "Rook":
                p = new Rook(rookService);
                break;
            case "Bishop":
                p=new Bishop(bishopService);
                break;
        }
        if(p!=null && color.equals("w")){
            p.setWhite(true);
        }
        return p;
    }
}
