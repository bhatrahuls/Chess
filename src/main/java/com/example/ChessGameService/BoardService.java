package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Piece;
import com.example.model.PieceFactory;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final PieceFactoryService pieceFactoryService;
    private final Board board;

    private Spots[][] spot;

    @Autowired
    public BoardService(PieceFactoryService pieceFactoryService, Board board){
        this.pieceFactoryService=pieceFactoryService;
        this.board=board;
        this.spot=board.getSpot();
    }



    //public PieceFactory pieceFactory=new PieceFactory();
    //Function to deinitialize the pieces and set it to null
    public void resetBoard(){
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                spot[i][j] = new Spots(i,j,null);
            }
        }
        board.setSpot(spot);
        //Initialize the pieces back to their starting positions
    }



    //Function to initialize the pieces back to their starting position
    public void initialize(){

        //Black Pieces
        for(int i=0;i<8;i++){
            this.spot[1][i].setPiece(pieceFactoryService.getNewPiece("Pawn","b"));
        }
        spot[0][0].setPiece(pieceFactoryService.getNewPiece("Rook","b"));
        spot[0][1].setPiece(pieceFactoryService.getNewPiece("Knight","b"));
        spot[0][2].setPiece(pieceFactoryService.getNewPiece("Bishop","b"));
        spot[0][3].setPiece(pieceFactoryService.getNewPiece("Queen","b"));
        spot[0][4].setPiece(pieceFactoryService.getNewPiece("King","b"));

        int[] blackKing= board.getBlackKing();
        blackKing[0]=0;
        blackKing[1]=4;
        board.setBlackKing(blackKing);

        spot[0][5].setPiece(pieceFactoryService.getNewPiece("Bishop","b"));
        spot[0][6].setPiece(pieceFactoryService.getNewPiece("Knight","b"));
        spot[0][7].setPiece(pieceFactoryService.getNewPiece("Rook","b"));

        //White Pieces
        for(int i=0;i<8;i++){
            spot[6][i].setPiece(pieceFactoryService.getNewPiece("Pawn","w"));
        }
        spot[7][7].setPiece(pieceFactoryService.getNewPiece("Rook","w"));
        spot[7][6].setPiece(pieceFactoryService.getNewPiece("Knight","w"));
        spot[7][5].setPiece(pieceFactoryService.getNewPiece("Bishop","w"));
        spot[7][4].setPiece(pieceFactoryService.getNewPiece("King","w"));

        int[] whiteKing= board.getWhiteKing();
        whiteKing[0]=7;
        whiteKing[1]=4;
        board.setWhiteKing(whiteKing);

        spot[7][3].setPiece(pieceFactoryService.getNewPiece("Queen","w"));
        spot[7][2].setPiece(pieceFactoryService.getNewPiece("Bishop","w"));
        spot[7][1].setPiece(pieceFactoryService.getNewPiece("Knight","w"));
        spot[7][0].setPiece(pieceFactoryService.getNewPiece("Rook","w"));
        board.setSpot(spot);

    }

    //Function to display board
    public void displayBoard(){

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("("+i+","+j+")");
                //Handle nullPointerException in case the spot contains no piece
                try {
                    if(spot[i][j].getPiece().isWhite()){
                        //display white pieces
                        System.out.print("White"+board.getSpot()[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }
                    else{
                        //display black pieces
                        System.out.print("Black"+spot[i][j].getPiece().getClass().getSimpleName() + "\t");
                    }

                }
                //Print null in case a spot is found empty
                catch (Exception e) {
                    System.out.print("        " + "\t");
                }
            }
            System.out.println();
        }

    }
}
