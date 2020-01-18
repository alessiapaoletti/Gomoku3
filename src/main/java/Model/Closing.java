package Model;

import Controller.BoardController;
import javafx.util.Pair;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Stream;

public class Closing {
    String gameType;
    private HashMap<Pair<String, Integer>, String> map;


    private void initMap(){

        this.map = new HashMap<>();

        this.map.put(new Pair<>("Standard", 1), "no overlines");
        this.map.put(new Pair<>("Standard", 2), "no overlines");
        this.map.put(new Pair<>("Free", 1), "overlines");
        this.map.put(new Pair<>("Free", 2), "overlines");
        this.map.put(new Pair<>("Omok", 1), "overlines");
        this.map.put(new Pair<>("Omok", 2), "overlines");

    }


    public Closing(BoardLogic b, String type){
        BoardController.boardLogic = b;
        this.gameType = type;
        this.initMap();
        System.out.println(gameType + " in closing");
    }

    /*
    Function that returns true if the board is full and false otherwise
    **/
    public boolean fullBoard(){

        Stream<Piece> stream = Arrays.stream(BoardController.boardLogic.getPiecesMatrix()).flatMap(Arrays::stream);
        boolean anyZero = stream.map(x -> x.getPlayer()).anyMatch(x -> x.equals(0));
        return !anyZero;

    }


    /*
    Function that calls a different winner check based on the game type
    * */

    public boolean checkWinner(int x, int y) {

        int player = BoardController.boardLogic.getPiecesMatrix()[x][y].getPlayer();

        Pair<String, Integer> p = new Pair<>(this.gameType, player);

        boolean result = false;

        if(this.map.get(p).equals("no overlines"))
            result = exactlyFive(x,y, player);
        else
            result = fiveOrMore(x,y,player);
        return result;
    }


    /*
    Function that checks if there is a horizontal, vertical or diagonal line of 5 or more pieces of the same color
    that passes through the point (x,y)
    **/
    private boolean fiveOrMore(int x, int y, int player){

        return this.horizontalCheck(x,y,player,true) | this.verticalCheck( x,y,player, true) |
                this.diagonalCheck( x, y, player, false, true) |
                this.diagonalCheck( x, y, player, true, true);
    }

    /*
    Function that checks if there is a horizontal, vertical or diagonal line of exactly 5 pieces of the same color
    that passes through the point (x,y)
    **/
    private boolean exactlyFive(int x, int y, int player){
        return horizontalCheck(x,y,player, false) | verticalCheck( x,y,player, false) |
                diagonalCheck(x,y,player, true, false)|
                diagonalCheck(x,y,player, false, false);
    }


    /*
    Function that returns true if there is a diagonal line of 5 pieces of the same color that passes through the point (x,y).
    If the argument overlinesAllowed is set to false the pieces must be exactly 5 and not more.
    If the argument ascending is set to true the check is made on the ascending diagonal.
    **/
    private boolean diagonalCheck(int x, int y, int player, boolean ascending, boolean overlinesAllowed) {

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
            diagX = Math.max(0, x+y - BoardController.boardLogic.boardSize + 1);
            diagY= Math.min(BoardController.boardLogic.boardSize-1, x+y);
        }

        int count = 0;

        while (diagX < BoardController.boardLogic.boardSize & diagY >= 0 & diagY < BoardController.boardLogic.boardSize) {
            if (BoardController.boardLogic.getPiecesMatrix()[diagX][diagY].getPlayer() == player)
                count++;
            else
                count = 0;

            if (count == 5)
                if(BoardController.boardLogic.getPiecesMatrix()[diagX+1][diagY+ yIncrement].getPlayer() == player)
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
    private boolean horizontalCheck(int x, int y, int player, boolean overlinesAllowed){

        int count = 0;

        for(int i = 0; i< BoardController.boardLogic.boardSize; i++){
            if(BoardController.boardLogic.getPiecesMatrix()[i][y].getPlayer() == player)
                count++;
            else
                count = 0;
            if(count == 5)
                if(BoardController.boardLogic.getPiecesMatrix()[i+1][y].getPlayer() == player)
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
    private boolean verticalCheck(int x, int y, int player, boolean overlinesAllowed) {

        int count = 0;

        for(int i = 0; i< BoardController.boardLogic.boardSize; i++){
            if(BoardController.boardLogic.getPiecesMatrix()[x][i].getPlayer() == player)
                count++;
            else
                count = 0;
            if(count == 5)
                if(BoardController.boardLogic.getPiecesMatrix()[x][i+1].getPlayer() == player)
                    return false|overlinesAllowed;
                else
                    return true;
        }

        return false;

    }



}
