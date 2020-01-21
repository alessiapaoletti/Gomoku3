package Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private String name;
    private Piece.PieceType color;
    private List<Pair<Integer, Integer>> positionsList = new ArrayList<>();


    public Player(String name,String color){
        this.name = name;
        if(color.equals("Black")) { this.color = Piece.PieceType.BLACK;}
        else {this.color = Piece.PieceType.WHITE;}
    }


    public void addPosition(Pair<Integer, Integer> position){
        positionsList.add(position);
    }

    public void removePosition(int i){
        positionsList.remove(positionsList.get(i));
    }

    public String getName() {
        return name;
    }

    public Piece.PieceType getColor() {
        return this.color;
    }

    public String getColorName(){
        return this.color.name(); }
//                valueOf(this.color);
//        if (this.color.colorPiece == 1 ) return "Black";
//        else return "White";
 //   }

//    public void setName(String name){
//        this.name = name;
//    }

    public void setColor(Piece.PieceType color) {
        this.color = color;
        //this.color.set(i);
    }

    void printPositions(){
        System.out.println("movements for player "+this.name+":");
        for(Pair pair : positionsList) {
            System.out.println(pair.getKey() +" "+ pair.getValue());
        }
    }

    public List<Pair<Integer, Integer>> getPositions(){
        return positionsList;
    }

    public boolean checkMove(Pair pair){
        boolean b=false;
        for(Pair p : this.getPositions()) {
            if (p.getKey()== pair.getKey() && p.getValue()==pair.getValue()) b=true;
        }
        return b;
    }

    public boolean checkAllMoves(Player p){
        List<Pair<Integer, Integer>> intersection = new ArrayList<Pair<Integer, Integer>>(this.positionsList);
        intersection.retainAll(p.getPositions());
        return intersection.isEmpty();
    }

}
