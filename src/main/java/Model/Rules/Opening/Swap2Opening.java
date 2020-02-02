package Model.Rules.Opening;

import Controller.GameStatusController;
import View.Alert.*;

public class Swap2Opening extends SwapOpening {

    private Boolean answerInitQuestions;

    Swap2Opening(){
        this.openingType = OpeningType.Swap2;
    }

    @Override
    public void openingBehaviour() {
        if ( (this.whitePlayer.listSize() + this.blackPlayer.listSize())!= 5) this.answerInitQuestions = this.swap2InitQuestions();
        else if (!this.answerInitQuestions) this.swap2LastQuestion();
    }

    private Boolean swap2InitQuestions() {
        AlertSwap alerts=new AlertSwap();
        if ("YES".equals(alerts.swapAlert())){
            GameStatusController.swapLabels();
            super.utilitySwap();
        } else {
            if ("NO".equals(alerts.swap2Alert())) {
                alerts.swap2Alert2();
                return false;
            }
        }
        return true;
    }

    private void swap2LastQuestion(){
        AlertSwap alerts=new AlertSwap();
        if ("YES".equals(alerts.swap2_1Alert())) {
            GameStatusController.swapLabels();
            super.utilitySwap();
        }
    }
}
