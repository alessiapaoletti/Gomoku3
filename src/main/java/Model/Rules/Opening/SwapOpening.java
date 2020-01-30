package Model.Rules.Opening;

import Controller.ScoreController;
import Model.PieceColor;
import View.Alert.*;

public class SwapOpening extends Opening {

    SwapOpening(){
        this.openingType = OpeningType.Swap;
        this.numMoves = 3;
    }

    public void utilitySwap() {
        player1.addMove(player2.getMoves().get(0));
        player2.addMove(player1.getMoves().get(0));
        player2.addMove(player1.getMoves().get(1));
        player1.removeMove(1);
        player1.removeMove(0);
        player2.removeMove(0);
        player1.setColor(PieceColor.WHITE);
        player2.setColor(PieceColor.BLACK);
    }

    @Override
    public void openingBehaviour(int numClicks){
        if(numClicks == 3) swapQuestion();
    }

    private void swapQuestion(){
        if ("YES".equals(AlertSwap.swapAlert())){
            ScoreController.swapLabels();
            this.utilitySwap();
        }
    }
}
