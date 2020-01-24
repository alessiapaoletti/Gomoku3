package Model.Directions;


import Model.GomokuGame;
import Model.Piece;

import java.util.Set;

public abstract class Directions {

   /* protected boolean in = true;
    protected boolean out = true;
    protected boolean outOpp = true;*/
    int dim_board;
    final int range1 = 1;
    final int range2 = 2;
    final int range3 = 3;
    final int range4 = 4;
    final int range5 = 5;

    public abstract  boolean outOfGridCheck(int x, int y, int sign);
    public abstract boolean updateIn(int x, int y, int sign ,String col);
    public abstract boolean updateOut(int x, int y, int sign);
    public abstract void check(int x, int y, int sign, Set<Piece> pieceSet);
    public abstract boolean consecutiveFivePiece(int x, int y, int sign,String col);
    public abstract boolean FiveBoundaries(int x, int y, int sign,String col);
    boolean isEmpty(int x, int y){ return !isPieceIn(x,y,"BLACK") && !isPieceIn(x,y,"white"); }

    /*questa funzione non ci dovrebbe essere, bisognerebbe chiamare la funzione is outOfGrid della boardLogic*/
    public void Setdim(int dim){this.dim_board=dim;}
    boolean isOutOfGrid(int x, int y){ return ((x <0 || x>this.dim_board) || (y<0 || y>this.dim_board)); }

    int updateCoord(int cord, int increment, int sign) {
        return cord + increment * sign;
    }
    private void fillIn(int x, int y, int x1, int y1, int x2, int y2, Set<Piece> pieceSet){
        pieceSet.add(new Piece(x,y, Piece.PieceType.BLACK));
        pieceSet.add(new Piece(x1,y1,Piece.PieceType.BLACK));
        pieceSet.add(new Piece(x2,y2,Piece.PieceType.BLACK));
    }

    void auxiliaryCheck(int sign, int x, int y, int x1, int y1, int x2, int y2, Set<Piece> pieceSet) {
        if (this.updateIn(x, y, sign,"BLACK") && this.updateOut(x, y, sign) && this.outOfGridCheck(x, y, sign))
            this.fillIn(x1, y1, x2, y2, x, y, pieceSet);
    }

    public  boolean isPieceIn(final int x, final int y,String b){
        if(b.equals("BLACK"))
            return GomokuGame.getBlackPlayer().isPlayerMove(new Piece(x,y));
        else
            return GomokuGame.getWhitePlayer().isPlayerMove(new Piece(x,y));
    }


}
