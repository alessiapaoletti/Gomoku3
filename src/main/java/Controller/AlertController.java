package Controller;

import Model.Rules.Opening.OpeningType;
import View.Alert.*;

public class AlertController implements AlertControllerInterface{

    private AlertSwap alertSwap = new AlertSwap();

    @Override
    public String swap2Alert(String whitePlayer) {
         return this.alertSwap.swap2Alert(whitePlayer );
    }

    @Override
    public String swapAlert(String playerName) {
           return this.alertSwap.swapAlert(playerName);
    }

    void callInvalidMoveError(){
        new AlertInvalidMove().invalidMoveAlert();
    }

    void callGameOverAlert(String... winner){
         new AlertGameOver().gameOverAlert(winner);
    }

    void callGetAlertOpening(OpeningType opening){
        new AlertOpening().getAlertOpening(opening);
    }

    void callInvalidCoordinateError(String dim){
        new AlertInvalidMove().invalidCoordinateAlert(dim);
    }
}
