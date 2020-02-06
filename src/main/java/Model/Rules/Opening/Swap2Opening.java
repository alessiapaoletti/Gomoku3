package Model.Rules.Opening;

public class Swap2Opening extends SwapOpening {

    private Boolean answerInitQuestions;

    Swap2Opening(){
        this.openingType = OpeningType.Swap2;
    }

    @Override
    public void openingBehaviour() {
        if((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 3)
            this.answerInitQuestions  = swap2WhiteOptions();
        if (!this.answerInitQuestions && ((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 5))
            this.swap2SwapBlack();
//        if ((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 3) this.answerInitQuestions = this.swap2InitQuestions();
//        else if (!this.answerInitQuestions && (this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 5) this.swap2LastQuestion();

//        if ( (this.whitePlayer.listSize() + this.blackPlayer.listSize())!= 5) this.answerInitQuestions = this.swap2InitQuestions();
//        else if (!this.answerInitQuestions) { this.swap2LastQuestion();}
    }

    private boolean swap2WhiteOptions() {
        String answer = super.alertControllerInterface.swap2Alert();
        if ("1".equals(answer))
            /*white player stay white and put 4th stone*/
            return true;
        else if ("2".equals(answer)) {
            /*white player swap color and control black stones*/
            super.SwapLabel();
            super.utilitySwap();
            return true;
        } else
            return false;  /*white player insert two more stones, then Black player decides if swap*/
    }



//
//            if (super.alertControllerInterface.AnswerQuestionAlert("Option One", "swap2Alert"))
//            return true;
//        else if (super.alertControllerInterface.AnswerQuestionAlert("Option Two","swap2Alert")) {
//            super.SwapLabel();
//            super.utilitySwap();
//            return true;
//        } else
//            return false;
//        if (super.alertControllerInterface.AnswerQuestionAlert("YES","swapAlert")){
//            super.SwapLabel();
//            super.utilitySwap();
//        } else {
//            if (super.alertControllerInterface.AnswerQuestionAlert("NO","swap2Alert")) {
//                super.alertControllerInterface.callSwap2Alert2();
//                return false;
//            }
//        }
//        return true;
    //}


    private void swap2SwapBlack(){
        if ("YES".equals(super.alertControllerInterface.swapBlack()))
            super.SwapLabel();
            super.utilitySwap();
        }
    }

