package ViewJF.Alert;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

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
        //alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();
        return alert;
    }

    public String swap2Alert(){
        return this.generateSwap2Alert("WHITE player, what do you want to do? \n \n " +
                "Option 1: \n  Stay white and put the 4th stone \n \n" +
                "Option 2: \n  Swap and control the black stones \n \n" +
                "Option 3: \n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent").getResult().getText();
    }

    public  String swapAlert(){
        return this.generateConfirmationAlert(
                "WHITE player, do you want to swap and control the black stones?").getResult().getText();
    }

//    public  void swap2Alert2(){
//        Alert alert = super.createInformationAlert("Swap2 - Opening", "white player insert 2 more stones (1 black and 1 white)");
//        alert.showAndWait();
//    }

    public String swapBlack(){
        return this.generateConfirmationAlert("BLACK player, do you want to swap and control white stones?").getResult().getText();
    }
}
