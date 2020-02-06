package ViewJF.Alert;

import javafx.scene.control.Alert;
public class AlertInvalidMove extends AlertGenerator {

    public  void invalidMoveAlert(String error){
        Alert alert = super.createErrorAlert("ERROR -Invalid Move", error);
        alert.showAndWait();
    }
}
