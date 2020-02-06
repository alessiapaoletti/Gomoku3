package ViewJF.Alert;

import javafx.scene.control.Alert;

public class AlertLogin extends AlertGenerator{

    public  void loginAlert(){
        Alert alert = super.createErrorAlert("ERROR - Missing values", "Fill all the fields" );
        alert.showAndWait();
    }
}
