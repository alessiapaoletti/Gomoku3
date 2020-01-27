package Model.Rules;

import Controller.ScoreController;
import Model.Piece;
import Model.Player;
import View.Alert;

public class Swap2Opening extends Opening {

    SwapOpening swapOpening;

    public Swap2Opening(){
        this.numMoves = 3;
    }

    @Override
    public void toDoOpening(int c) {
        System.out.println("call swap2");
        whichSwap2(c);
    }

    public void utilitySwap2() {
        player1.addMove(player2.getMoves().get(0));
        player1.addMove(player2.getMoves().get(1));
        player2.addMove(player1.getMoves().get(0));
        player2.addMove(player1.getMoves().get(1));
        player2.addMove(player1.getMoves().get(2));
        player1.removeMove(2);
        player1.removeMove(1);
        player1.removeMove(0);
        player2.removeMove(1);
        player2.removeMove(0);
        player1.setColor(Piece.PieceType.WHITE);
        player2.setColor(Piece.PieceType.BLACK);
    }

    private void whichSwap2(int c){
        if (c != 5) this.over = this.Swap2();
        else if (!this.over) this.Swap2_1();
    }

    private Boolean Swap2() {
        if ("YES".equals(Alert.swapAlert())){
            ScoreController.swapLabels();
            this.swapOpening.utilitySwap();
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

    private void Swap2_1(){
        if ("YES".equals(Alert.swap2_1Alert())) {
            ScoreController.swapLabels();
            this.utilitySwap2();
        }
        checkError();
    }
}
