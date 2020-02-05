package Model.Rules.Opening;


import java.lang.reflect.InvocationTargetException;

public class Swap2Opening extends SwapOpening {

    private Boolean answerInitQuestions;

    Swap2Opening(){
        this.openingType = OpeningType.Swap2;
    }

    @Override
    public void openingBehaviour() {
        if ( (this.whitePlayer.listSize() + this.blackPlayer.listSize())!= 5) this.answerInitQuestions = this.swap2InitQuestions();
        else if (!this.answerInitQuestions) { this.swap2LastQuestion();}
    }

    private Boolean swap2InitQuestions(){
        if (super.alertControllerInterface.AnswerQuestionAlert("YES","swapAlert")){
            super.SwapLabel();
            super.utilitySwap();
        } else {
            if (super.alertControllerInterface.AnswerQuestionAlert("NO","swap2Alert")) {
                super.alertControllerInterface.callSwap2Alert2();
                return false;
            }
        }
        return true;
    }

    private void swap2LastQuestion(){
        if (super.alertControllerInterface.AnswerQuestionAlert("YES","swap2_1Alert")) {
            super.SwapLabel();
            super.utilitySwap();
        }
    }
}
