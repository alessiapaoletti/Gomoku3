package ViewJF.Alert;

import javafx.scene.control.Alert;

public class AlertSwap extends AlertGenerator {

    private  Alert generateSwap2Alert(String textContent){
        Alert alert = super.createSwap2Alert(textContent);
        //alert.initStyle(StageStyle.UNDECORATED); //if we want to remove title bar
        alert.setHeight(350);
        alert.showAndWait();
        return alert;
    }

    private  Alert generateConfirmationAlert(String textContent){
        Alert alert = super.createConfirmationAlert(textContent);
        alert.showAndWait();
        return alert;
    }

    public String swap2Alert(String whitePlayer){
        return this.generateSwap2Alert(  whitePlayer + ", what do you want to do? \n \n " +
                "Option 1: \n  Stay white and put the 4th stone \n \n" +
                "Option 2: \n  Swap and control the black stones \n \n" +
                "Option 3: \n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent").getResult().getText();
    }

    public  String swapAlert(String whitePlayer){
        return this.generateConfirmationAlert(
                whitePlayer+ ", do you want to swap and control the black stones?\n"+
                "The player will then proceed placing 1 stone each.").getResult().getText();
    }

    public String swapBlack(String blackPlayer){
        return this.generateConfirmationAlert(blackPlayer + ", do you want to swap and control white stones?\n"+
                "The player will then proceed placing 1 stone each.").getResult().getText();
    }

}
