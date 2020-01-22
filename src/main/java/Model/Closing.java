package Model;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Stream;

public class Closing {

    BoardLogic board;
    String gameType;
    private HashMap<Pair<String, Piece.PieceType>, String> closingMap;


    private void initMap(){

        this.closingMap = new HashMap<>();

        /*perchè abbiamo bisogno di così tante opzioni?
        * l'intero cosa rappresenta? */

        this.closingMap.put(new Pair<>("Standard", Piece.PieceType.BLACK), "no overlines");
        this.closingMap.put(new Pair<>("Standard", Piece.PieceType.WHITE), "no overlines");
        this.closingMap.put(new Pair<>("Freestyle", Piece.PieceType.BLACK), "overlines");
        this.closingMap.put(new Pair<>("Freestyle", Piece.PieceType.BLACK), "overlines");
        this.closingMap.put(new Pair<>("Omok", Piece.PieceType.BLACK), "no overlines");
        this.closingMap.put(new Pair<>("Omok", Piece.PieceType.WHITE), "overlines");
    }


    public Closing(BoardLogic b,  String type){
        this.board = b;
        this.gameType = type;
        this.initMap();
    }

    /*
    Function that returns true if the board is full and false otherwise
    **/
    public boolean fullBoard(){
        Stream<Piece> stream = Arrays.stream(this.board.piecesMatrix).flatMap(Arrays::stream);
        boolean anyZero = stream.map(x -> x.getPieceType()).anyMatch(x -> x.equals(Piece.PieceType.EMPTY));
        return !anyZero;

    }


    /*
    Function that calls a different winner check based on the game type
    * */

    public boolean checkWinner(int x, int y) {

        Piece.PieceType player = this.board.piecesMatrix[x][y].getPieceType();

        Pair<String, Piece.PieceType> p = new Pair<>(this.gameType, player);

        boolean result = false;

        if(this.closingMap.get(p) == "no overlines")
            result = exactlyFive(x,y, player);
        else
            result = fiveOrMore(x,y,player);
        return result;
    }


    /*
    Function that checks if there is a horizontal, vertical or diagonal line of 5 or more pieces of the same color
    that passes through the point (x,y)
    **/
    private boolean fiveOrMore(int x, int y, Piece.PieceType player){

        return this.horizontalCheck(x,y,player,true) | this.verticalCheck( x,y,player, true) |
                this.diagonalCheck( x, y, player, false, true) |
                this.diagonalCheck( x, y, player, true, true);
    }

    /*
    Function that checks if there is a horizontal, vertical or diagonal line of exactly 5 pieces of the same color
    that passes through the point (x,y)
    **/
    private boolean exactlyFive(int x, int y, Piece.PieceType player){
        return horizontalCheck(x,y,player, false) | verticalCheck( x,y,player, false) |
                diagonalCheck(x,y,player, true, false)|
                diagonalCheck(x,y,player, false, false);
    }


    /*
    Function that returns true if there is a diagonal line of 5 pieces of the same color that passes through the point (x,y).
    If the argument overlinesAllowed is set to false the pieces must be exactly 5 and not more.
    If the argument ascending is set to true the check is made on the ascending diagonal.
    **/
    private boolean diagonalCheck(int x, int y, Piece.PieceType player, boolean ascending, boolean overlinesAllowed) {

        int yIncrement;
        int diagX;
        int diagY;

        if (!ascending) {
            yIncrement = 1;
            diagX = Math.max(0, x-y);
            diagY= Math.max(0, y-x);
        }
        else {
            yIncrement = -1;
            diagX = Math.max(0, x+y - this.board.boardSize + 1);
            diagY= Math.min(this.board.boardSize -1, x+y);
        }

        int count = 0;

        while (diagX < this.board.boardSize & diagY >= 0 & diagY < this.board.boardSize) {
            if (this.board.piecesMatrix[diagX][diagY].getPieceType() == player)
                count++;
            else
                count = 0;

            if (count == 5)
                if(this.board.piecesMatrix[diagX+1][diagY+ yIncrement].getPieceType() == player)
                    return false|overlinesAllowed;
                else
                    return true;
            diagX++;
            diagY = diagY + yIncrement;
        }
        return false;
    }


    /*
    Function that returns true if there is a horizontal line of 5 pieces of the same color that passes through the point (x,y).
    If the argument overlinesAllowed is set to false the pieces must be exactly 5 and not more
    **/
    private boolean horizontalCheck(int x, int y, Piece.PieceType player, boolean overlinesAllowed){

        int count = 0;

        for(int i = 0; i< this.board.boardSize; i++){
            if(this.board.piecesMatrix[i][y].getPieceType() == player)
                count++;
            else
                count = 0;
            if(count == 5)
                if(this.board.piecesMatrix[i+1][y].getPieceType() == player)
                    return false|overlinesAllowed;
                else
                    return true;
        }
        return false;
    }


    /*
    Function that returns true if there is a vertical line of 5 pieces of the same color that passes through the point (x,y).
    If the argument overlinesAllowed is set to false the pieces must be exactly 5 and not more
    **/
    private boolean verticalCheck(int x, int y, Piece.PieceType player, boolean overlinesAllowed) {

        int count = 0;

        for(int i = 0; i< this.board.boardSize; i++){
            if(this.board.piecesMatrix[x][i].getPieceType() == player)
                count++;
            else
                count = 0;
            if(count == 5)
                if(this.board.piecesMatrix[x][i+1].getPieceType() == player)
                    return false|overlinesAllowed;
                else
                    return true;
        }
        return false;
    }

}
