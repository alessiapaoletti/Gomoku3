package View.Alert;

import Model.Rules.Opening.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
import java.lang.reflect.Method;

public class AlertOpening extends AlertGenerator{

    public AlertOpening(){ this.add();};

    public  Alert stdOpeningRulesAlert(){
        Alert alert = super.createInformationAlert("Standard opening - Rules", "Black player starts and insert 1 stones followed by white player. Stones can be placed anywhere.");
        return alert;

    }

    public  Alert swapOpeningRulesAlert(){
        Alert alert = super.createInformationAlert("Swap opening - Rules", "Black player places 3 stones: 2 black and 1 white. White player can decide to swap color or stay white.");
        return alert;
    }

    public  Alert swap2OpeningRulesAlert(){
        Alert alert = super.createInformationAlert("Swap2 opening - Rules", "Black player places 3 stones: 2 black and 1 white. White player can decide to swap color, stay white, or place other 2 stones (1 black and 1 white) and let the black player decide the wanted color.");
        alert.setHeight(200);
        return alert;
    }

    private  Map<OpeningType, Alert> alertOpeningMap = new HashMap<>();

    private void add(){
        this.alertOpeningMap.put(OpeningType.Standard,this.stdOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap,this.swapOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap2,this.swap2OpeningRulesAlert());
    };

    public void getAlertOpening(OpeningType opening) {
        try {
            this.alertOpeningMap.get(opening).showAndWait();
        }catch (NullPointerException e){
            System.out.println(e.getCause());
        }
    }

}
