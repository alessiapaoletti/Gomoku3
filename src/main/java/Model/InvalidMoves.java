package Model;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import javafx.util.Pair;

import java.util.*;

public class InvalidMoves {

    private Player player1;
    private Player player2;

    InvalidMoves(Player p1, Player p2){
        this.player1=p1;
        this.player2=p2;
    }

    private void findFork(Pair<Integer, Integer> piece, String direction,Set<Pair<Integer,Integer>> aux_dir){
        Directions d= DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        d.Check(piece.getKey(), piece.getValue(),-1,aux_dir);
        d.Check(piece.getKey(), piece.getValue(),1,aux_dir);
   }

    private int Duplicates(Pair<Integer, Integer> lastMove,List<Pair<Integer,Integer>> aux){
        int count=0;
        for(Pair<Integer,Integer> el : aux){
            if(el.getKey()==lastMove.getKey() && el.getValue()==lastMove.getValue()) count+=1;
        }
        return count;
    };

    private void Check_Error(Pair<Integer, Integer> lastMove,List<Pair<Integer,Integer>> aux){
        if(aux.size()>=6 && this.Duplicates(lastMove,aux)>=2){
            throw new Error("three and three error ");
        }
    }

    public void threeAndThree (){
        List<String> directions = Arrays.asList("hor","horgap","ver","vergap", "diag1","diag1gap", "diag2","diag2gap");
        int sizeList = GomokuGame.GetBlack().getPositions().size();
        Pair<Integer, Integer> lastMove = GomokuGame.GetBlack().getPositions().get(sizeList - 1);
        List<Pair<Integer,Integer>> aux= new ArrayList<>();
        for (String dir : directions) {
            Set<Pair<Integer,Integer>> aux_dir= new HashSet<>();
            GomokuGame.GetBlack().getPositions().forEach(i -> this.findFork(i, dir,aux_dir));
            aux_dir.forEach(el->aux.add(el));
        }
        this.Check_Error(lastMove,aux);

    }

}

