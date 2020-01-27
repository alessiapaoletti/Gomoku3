package Model.Rules.Opening;

import Controller.ScoreController;
import View.Alert;

public class Swap2Opening extends SwapOpening {

    Swap2Opening(){
        this.openingType = OpeningType.Swap2;
        this.numMoves = 3;
    }

    @Override
    public void openingBehaviour(int numClicks) {
        whichSwap2(numClicks);
    }

    @Override
    public void utilitySwap() {
        player1.addMove(player2.getMoves().get(1));
        player2.addMove(player1.getMoves().get(2));
        player1.removeMove(2);
        player2.removeMove(1);
        super.utilitySwap();
    }

    private void whichSwap2(int numClicks){
        if (numClicks != 5) this.over = this.swap2InitQuestions();
        else if (!this.over) this.swap2LastQuestion();
    }

    private Boolean swap2InitQuestions() {
        if ("YES".equals(Alert.swapAlert())){
            ScoreController.swapLabels();
            super.utilitySwap();
            checkError();
        } else {
            if ("YES".equals(Alert.swap2Alert()))
                checkError();
            else{
                Alert.swap2Alert2();
                return false;
            }
        }
        return true;
    }

    private void swap2LastQuestion(){
        if ("YES".equals(Alert.swap2_1Alert())) {
            ScoreController.swapLabels();
            this.utilitySwap();
        }
        checkError();
    }
}
