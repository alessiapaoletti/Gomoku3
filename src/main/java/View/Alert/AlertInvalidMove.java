package View.Alert;

public class AlertInvalidMove extends AlertGenerator {
    public  void invalidMoveAlert(String error){
        javafx.scene.control.Alert alert = super.createErrorAlert("ERROR -Invalid Move", error);
        alert.showAndWait();
    }
}
