package Model.Rules.Opening;
import Model.Player;

public abstract class Opening {
    Player player1;
    Player player2;
    int numMoves;
    Boolean over;
    OpeningType openingType;

    public Opening(){ }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2){
        this.player2 = player2;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(int numClicks){
        this.openingBehaviour(numClicks);
    }

    public abstract void openingBehaviour(int numClicks);

    public OpeningType getOpeningType(){ return this.openingType;}


    /** questa funzione che senso ha che sia qui? Non è un problema solo delle opening ....
     * è un controllo che andrebbe fatto in generale.. **/
    void checkError(){
        if(!player1.checkAllMoves(player2)) throw new Error("place stones in different places");
    }

}
