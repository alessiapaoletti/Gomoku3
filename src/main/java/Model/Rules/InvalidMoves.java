package Model.Rules;

import Model.BlackPlayer;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.HotFormations.Three;
import Model.HotFormations.ThreeFactory;
import Model.Piece;
import Model.WhitePlayer;
import java.util.*;

public class InvalidMoves {

    private int dimBoard;
    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;

    public InvalidMoves(){}

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public void setDimBoard(int dim){this.dimBoard =dim;}

    private void findFork(Piece piece, Directions.Dir direction, Three.ThreeTypes three, Set<Piece> pieceSet) {
        Directions dir = new DirectionFactory().getDir(direction);
        Three th = new ThreeFactory().getThree(three);
        th.setDim(this.dimBoard);
        th.setPlayers(this.blackPlayer, this.whitePlayer);
        th.check(piece, -1, pieceSet, dir);
        th.check(piece, 1, pieceSet, dir);
    }

    private int countDuplicates(Piece lastMove, final List<Piece> pieceList){
        long count = pieceList
                .stream()
                .filter(p -> p.getX() == lastMove.getX() &&  p.getY() == lastMove.getY() )
                .count();
        return (int) count;

        /* int count=0;
        for(Piece piece : pieceList) {
            if (piece.getX() == lastMove.getX() && piece.getY() == lastMove.getY()) count += 1;
        }
        return count; */
    }

    private void checkError(final Piece lastMove, final List<Piece> pieceList) throws Error{
        if(pieceList.size()>=6 && this.countDuplicates(lastMove,pieceList)>=2)
            throw new Error("three and three error ");
    }

    public void threeAndThree() throws Error{
        List<Directions.Dir> directions = Arrays.asList(Directions.Dir.HORIZONTAL, Directions.Dir.VERTICAL,
                Directions.Dir.DIAGONAL1, Directions.Dir.DIAGONAL2);
        List<Three.ThreeTypes> three = Arrays.asList(Three.ThreeTypes.THREE, Three.ThreeTypes.GAPTHREE);
        int sizeList = blackPlayer.getMoves().size();
        Piece lastMove = blackPlayer.getMoves().get(sizeList - 1);
        List<Piece> pieceList= new ArrayList<>();
        for (Directions.Dir dir : directions){
            for(Three.ThreeTypes t: three){
            Set<Piece> pieceSet= new HashSet<>();
            blackPlayer.getMoves().forEach(i -> this.findFork(i, dir,t,pieceSet));
            pieceList.addAll(pieceSet);
            }
        }
        this.checkError(lastMove,pieceList);
    }
}

