package View.Alert;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public abstract class AlertGenerator {

    protected  void setAlertContent(Alert alert, String title, String contentText){
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
    }

    public Alert createInformationAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    public Alert createErrorAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    public Alert createConfirmationAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        setAlertContent(alert, title, contentText);
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);
        return alert;
    }

}
