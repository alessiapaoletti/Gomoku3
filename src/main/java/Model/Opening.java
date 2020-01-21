package Model;

import Controller.BoardController;
import View.Alert;

import java.util.HashMap;
import java.util.function.Consumer;

public class Opening {
    private Player player1;
    private Player player2;
    private String method;
    private int numMoves=0;
    private Boolean over;

    public Opening(Player p1, Player p2, String m){
        this.player1=p1;
        this.player2=p2;
        this.method=m;
        System.out.println(this.method);
        if(this.method.equals("Standard")) this.numMoves=2;
        else this.numMoves=3;
    }

    int getNumMoves(){ return this.numMoves; }

    private HashMap<String, Consumer<Integer>> openingMap = new HashMap<>();

    {
        openingMap.put("Standard", (c) -> { if(c == 2) CheckError(); });
        openingMap.put("Swap", (c) -> { if(c == 3) Swap(); });
        openingMap.put("Swap2", this::whichSwap2 );
    }

    public Consumer<Integer> getOpening(String opening) { return openingMap.get(opening); }

    void callOpening(int c){
        getOpening(this.method).accept(c);

    }

    private void whichSwap2(int c){
        if (c != 5) this.over = this.Swap2();
        else if (!this.over) this.Swap2_1();
    }

    private void CheckError(){

        if(!player1.checkAllMoves(player2)){
            throw new Error("place stones in different places");
        }else{
            System.out.println("end of opening moves");
        }
    }

//    private void OpenStd(){
//        CheckError();
//    }

    private void utilitySwap(String S) {
        player1.addPosition(player2.getPositions().get(0));
        if (S.equals("Swap2")) player1.addPosition(player2.getPositions().get(1));
        player2.addPosition(player1.getPositions().get(0));
        player2.addPosition(player1.getPositions().get(1));
        if (S.equals("Swap2")) {
            player2.addPosition(player1.getPositions().get(2));
            player1.removePosition(2);
        }
        player1.removePosition(1);
        player1.removePosition(0);
        if (S.equals("Swap2")) player2.removePosition(1);
        player2.removePosition(0);
        player1.setColor(Piece.PieceType.WHITE);
        player2.setColor(Piece.PieceType.BLACK);
    }

    private void Swap(){
        if ("YES".equals(Alert.swapAlert())){
            BoardController.scoreController.swapLabels();
            this.utilitySwap("swap");
        }
        CheckError();
    }

    private Boolean Swap2() {
        if ("YES".equals(Alert.swapAlert())){
            BoardController.scoreController.swapLabels();
            this.utilitySwap("swap");
            CheckError();
        } else {
            if ("YES".equals(Alert.swap2Alert()))
                CheckError();
            else{
                Alert.swap2Alert2();
                return false;
            }
        }
        return true;
    }

    private void Swap2_1(){
        if ("YES".equals(Alert.swap2_1Alert())) {
            this.utilitySwap("Swap2");
        }
        CheckError();
    }
}