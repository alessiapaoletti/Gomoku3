package Model.Rules;

import Controller.ScoreController;
import Model.Piece;
import View.Alert;

public class SwapOpening extends Opening {

    public SwapOpening(){
        this.numMoves = 3;
    }

    public void utilitySwap() {
        player1.addMove(player2.getMoves().get(0));
        player2.addMove(player1.getMoves().get(0));
        player2.addMove(player1.getMoves().get(1));
        player1.removeMove(1);
        player1.removeMove(0);
        player2.removeMove(0);
        player1.setColor(Piece.PieceType.WHITE);
        player2.setColor(Piece.PieceType.BLACK);
    }

    @Override
    public void toDoOpening(int c){
        System.out.println("call swap");
        if(c == 3) Swap();
    }

    void Swap(){
        if ("YES".equals(Alert.swapAlert())){
            ScoreController.swapLabels();
            this.utilitySwap();
        }
        checkError();
    }
}
