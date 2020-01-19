package Model;

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

    int getNummoves(){ return this.numMoves; }

    private HashMap<String, Consumer<Integer>> openingMap = new HashMap<>();

    {
        openingMap.put("Standard", (c) -> { if(c == 2) OpenStd(); });
        openingMap.put("Swap", (c) -> { if(c == 3) Swap(); });
        openingMap.put("Swap2", this::whichSwap2 );
    }

    public Consumer<Integer> getOpening(String opening) { return openingMap.get(opening); }

    void callOpening(int c){
        getOpening(this.method).accept(c);

        /*switch (this.method){
            case "Standard":
                if(c==2) this.OpenStd();
                break;
            case "Swap":
                if(c==3) this.Swap();
                break;
            case "Swap2":
                if(c!=5) this.over=this.Swap2();
                else if(c==5 && !this.over) this.Swap2_1();
                break;
        }*/
    }

    private void whichSwap2(int c){
        if (c != 5) this.over = this.Swap2();
        else if (!this.over) this.Swap2_1();
    }

    private void CheckError(){

        if(!player1.CheckAllMoves(player2)){
            throw new Error("place stones in different places");
        }else{
            System.out.println("end of opening moves");
        }
    }

    private void OpenStd(){
        CheckError();
    }
/*
    private Player GetBlack(){
        if(player1.getColor().get()==1) return player1;
        else return player2;
    }

    public Player GetWhite(){
        if(player1.getColor().get()==2) return player1;
        else return player2;
    }*/

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
        player1.SetColor(2);
        player2.SetColor(1);
    }

    private void Swap(){
        if ("YES".equals(Alert.swapAlert())){
            GamePlay.scoreController.swapLabels();
            this.utilitySwap("swap");
        }
        CheckError();
    }

    private Boolean Swap2() {
        if ("YES".equals(Alert.swapAlert())){
            GamePlay.scoreController.swapLabels();
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
/*
    private void utilitySwap2(){
        if(player1.equals(this.GetBlack())){
            player1.addPosition(player2.getPositions().get(0));
            player1.addPosition(player2.getPositions().get(1));
            player2.addPosition(player1.getPositions().get(0));
            player2.addPosition(player1.getPositions().get(1));
            player2.addPosition(player1.getPositions().get(2));
            player1.removePosition(2);
            player1.removePosition(1);
            player1.removePosition(0);
            player2.removePosition(1);
            player2.removePosition(0);
            player1.SetColor(2);
            player2.SetColor(1);
        }
        else {
            player2.addPosition(player1.getPositions().get(0));
            player2.addPosition(player1.getPositions().get(1));
            player1.addPosition(player2.getPositions().get(0));
            player1.addPosition(player2.getPositions().get(1));
            player1.addPosition(player2.getPositions().get(2));
            player2.removePosition(2);
            player2.removePosition(1);
            player2.removePosition(0);
            player1.removePosition(1);
            player1.removePosition(0);
            player2.SetColor(2);
            player1.SetColor(1);
        }
    }
*/
    private void Swap2_1(){
        if ("YES".equals(Alert.swap2_1Alert())) {
            this.utilitySwap("Swap2");
        }
        CheckError();
    }
}
