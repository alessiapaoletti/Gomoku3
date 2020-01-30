package View.Alert;

public class AlertInvalidMove extends AlertGenerator {
    public static void invalidMoveAlert(String error){
        javafx.scene.control.Alert alert = createErrorAlert("ERROR -Invalid Move", error);
        alert.showAndWait();
    }
}
