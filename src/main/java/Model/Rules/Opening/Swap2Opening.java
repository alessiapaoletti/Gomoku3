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
        if ("YES".equals(AlertSwap.swapAlert())){
            GameStatusController.swapLabels();
            super.utilitySwap();
        } else {
            if ("NO".equals(AlertSwap.swap2Alert())) {
                AlertSwap.swap2Alert2();
                return false;
            }
        }
        return true;
    }

    private void swap2LastQuestion(){
        if ("YES".equals(AlertSwap.swap2_1Alert())) {
            GameStatusController.swapLabels();
            super.utilitySwap();
        }
    }
}
