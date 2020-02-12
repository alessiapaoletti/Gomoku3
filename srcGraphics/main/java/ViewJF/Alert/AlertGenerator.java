package ViewJF.Alert;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public abstract class AlertGenerator {

    private void setAlertContent(Alert alert, String title, String contentText){
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
    }

    Alert createInformationAlert(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
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
        ButtonType buttonOne = new ButtonType("1");
        ButtonType buttonTwo = new ButtonType("2");
        ButtonType buttonThree = new ButtonType("3");
        alert.getButtonTypes().setAll( buttonOne, buttonTwo, buttonThree);
        return alert;
    }

}
