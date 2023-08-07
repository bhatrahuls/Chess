<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chess game</title>
    <style>
        .container{
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .item1{
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 80vh;
            
            margin-right: 100px;

        }
        .item2{
            height: 600px;
            display: grid;
            grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
            grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
        }
        .white{
            background-color: antiquewhite;
            height: 80px;
            width: 80px;
        }
        .black{
            background-color: burlywood;
            height: 80px;
            width: 80px;
        }

        .blackPawn{
            background-image: url(./pieceIcons/BlackPawn.svg);
            background-size: contain;
        }

        .whitePawn{
            background-image: url(./pieceIcons/WhitePawn.svg);
            background-size: contain;
        }

        .blackQueen{
            background-image: url(./pieceIcons/BlackQueen.svg);
            background-size: contain;
        }

        .whiteQueen{
            background-image: url(./pieceIcons/WhiteQueen.svg);
            background-size: contain;
        }

        .blackBishop{
            background-image: url(./pieceIcons/BlackBishop.svg);
            background-size: contain;
        }

        .whiteBishop{
            background-image: url(./pieceIcons/WhiteBishop.svg);
            background-size: contain;
        }

        .blackKnight{
            background-image: url(./pieceIcons/BlackKnight.svg);
            background-size: contain;
        }

        .whiteKnight{
            background-image: url(./pieceIcons/WhiteKnight.svg);
            background-size: contain;
        }

        .blackKing{
            background-image: url(./pieceIcons/BlackKing.svg);
            background-size: contain;
        }

        .whiteKing{
            background-image: url(./pieceIcons/WhiteKing.svg);
            background-size: contain;
        }

        .blackRook{
            background-image: url(./pieceIcons/BlackRook.svg);
            background-size: contain;
        }

        .whiteRook{
            background-image: url(./pieceIcons/WhiteRook.svg);
            background-size: contain;
        }
    </style>

    <script>
        
    </script>
</head>
<body>
    <div class="container">
        <div class="item1">
            <form action="/move" method="post"></form>
            Enter piece sourceX <input type="number" name="srcX">
            Enter piece sourceY <input type="number" name="srcY">
            Enter piece DestinationX <input type="number" name="desX">
            Enter piece DestinationY <input type="number" name="desY">

            <input type="submit" value="Move">

        </div>
        <div class="item2">
            <div class="white blackRook" id="zeroZero"></div>
            <div class="black blackKnight" id="zeroOne"></div>
            <div class="white blackBishop" id="zeroTwo"></div>
            <div class="black blackQueen" id="zeroThree"></div>
            <div class="white blackKing" id="zeroFour"></div>
            <div class="black blackBishop" id="zeroFive"></div>
            <div class="white blackKnight" id="zeroSix"></div>
            <div class="black blackRook" id="zeroSeven"></div>
            
            <div class="black blackPawn" id="oneZero"></div>
            <div class="white blackPawn" id="oneOne"></div>
            <div class="black blackPawn" id="oneTwo"></div>
            <div class="white blackPawn" id="oneThree"></div>
            <div class="black blackPawn" id="oneFour"></div>
            <div class="white blackPawn" id="oneFive"></div>
            <div class="black blackPawn" id="oneSix"></div>
            <div class="white blackPawn" id="oneSeven"></div>
            
            <div class="white" id="twoZero"></div>
            <div class="black" id="twoOne"></div>
            <div class="white" id="twoTwo"></div>
            <div class="black" id="twoThree"></div>
            <div class="white" id="twoFour"></div>
            <div class="black" id="twoFive"></div>
            <div class="white" id="twoSix"></div>
            <div class="black" id="twoSeven"></div>
            
            <div class="black" id="threeZero"></div>
            <div class="white" id="threeOne"></div>
            <div class="black" id="threeTwo"></div>
            <div class="white" id="threeThree"></div>
            <div class="black" id="threeFour"></div>
            <div class="white" id="threeFive"></div>
            <div class="black" id="threeSix"></div>
            <div class="white" id="threeSeven"></div>
            
            <div class="white" id="fourZero"></div>
            <div class="black" id="fourOne"></div>
            <div class="white" id="fourTwo"></div>
            <div class="black" id="fourThree"></div>
            <div class="white" id="fourFour"></div>
            <div class="black" id="fourFive"></div>
            <div class="white" id="fourSix"></div>
            <div class="black" id="fourSeven"></div>
            
            <div class="black" id="fiveZero"></div>
            <div class="white" id="fiveOne"></div>
            <div class="black" id="fiveTwo"></div>
            <div class="white" id="fiveThree"></div>
            <div class="black" id="fiveFour"></div>
            <div class="white" id="fiveFive"></div>
            <div class="black" id="fiveSix"></div>
            <div class="white" id="fiveSeven"></div>
            
            <div class="white whitePawn" id="sixZero"></div>
            <div class="black whitePawn" id="sixOne"></div>
            <div class="white whitePawn" id="sixTwo"></div>
            <div class="black whitePawn" id="sixThree"></div>
            <div class="white whitePawn" id="sixFour"></div>
            <div class="black whitePawn" id="sixFive"></div>
            <div class="white whitePawn" id="sixSix"></div>
            <div class="black whitePawn" id="sixSeven"></div>
            
            <div class="black whiteRook" id="sevenZero"></div>
            <div class="white whiteKnight" id="sevenOne"></div>
            <div class="black whiteBishop" id="sevenTwo"></div>
            <div class="white whiteQueen" id="sevenThree"></div>
            <div class="black whiteKing" id="sevenFour"></div>
            <div class="white whiteBishop" id="sevenFive"></div>
            <div class="black whiteKnight" id="sevenSix"></div>
            <div class="white whiteRook" id="sevenSeven"></div>

            
        </div>
    </div>
    
</body>
</html>