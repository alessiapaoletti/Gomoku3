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
    public String swapAlert(String whitePlayer) {
           return this.alertSwap.swapAlert(whitePlayer);
    }

    @Override
    public String swapBlack(String blackPlayer){ return this.alertSwap.swapBlack(blackPlayer);  }

    void callInvalidMoveError(){
        new AlertInvalidMove().invalidMoveAlert();
    }

    void callGameOverAlert(String... winner){
         new AlertGameOver().gameOverAlert(winner);
    }

    void callGetAlertOpening(OpeningType opening){
        new AlertOpening().getAlertOpening(opening);
    }

    void callinvalidCoordinateError(String dim){
        new AlertInvalidMove().invalidCoordinateAlert(dim);
    }
}
