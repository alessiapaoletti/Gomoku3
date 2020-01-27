package Model.Rules.Opening;

import Model.Player;

public abstract class Opening {
    Player player1;
    Player player2;
    int numMoves;
    Boolean over;

    public Opening(){}

    public Opening(Player p1, Player p2){
        this.player1=p1;
        this.player2=p2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2){
        this.player2 = player2;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(int numClicks){
        this.toDoOpening(numClicks); }

    void checkError(){

        if(!player1.checkAllMoves(player2)) throw new Error("place stones in different places");
    }

    public abstract void toDoOpening(int numClicks);
}
