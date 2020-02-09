package Controller;

import Model.Rules.Opening.OpeningType;
import View.Alert.*;

public class AlertController implements AlertControllerInterface{

    private AlertSwap alertSwap = new AlertSwap();

    @Override
    public String swap2Alert() {
         return this.alertSwap.swap2Alert();
    }

    @Override
    public String swapAlert() {
           return this.alertSwap.swapAlert();
    }

    @Override
    public String swapBlack(){ return this.alertSwap.swapBlack();  }

    public void callInvalidMoveError(){
        new AlertInvalidMove().invalidMoveAlert();
    }

    public void callGameOverAlert(String ... winner){
         new AlertGameOver().gameOverAlert(winner);
    }

    public void callGetAlertOpening(OpeningType opening){
        new AlertOpening().getAlertOpening(opening);
    }
}
