package View;

import Model.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ScoreView extends Pane {

    private Rectangle background;
    private Label player1;
    private Label player2;
    private Label color1;
    private Label color2;
    private Button closeButton;
    private Button newGameButton;

    public ScoreView(Player p1, Player p2, String gameName, String openingName){
        this.player1 = new Label(p1.getName());
        this.player2 = new Label(p2.getName());
        this.color1 = new Label(p1.getColorName());
        this.color2 = new Label(p2.getColorName());
        player1.setTranslateY(30);
        player1.setTranslateX(20);
        player2.setTranslateY(60);
        player2.setTranslateX(20);
        color1.setTranslateY(30);
        color1.setTranslateX(120);
        color2.setTranslateY(60);
        color2.setTranslateX(120);
        this.background = new Rectangle(190, 200);
        this.background.setFill(Color.PINK);
        this.getChildren().add(this.background);
        this.getChildren().add(this.player1);
        this.getChildren().add(this.player2);
        this.getChildren().add(color1);
        this.getChildren().add(color2);

        this.closeButton = new Button("Close");
        this.newGameButton = new Button("New game");

        this.closeButton.setTranslateX(115);
        this.closeButton.setTranslateY(110);
        this.getChildren().add(this.closeButton);

        this.newGameButton.setTranslateX(20);
        this.newGameButton.setTranslateY(110);
        this.getChildren().add(this.newGameButton);


    }


    public Button getCloseButton(){
        return this.closeButton;
    }

    public Button getNewGameButton(){
        return newGameButton;
    }

    public void swapColors(){
        String tmp = color1.getText();
        color1.setText(color2.getText());
        color2.setText(tmp);
    }




}
