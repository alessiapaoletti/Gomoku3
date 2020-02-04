package Model.Rules.Opening;

import Model.BlackPlayer;
import Model.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import javafx.scene.control.Alert;
import srcCommandLine.main.java.ControllerCL.*;
import srcCommandLine.main.java.ViewCL.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

public abstract class Opening {

    BlackPlayer blackPlayer;
    WhitePlayer whitePlayer;
    OpeningType openingType;
    int numMoves;
    protected View.Alert.AlertSwap alert;
    protected ViewCL.Alert.AlertSwap print;

    public Opening(){ };

    protected boolean AnswerQuestionAlert(String Answ,String m ){
        try {
            Method met = View.Alert.AlertSwap.class.getDeclaredMethod(m);
            Method met1 = ViewCL.Alert.AlertSwap.class.getDeclaredMethod(m);
            if(this.alert!=null) return Answ.equals(met.invoke(this.alert));
            else return Answ.equals(met1.invoke(this.print));
        }catch (NoSuchMethodException e){}
        catch (InvocationTargetException i){}
        catch (IllegalAccessException r){};
        return false;
    };
    protected void SwapLabel(){
        try {
            Controller.GameStatusController.swapLabels();
        }catch (ExceptionInInitializerError e){
            ControllerCL.GameStatusController.swapLabels();
        }
    };

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(View.Alert.AlertSwap a){
        this.alert=a;
         this.openingBehaviour();
    };

    public void callOpening(ViewCL.Alert.AlertSwap p){
        this.print=p;
        this.openingBehaviour();
    };

    public abstract void openingBehaviour();

    public OpeningType getOpeningType(){ return this.openingType;}

    public BlackPlayer getBlackPlayer() {
        return this.blackPlayer;
    }

    public WhitePlayer getWhitePlayer() {
        return this.whitePlayer;
    }
}
