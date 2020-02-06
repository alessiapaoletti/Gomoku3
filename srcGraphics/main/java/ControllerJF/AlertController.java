package ControllerJF;

import Controller.AlertControllerInterface;
import Model.Rules.Opening.OpeningType;
import ViewJF.Alert.*;

public class AlertController implements AlertControllerInterface {

    private AlertSwap alertSwap = new AlertSwap();

//    public boolean AnswerQuestionAlert(String Answ, String m ){
//        try {
//            Method met = View.Alert.AlertSwap.class.getDeclaredMethod(m);
//            return Answ.equals(met.invoke(this.alertSwap));
//        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored){}
//        return false;
//    }

    void callInvalidMoveError(String error){
        AlertInvalidMove alertInvalidMove = new AlertInvalidMove();
        alertInvalidMove.invalidMoveAlert(error);

    }

    String callGameOverAlert(String ... winner){
        AlertGameOver alertGameOver = new AlertGameOver();
        return alertGameOver.gameOverAlert(winner);
    }

    public void callLoginAlert(){
        AlertLogin alertLogin = new AlertLogin();
        alertLogin.loginAlert();
    }

    void callGetAlertOpening(OpeningType opening){
        AlertOpening alertOpening = new AlertOpening();
        alertOpening.getAlertOpening(opening);
    }

//    public String callSwapAlert(){
//        return alertSwap.swapAlert();
//    }
//
//    public String callSwap2Alert(){
//        return alertSwap.swap2Alert();
//    }

//    public void callSwap2Alert2(){
//        alertSwap.swap2Alert();
//    }

    @Override
    public String swap2Alert(){
        return alertSwap.swap2Alert();
    }

    @Override
    public String swapBlack(){
        return alertSwap.swapBlack();
    }

    @Override
    public String swapAlert() {
        return alertSwap.swapAlert();
    }

//    public String callSwap2_1Alert(){
//        return alertSwap.swapBlack();
//    }

//    public AlertSwap istantiateAlertSwap(){
//        return new AlertSwap();
//    }






}
