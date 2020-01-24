package Model;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import java.util.*;

/**
 * -three and three è un caso particolare di InvalidMoves...
 * al momento è una funzione dentro invalidMoves */
class InvalidMoves {
    int dim_board;
    InvalidMoves(){}

    public void SetDimBoard(int dim){this.dim_board=dim;}

    private void findFork(Piece piece, String direction,Set<Piece> pieceSet){
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        dir.Setdim(this.dim_board);
        dir.check(piece.getX(), piece.getY(),-1,pieceSet);
        dir.check(piece.getX(), piece.getY(),1,pieceSet);
   }

    private int duplicates(Piece lastMove, final List<Piece> pieceList){
        int count=0;
        for(Piece piece : pieceList) {
            if (piece.getX() == lastMove.getX() && piece.getY() == lastMove.getY()) count += 1;
        }
        return count;
    }

    private void checkError(final Piece lastMove, final List<Piece> pieceList){
        if(pieceList.size()>=6 && this.duplicates(lastMove,pieceList)>=2){
            throw new Error("three and three error ");
        }
    }

    void threeAndThree (){
        List<String> directions = Arrays.asList("Horizontal","HorizontalGap","Vertical","VerticalGap",
                "Diagonal1","Diagonal1Gap", "Diagonal2","Diagonal2Gap");
        int sizeList = GomokuGame.getBlackPlayer().getMoves().size();
        Piece lastMove = GomokuGame.getBlackPlayer().getMoves().get(sizeList - 1);
        List<Piece> pieceList= new ArrayList<>();
        for (String dir : directions) {
            Set<Piece> pieceSet= new HashSet<>();
            GomokuGame.getBlackPlayer().getMoves().forEach(i -> this.findFork(i, dir,pieceSet));
            pieceList.addAll(pieceSet);
        }
        this.checkError(lastMove,pieceList);
    }

}

