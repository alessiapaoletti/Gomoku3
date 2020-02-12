package ControllerJF;

import Controller.AlertControllerInterface;
import Model.Rules.Opening.OpeningType;
import ViewJF.Alert.*;

public class AlertController implements AlertControllerInterface {

    private AlertSwap alertSwap = new AlertSwap();

    void callInvalidMoveError(String error){
        AlertInvalidMove alertInvalidMove = new AlertInvalidMove();
        alertInvalidMove.invalidMoveAlert(error);

    }

    String callGameOverAlert(String ... winner){
        AlertGameOver alertGameOver = new AlertGameOver();
        return alertGameOver.gameOverAlert(winner);
    }

    void callLoginAlert(){
        AlertLogin alertLogin = new AlertLogin();
        alertLogin.loginAlert();
    }

    void callGetAlertOpening(OpeningType opening){
        AlertOpening alertOpening = new AlertOpening();
        alertOpening.getAlertOpening(opening);
    }

    @Override
    public String swap2Alert(String playerName){
        return alertSwap.swap2Alert(playerName);
    }


    @Override
    public String swapAlert(String playerName) {
        return alertSwap.swapAlert(playerName);
    }

}
