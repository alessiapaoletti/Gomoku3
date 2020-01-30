package Model.Rules.Opening;
import Model.Player;

public abstract class Opening {
    Player player1;
    Player player2;
    int numMoves;
    Boolean over;
    OpeningType openingType;

    public Opening(){ }

    public void setPlayers(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(int numClicks){
        this.openingBehaviour(numClicks);
    }

    public abstract void openingBehaviour(int numClicks);

    public OpeningType getOpeningType(){ return this.openingType;}


}
