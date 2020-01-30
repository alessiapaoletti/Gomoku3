package View.Alert;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public abstract class AlertGenerator {

    private static void setAlertContent(Alert alert, String title, String contentText){
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
    }

    static Alert createInformationAlert(String title, String contentText){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    static Alert createErrorAlert(String title, String contentText){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.ERROR);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    static Alert createConfirmationAlert(String title, String contentText){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        setAlertContent(alert, title, contentText);
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);
        return alert;
    }

}
