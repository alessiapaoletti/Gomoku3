package ControllerCL;

import Model.Rules.Opening.OpeningType;
import ViewCL.Alert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AlertController implements AlertControllerInterface{

    private AlertSwap alertSwap=new AlertSwap();

    @Override
    public boolean AnswerQuestionAlert(String Answ, String m) {
        try {
            Method met = ViewCL.Alert.AlertSwap.class.getDeclaredMethod(m);
            return Answ.equals(met.invoke(this.alertSwap));
        }catch (NoSuchMethodException e){}
        catch (InvocationTargetException i){}
        catch (IllegalAccessException r){};
        return false;
    }

    @Override
    public void callSwap2Alert2() {
        this.alertSwap.swap2Alert2();
    }

    public void callInvalidMoveError(String error){
        new AlertInvalidMove().invalidMoveAlert(error);
    }

    public void callGameOverAlert(String ... winner){
         new AlertGameOver().gameOverAlert(winner);
    }

    public void callLoginWelcome(){
        new AlertLogin().Welcome();
    }

    public void callLoginBlack(){
        new AlertLogin().SetBlackPlayer();
    }

    public void callLoginWhite(){
        new AlertLogin().SetWhitePlayer();
    }

    public void callLoginOpening(){
        new AlertLogin().SetOpening();
    }

    public void callLoginGame(){
        new AlertLogin().SetGame();
    }

    public void callLoginAlert(){
        new AlertLogin().loginAlert();
    }

    public void callGetAlertOpening(OpeningType opening){
        new AlertOpening().getAlertOpening(opening);
    }
}
