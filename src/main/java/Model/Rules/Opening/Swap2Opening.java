package Model.Rules.Opening;

public class Swap2Opening extends SwapOpening {

    private Boolean answerInitQuestions = false;

    Swap2Opening() {
        this.openingType = OpeningType.Swap2;
    }

    @Override
    public void openingBehaviour() {
        if ((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 3)
            this.answerInitQuestions = swap2WhiteOptions();

        if (!this.answerInitQuestions && ((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 4)) {
            super.gameStatusControllerInterface.swapColorTurn();
        }

        if (!this.answerInitQuestions && ((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 5))
            this.swap2SwapBlack();
    }

    private boolean swap2WhiteOptions() {
        String answer = super.alertControllerInterface.swap2Alert(super.whitePlayer.getName());
        if ("1".equals(answer)) {
            /*white player stay white and put 4th stone*/
            return true;
        } else if ("2".equals(answer)) {
            /*white player swap color and control black stones*/
            super.gameStatusControllerInterface.swapLabel();
            super.gameStatusControllerInterface.swapColorTurn();
            super.utilitySwap();
            return true;
        } else
            return false;  /*white player insert two more stones, then Black player decides if swap*/
    }

    private void swap2SwapBlack() {
        if ("YES".equals(super.alertControllerInterface.swapBlack(super.blackPlayer.getName()))) {
            super.gameStatusControllerInterface.swapLabel();
            super.utilitySwap();
        } else super.gameStatusControllerInterface.swapColorTurn();
    }

}