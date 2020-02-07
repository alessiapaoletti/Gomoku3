package Model.Rules.Opening;


public class SwapOpening extends Opening {

    SwapOpening(){
        this.openingType = OpeningType.Swap;
        this.numMoves = 3;
    }

    void utilitySwap() {
        String tmpName = blackPlayer.getName();
        blackPlayer.setName(whitePlayer.getName());
        whitePlayer.setName(tmpName);
    }

    @Override
    public void openingBehaviour(){
        if((this.whitePlayer.listSize() + this.blackPlayer.listSize()) == 3)
            swapQuestion();
    }

    private void swapQuestion(){
        if ("YES".equals(super.alertControllerInterface.swapAlert())){
            super.SwapLabel();
            this.utilitySwap();
            super.gameStatusControllerInterface.swapColorTurn();
        } else {
            //super.gameStatusControllerInterface.swapColorTurn();
        }
    }

}
