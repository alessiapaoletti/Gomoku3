package View.Alert;

import javafx.scene.control.Alert;

public class AlertSwap extends AlertGenerator {

    private static Alert generateAlert(String title, String textContent){
        Alert alert = createConfirmationAlert(title, textContent);
        alert.showAndWait();
        return alert;
    }

    public static String swapAlert(){
        return AlertSwap.generateAlert("", "White player, do you want to Swap ?").getResult().getText();
    }

    public static String swap2Alert(){
        return AlertSwap.generateAlert("", "White player, do you want to stay white? If yes, put 4th stone, otherwise puts two more stones and after that lets your opponent to choose the colour.").getResult().getText();
    }

    public static void swap2Alert2(){
        Alert alert = createInformationAlert("Swap2 - Opening", "white player insert 2 more stones (1 black and 1 white)");
        alert.showAndWait();
    }

    public static String swap2_1Alert(){
        return AlertSwap.generateAlert("", "Black player, you want to Swap ?").getResult().getText();
    }
}
