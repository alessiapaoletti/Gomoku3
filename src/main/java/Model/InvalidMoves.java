package Model;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import java.util.*;

class InvalidMoves {
    private int dimBoard;
    private Player black;
    private Player white;
    InvalidMoves(){}

    void setPlayers(Player p1, Player p2){
        this.black=p1;
        this.white=p2;
    }
    void SetDimBoard(int dim){this.dimBoard =dim;}

    private void findFork(Piece piece, String direction,Set<Piece> pieceSet){
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        dir.setDim(this.dimBoard);
        dir.setPlayers(black,white);
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
        int sizeList =black.getMoves().size();
        Piece lastMove = black.getMoves().get(sizeList - 1);
        List<Piece> pieceList= new ArrayList<>();
        for (String dir : directions) {
            Set<Piece> pieceSet= new HashSet<>();
            black.getMoves().forEach(i -> this.findFork(i, dir,pieceSet));
            pieceList.addAll(pieceSet);
        }
        this.checkError(lastMove,pieceList);
    }
}

