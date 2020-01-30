package View.Alert;

import javafx.scene.control.Alert;

public class AlertLogin extends AlertGenerator{

    public static void loginAlert(){
        Alert alert = createErrorAlert("ERROR - Missing values", "Fill all the fields" );
        alert.showAndWait();
    }
}
