package Model;


public abstract class GomokuGame {
    private static   Player p1;
    private static Player p2;
    private static int nBet = 0;
    private static int gridSize;
    private String op_name;
    Opening op;
    InvalidMoves inv;
    public abstract void initGame();
    public abstract void setRules();

    public void setPlayers(Player p1, Player p2){
        System.out.println(p1.getColor());
        System.out.println(p2.getColor());
        this.p1 = p1;
        this.p2 = p2;
    }

    void OpeningRules(int c){

        op.calling(c);
    }

    public void setOp (String s){
        this.op_name = s;
    }

    public void setSize (int size){
        gridSize = size;
    }

    public String GetName(){return "";}

    static int getnBet(){
        return nBet;
    }

    public static Player getP1() {
        return p1;
    }

    public static Player getP2() {
        return p2;
    }

    static int getGridDim() { return gridSize;  }

    String getOp(){ return this.op_name;}

    int getN(){return this.op.getNummoves();}

}
