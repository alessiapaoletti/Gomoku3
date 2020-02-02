package Model.Rules.Opening;

import Controller.GameStatusController;
import View.Alert.*;

public class SwapOpening extends Opening {

    SwapOpening(){
        this.openingType = OpeningType.Swap;
        this.numMoves = 3;
    }

    public void utilitySwap() {
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
        AlertSwap alerts=new AlertSwap();
        if ("YES".equals(alerts.swapAlert())){
            GameStatusController.swapLabels();
            this.utilitySwap();
        }
    }
}
