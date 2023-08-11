package com.example.ChessGameService;

import com.example.model.Board;
import com.example.model.Spots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingService extends ModelService {

    private final Board board;
    private Spots[][] spot;

    private final ChessGameHelperService chessGameHelperService;

    @Autowired
    public KingService(Board board, ChessGameHelperService chessGameHelperService) {
        this.board = board;
        this.spot = board.getSpot();
        this.chessGameHelperService = chessGameHelperService;
    }

    public boolean validateMove(Board board, Spots curSpot, Spots desSpot) {
        int curX = curSpot.getX();
        int curY = curSpot.getY();

        int desX = desSpot.getX();
        int desY = desSpot.getY();

        if (((Math.abs(curX - desX) <= 1) && (Math.abs(curY - desY) <= 1)) &&
                (spot[desX][desY].getPiece() == null ||
                        (spot[desX][desY].getPiece().isWhite() !=
                                spot[curX][curY].getPiece().isWhite()))) {
            return true;
        }
        else if (curSpot.getPiece().isEverMoved() == false) {
            if (curX == 7) {
                if (desX == 7 && spot[7][7].getPiece().isEverMoved() == false) {
                    for (int i = 4; i < 7; i++) {
                        if (spot[i][curY].getPiece() != null) {
                            return false;
                        }
                    }
                    for (int i = 3; i < 6; i++) {
                        if (chessGameHelperService.isCheck(7, i)) {
                            return false;
//                            validate for check conditions at 7,i blocks
                        }
                    }
                    if (desX == 0 && spot[0][0].getPiece().isEverMoved() == false) {
                        for (int i = 1; i < 3; i++) {
                            if (spot[i][curY].getPiece() != null) {
                                return false;
                            }
                        }
                        for (int i = 1; i < 4; i++) {
                            if (chessGameHelperService.isCheck(7, i)) {
                                return false;
//                            validate for check conditions at 7,i blocks
                            }
                        }
                    } else if (curX == 0) {
                        if (desX == 7 && spot[7][7].getPiece().isEverMoved() == false) {
                            for (int i = 5; i < 7; i++) {
                                if (spot[i][curY].getPiece() != null) {
                                    return false;
                                }
                            }
                            for (int i = 4; i < 7; i++) {
                                if (chessGameHelperService.isCheck(0, i))
                                    return false;
//                            validate for check conditions at 0,i blocks
                            }
                        }
                        if (desX == 0 && spot[0][0].getPiece().isEverMoved() == false) {
                            for (int i = 1; i < 4; i++) {
                                if (spot[i][curY].getPiece() != null) {
                                    return false;
                                }
                            }
                            for (int i = 2; i < 5; i++) {
                                if (chessGameHelperService.isCheck(0, i))
                                    return false;
//                            validate for check conditions at 0,i blocks
                            }
                        }
                    }
                }

                return true;
            }
        }
        return true;
    }

    public boolean isCheck(Board board, Spots curSpot, Spots desSpot) {

        return false;
    }
}
