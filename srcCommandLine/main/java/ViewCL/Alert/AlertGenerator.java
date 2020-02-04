package ViewCL.Alert;

public abstract class AlertGenerator {

    protected  final String ANSI_RESET = "\u001B[0m";
    protected  final String ANSI_PURPLE = "\u001B[35m";
    protected  final String ANSI_PURPLE1 = "\u001B[95m";
    protected  final String ANSI_RED_BACKGROUND = "\u001B[41m";
    protected final String ANSI_RED = "\u001B[31m";
    protected final String SPACE = "             ";
    protected final String STAR = "*****************";
/*
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
*/
}
