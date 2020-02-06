package Controller;

import Model.Rules.Opening.OpeningType;
import View.Alert.*;

public class AlertController implements AlertControllerInterface{

    private AlertSwap alertSwap = new AlertSwap();

//    @Override
//    public boolean AnswerQuestionAlert(String Answ, String m) {
//        try {
//            Method met = ViewCL.Alert.AlertSwap.class.getDeclaredMethod(m);
//            return Answ.equals(met.invoke(this.alertSwap));
//        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored){}
//        return false;
//    }

//    @Override
//    public void callSwap2Alert2() {
//        this.alertSwap.swap2Alert2();
//    }

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

    void callInvalidMoveError(String error){
        new AlertInvalidMove().invalidMoveAlert(error);
    }

    void callGameOverAlert(String ... winner){
         new AlertGameOver().gameOverAlert(winner);
    }

  /*  public void callLoginWelcome(){
        new AlertLogin().welcomePrint();
    }

    public void callLoginBlack(){
        new AlertLogin().setBlackPlayer();
    }

    public void callLoginWhite(){
        new AlertLogin().setWhitePlayer();
    }

    public void callLoginOpening(){
        new AlertLogin().setOpening();
    }

    public void callLoginGame(){
        new AlertLogin().setGame();
    }

    public void callLoginAlert(){
        new AlertLogin().loginAlert();
    }
*/
    void callGetAlertOpening(OpeningType opening){
        new AlertOpening().getAlertOpening(opening);
    }
}
