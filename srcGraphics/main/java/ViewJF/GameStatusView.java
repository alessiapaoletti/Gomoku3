package ViewJF;

import Model.GomokuGame.GomokuType;
import Model.BlackPlayer;
import Model.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameStatusView extends Pane {

    private Label player1;
    private Label player2;
    private Label color1;
    private Label color2;
    private Label gameType;
    private Label openingType;
    private Button closeButton;
    private Button newGameButton;

    public GameStatusView(BlackPlayer p1, WhitePlayer p2, GomokuType gameName, OpeningType openingName){

        this.initBackGround();

        this.initLabels(p1, p2, gameName, openingName);
        this.setLabelsCoordinates();

        this.initButtons();
        this.setButtonsCoordinates();
    }

    private void initLabels(BlackPlayer p1, WhitePlayer p2, GomokuType gameName, OpeningType openingName){

        this.player1 = new Label(p1.getName());
        this.player1.setFont(Font.font("Arial" , FontWeight.BOLD, 13));

        this.player2 = new Label(p2.getName());
        this.player2.setFont(Font.font("Arial" , FontWeight.BOLD, 13));

        this.color1 = new Label(p1.getColorName());
        this.color2 = new Label(p2.getColorName());

        this.openingType = new Label("Opening rules:  " + openingName);
        this.openingType.setFont(Font.font("Arial" , 13));
        this.gameType = new Label("Game:  " + gameName);
        this.gameType.setFont(Font.font("Arial" , 13));

        this.getChildren().add(this.player1);
        this.getChildren().add(this.player2);
        this.getChildren().add(this.color1);
        this.getChildren().add(this.color2);
        this.getChildren().add(this.gameType);
        this.getChildren().add(this.openingType);
    }

    private void setLabelsCoordinates(){
        player1.setTranslateX(20);
        player1.setTranslateY(30);

        color1.setTranslateX(130);
        color1.setTranslateY(30);

        player2.setTranslateX(20);
        player2.setTranslateY(60);

        color2.setTranslateX(130);
        color2.setTranslateY(60);

        openingType.setTranslateX(20);
        openingType.setTranslateY(100);
        gameType.setTranslateX(20);
        gameType.setTranslateY(130);

    }

    private void initButtons(){

        this.closeButton = new Button("Close");
        this.newGameButton = new Button("New game");

        this.getChildren().add(this.closeButton);
        this.getChildren().add(this.newGameButton);

    }

    private void setButtonsCoordinates(){
        this.newGameButton.setTranslateX(20);
        this.newGameButton.setTranslateY(180);

        this.closeButton.setTranslateX(125);
        this.closeButton.setTranslateY(180);
    }

    private void initBackGround(){
        Rectangle background = new Rectangle(200, 240);
        background.setFill(Color.PINK);

        this.getChildren().add(background);
    }

    public Button getCloseButton(){
        return this.closeButton;
    }

    public Button getNewGameButton(){
        return this.newGameButton;
    }

    public void swapColors(){
        String tmp = color1.getText();
        color1.setText(color2.getText());
        color2.setText(tmp);
    }

    public void fillColorPlayer(){
        Paint tmp = player1.getTextFill();
        player1.setTextFill(player2.getTextFill());
        player2.setTextFill(tmp);
    }
}
