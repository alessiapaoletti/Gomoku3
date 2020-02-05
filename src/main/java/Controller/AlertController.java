package Controller;

import ControllerCL.AlertControllerInterface;
import Model.Rules.Opening.OpeningType;
import View.Alert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AlertController implements AlertControllerInterface {

    AlertSwap alertSwap = new AlertSwap();

    public boolean AnswerQuestionAlert(String Answ, String m ){
        try {
            Method met = View.Alert.AlertSwap.class.getDeclaredMethod(m);
            return Answ.equals(met.invoke(this.alertSwap));
        }catch (NoSuchMethodException e){}
        catch (InvocationTargetException i){}
        catch (IllegalAccessException r){};
        return false;
    }

    public void callInvalidMoveError(String error){
        AlertInvalidMove alertInvalidMove = new AlertInvalidMove();
        alertInvalidMove.invalidMoveAlert(error);
    }

    public String callGameOverAlert(String ... winner){
        AlertGameOver alertGameOver = new AlertGameOver();
        return alertGameOver.gameOverAlert(winner);
    }

    public void callLoginAlert(){
        AlertLogin alertLogin = new AlertLogin();
        alertLogin.loginAlert();
    }

    public void callGetAlertOpening(OpeningType opening){
        AlertOpening alertOpening = new AlertOpening();
        alertOpening.getAlertOpening(opening);
    }

    public String callSwapAlert(){
        return alertSwap.swapAlert();
    }

    public String callSwap2Alert(){
        return alertSwap.swap2Alert();
    }

    public void callSwap2Alert2(){
        alertSwap.swap2Alert2();
    }

    public String callSwap2_1Alert(){
        return alertSwap.swap2_1Alert();
    }

    public AlertSwap istantiateAlertSwap(){
        return new AlertSwap();
    }






}
