package View.Alert;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public abstract class AlertGenerator {

    private void setAlertContent(Alert alert, String title, String contentText){
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
    }

    Alert createInformationAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    Alert createErrorAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        setAlertContent(alert, title, contentText);
        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);
        return alert;
    }

    Alert createConfirmationAlert(String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        setAlertContent(alert, "", contentText);
        ButtonType buttonYes = new ButtonType("YES");
        ButtonType buttonNo = new ButtonType("NO");
        alert.getButtonTypes().setAll( buttonYes, buttonNo);
        return alert;
    }

    Alert createSwap2Alert(String contentText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        setAlertContent(alert, "", contentText);
        ButtonType buttonOne = new ButtonType("Option One");
        ButtonType buttonTwo = new ButtonType("Option Two");
        ButtonType buttonThree = new ButtonType("Option Three");
        alert.getButtonTypes().setAll( buttonOne, buttonTwo, buttonThree);
        return alert;
    }

}
