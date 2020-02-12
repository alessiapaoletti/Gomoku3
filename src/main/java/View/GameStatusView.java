package View;

import Model.Player.*;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;

public class GameStatusView {

    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String STAR = "*";

    private String player1;
    private String player2;
    String color1;
    String color2;
    private String gameType;
    private String openingType;

    public GameStatusView(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gameName, OpeningType openingName){
        this.initLabels(blackPlayer, whitePlayer, gameName, openingName);
    }

    private void initLabels(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gameName, OpeningType openingName){
        this.player1 = blackPlayer.getName();
        this.player2 = whitePlayer.getName();
        this.color1 = blackPlayer.getColorName();
        this.color2 = whitePlayer.getColorName();
        this.openingType = "Opening rules:  " + openingName;
        this.gameType = "Game:  " + gameName;
    }

    public void initBackGround(){
        System.out.println("\n" + ANSI_PURPLE + STAR.repeat(40) + ANSI_RESET);
        String SPACE = " ";
        System.out.println(ANSI_PURPLE + this.player1 + SPACE.repeat(6) + this.color1 + ANSI_RESET);
        System.out.println(ANSI_PURPLE + this.player2 + SPACE.repeat(6) + this.color2 + ANSI_RESET);
        System.out.println(ANSI_PURPLE + this.gameType + ANSI_RESET);
        System.out.println(ANSI_PURPLE + this.openingType + ANSI_RESET);
    }

    public void swapColors(){
        String tmp = color1;
        color1 = color2;
        color2 = tmp;
    }

    public void printTurn(String playerName){
        System.out.println("\n");
        System.out.println(ANSI_PURPLE + STAR.repeat(40) + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Player " + playerName + " it is your turn!" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + STAR.repeat(40) + ANSI_RESET);
    }
}
