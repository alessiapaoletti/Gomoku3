package ViewJF.Alert;

import javafx.scene.control.Alert;

public class AlertGameOver extends AlertGenerator {

    public  String gameOverAlert( String ... winner){

        Alert alert = super.createInformationAlert("Game Over", "");

        if (winner.length > 0)
            alert.setHeaderText("The winner is " + winner[0]);
        else
            alert.setHeaderText("The board is full: game ending with no winner." );

        alert.showAndWait();

        return alert.getResult().getText();
    }
}
