package ViewJF.Alert;

import Model.Rules.Opening.OpeningType;
import javafx.scene.control.Alert;
import java.util.HashMap;
import java.util.Map;

public class AlertOpening extends AlertGenerator{

    public AlertOpening() { this.add(); }

    private  Alert stdOpeningRulesAlert(){
        //Alert alert =
        return super.createInformationAlert("STANDARD opening - Rules",
                "Black player starts and insert 1 stones followed by white player. Stones can be placed anywhere.");
        //return alert;
    }

    private  Alert swapOpeningRulesAlert(){
        return super.createInformationAlert("SWAP opening - Rules",
                "BLACK player places 3 stones: 2 black and 1 white. \n \n" +
                        "then WHITE player can decide to swap color or stay white");
        //return alert;
    }

    private  Alert swap2OpeningRulesAlert(){
        Alert alert = super.createInformationAlert("SWAP2 opening - Rules",
                "BLACK player places 3 stones: 2 black and 1 white. \n \n" +
                        "then WHITE player can decide to: \n" +
                        "- stay white,\n" +
                        "- swap color,\n" +
                        "- place 2 more stones (1 black and 1 white) and let the black player decide the wanted color");
        alert.setHeight(350);
        return alert;
    }

    private  Map<OpeningType, Alert> alertOpeningMap = new HashMap<>();

    private void add(){
        this.alertOpeningMap.put(OpeningType.Standard,this.stdOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap,this.swapOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap2,this.swap2OpeningRulesAlert());
    }

    public void getAlertOpening(OpeningType opening) {
        try {
            this.alertOpeningMap.get(opening).showAndWait();
        }catch (NullPointerException e){
            System.out.println(e.getCause());
        }
    }

}
