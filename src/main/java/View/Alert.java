package View;

import javafx.scene.control.ButtonType;
public class Alert {

    public static String gameOverAlert( String ... winner){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);

        if (winner.length > 0)
            alert.setHeaderText("The winner is " + winner[0]);
        else
            alert.setHeaderText("The board is full: game ended with no winner" );

        alert.showAndWait();
        return alert.getResult().getText();
    }


    public static void invalidMoveAlert(String error){

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("ERROR -Invalid Move");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();

    }

    public static void loginAlert(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("ERROR - Missing values");
        alert.setHeaderText(null);
        alert.setContentText("Insert the name of both players");
        alert.showAndWait();
    }

    public static void openingRulesAlert(String type){

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setTitle(type + " Opening - Rules");

        switch (type) {
            case "Standard":
                alert.setContentText("Black player starts and insert 1 stones followed by white player. Stones can be placed anywhere.");
                break;

            case "Swap":
                alert.setContentText("Black player places 3 stones: 2 black and 1 white. White player can decide to swap color " +
                        "or stay white.");
                break;
            case "Swap2":
                alert.setHeight(200);
                alert.setContentText("Black player places 3 stones: 2 black and 1 white. White player can decide to swap color " +
                        "stay white, or place other 2 stones (1 black and 1 white) and let the black player decide the wanted color.");
                break;
        }
        alert.showAndWait();
    }


    public static String swapAlert(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "Do you want to Swap ?");
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);

        alert.setHeaderText(null);
        alert.showAndWait();

        return alert.getResult().getText();

    }

    public static String swap2Alert(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "Do you want to stay white?");
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);
        alert.setHeaderText(null);
        alert.showAndWait();

        return alert.getResult().getText();
    }

    public static void swap2Alert2(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Swap2 - Opening");
        alert.setHeaderText(null);
        alert.setContentText("white player insert 2 more stones (1 black and 1 white)");
        alert.showAndWait();
    }

    public static String swap2_1Alert(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "Black player you want to Swap ?");
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);
        alert.setHeaderText(null);
        alert.showAndWait();

        return alert.getResult().getText();

    }

}
