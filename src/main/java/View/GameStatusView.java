package View;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;

public class GameStatusView {
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String STAR = "***********************";
    private final String SPACE= "      ";

    private String player1;
    private String player2;
    public String color1;
    public String color2;
    private String gameType;
    private String openingType;

    public GameStatusView(BlackPlayer p1, WhitePlayer p2, GomokuType gameName, OpeningType openingName){
        this.initLabels(p1, p2, gameName, openingName);
    }

    private void initLabels(BlackPlayer p1, WhitePlayer p2, GomokuType gameName, OpeningType openingName){

        this.player1 = p1.getName();
        this.player2 = p2.getName();
        this.color1 = p1.getColorName();
        this.color2 = p2.getColorName();
        this.openingType = "Opening rules:  " + openingName;
        this.gameType = "Game:  " + gameName;
    }


    public void initBackGround(){
        System.out.println("\n"+ANSI_PURPLE+STAR+ANSI_RESET);
        System.out.println(ANSI_PURPLE+this.player1+SPACE+this.color1+ANSI_RESET);
        System.out.println(ANSI_PURPLE+this.player2+SPACE+this.color2+ANSI_RESET);
        System.out.println(ANSI_PURPLE+this.gameType+ANSI_RESET);
        System.out.println(ANSI_PURPLE+this.openingType+ANSI_RESET);

    }

    public void swapColors(){
        String tmp = color1;
        color1=color2;
        color2=tmp;
    }


}
