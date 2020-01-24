package View;

import Model.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ScoreView extends Pane {

    private Label player1;
    private Label player2;
    private Label color1;
    private Label color2;
    private Button closeButton;
    private Button newGameButton;

    public ScoreView(Player p1, Player p2, String gameName, String openingName){

        this.initBackGround();

        this.initLabels(p1, p2);
        this.setLabelsCoordinates();

        this.initButtons();
        this.setButtonsCoordinates();

    }

    private void initLabels(Player p1, Player p2){
        this.player1 = new Label(p1.getName());
        this.player2 = new Label(p2.getName());
        this.color1 = new Label(p1.getColorName());
        this.color2 = new Label(p2.getColorName());

        this.getChildren().add(this.player1);
        this.getChildren().add(this.player2);
        this.getChildren().add(this.color1);
        this.getChildren().add(this.color2);
    }

    private void setLabelsCoordinates(){
        player1.setTranslateY(30);
        player1.setTranslateX(20);
        player2.setTranslateY(60);
        player2.setTranslateX(20);
        color1.setTranslateY(30);
        color1.setTranslateX(120);
        color2.setTranslateY(60);
        color2.setTranslateX(120);
    }

    private void initButtons(){
        this.closeButton = new Button("Close");
        this.newGameButton = new Button("New game");

        this.getChildren().add(this.closeButton);
        this.getChildren().add(this.newGameButton);

    }

    private void setButtonsCoordinates(){
        this.closeButton.setTranslateX(115);
        this.closeButton.setTranslateY(110);

        this.newGameButton.setTranslateX(20);
        this.newGameButton.setTranslateY(110);
    }

    private void initBackGround(){
        Rectangle background = new Rectangle(190, 200);
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


}
