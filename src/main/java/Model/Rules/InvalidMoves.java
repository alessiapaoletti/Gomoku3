package Model.Rules;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.HotFormations.Three;
import Model.HotFormations.ThreeFactory;
import Model.Piece;
import Model.Player;

import java.util.*;

public class InvalidMoves {
    private int dimBoard;
    private Player black;
    private Player white;
    public InvalidMoves(){}

    public void setPlayers(Player p1, Player p2){
        this.black=p1;
        this.white=p2;
    }
    public void setDimBoard(int dim){this.dimBoard =dim;}

    private void findFork(Piece piece, Directions.Dir direction, Three.ThreeTypes three, Set<Piece> pieceSet) {
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        Three th = ThreeFactory.getThree(three).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        th.setDim(this.dimBoard);
        th.setPlayers(this.black, this.white);
        th.check(piece, -1, pieceSet, dir);
        th.check(piece, 1, pieceSet, dir);
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

    public void threeAndThree(){
//        List<String> directions = Arrays.asList("Horizontal","HorizontalGap","Vertical","VerticalGap",
//                "Diagonal1","Diagonal1Gap", "Diagonal2","Diagonal2Gap");
        List<Directions.Dir> directions = Arrays.asList(Directions.Dir.HORIZONTAL, Directions.Dir.VERTICAL,
                Directions.Dir.DIAGONAL1, Directions.Dir.DIAGONAL2);
        List<Three.ThreeTypes> three = Arrays.asList(Three.ThreeTypes.THREE, Three.ThreeTypes.GAPTHREE);
        int sizeList =black.getMoves().size();
        Piece lastMove = black.getMoves().get(sizeList - 1);
        List<Piece> pieceList= new ArrayList<>();
        for (Directions.Dir dir : directions){
            for(Three.ThreeTypes t: three){
            Set<Piece> pieceSet= new HashSet<>();
            //black.getMoves().forEach(i -> this.findFork(i, dir,pieceSet));
            black.getMoves().forEach(i -> this.findFork(i, dir,t,pieceSet));
            pieceList.addAll(pieceSet);
            }
        }
        this.checkError(lastMove,pieceList);
    }
}

