package Model;

import Controller.BoardController;
import Controller.ScoreController;
import View.Alert;
import java.io.IOException;

import static Model.GomokuGame.openingName;

public class GamePlay {
    public BoardController boardController;
    public static ScoreController scoreController;
    public static GomokuGame game;

    public GamePlay(GomokuGame game, int gridSize){
        this.boardController = new BoardController(gridSize, InitialMove());
        this.scoreController = new ScoreController();
        this.game = game;
        game.initGame();
        game.closingRules = new Closing(boardController.boardLogic, game.gameName);
    }

    // function that allows the opening functions to work on the board.
    public void getOpgame(final double x, final double y,int c){
        boardController.placePiece(x,y);
        game.callOpeningRules(c);
    }

    public void getIngame(final double x, final double y){
        boardController.placePiece(x,y);
        try {
            //game.Rules();
            game.setInvalidMoves();
        }
        catch (Error e){
            Alert.invalidMoveAlert(e.toString());
            boardController.UnplacePiece(x,y);   //tolgo  l'ultima pedina inserita
        }
    }

    public void initBoardController(){
        boardController.setOnMouseClicked((event) -> {
            boardController.clicksCount++;
            // Here appends the opening moves control

            if(boardController.clicksCount == GomokuGame.getNumMovesOpening() || boardController.clicksCount == GomokuGame.getNumMovesOpening() +2) {
                getOpgame(event.getX(), event.getY(), boardController.clicksCount);
            }
            getIngame(event.getX(), event.getY());
        });
    }

    public int InitialMove(){
        Alert.openingRulesAlert(openingName);
        /*if(game.openingName.equals("Pro") || openingName.equals("LongPro")){

            if(game.getGridDim()==16) boardController.boardLogic.placePieceBl(7,7);
            else boardController.boardLogic.placePieceBl(9,9);
            return 1;
        }*/
        //else
        return 0;
    }

    public void start(){
        initBoardController();
        try {
            scoreController = scoreController.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            boardController.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


