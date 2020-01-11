package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private final String name;
    private int score = 0;
    private AtomicInteger color;
    private List<Piece> position=new ArrayList<>();
    //The idea is to set the position for each player and initialize
    // it with the opening rules.

    public Player(String name,String color){
        this.name = name;
        if(color.equals("Black")) {this.color=new AtomicInteger(1);}
        else {this.color=new AtomicInteger(2);}
    }

    public void addPosition(Piece m){ position.add(m); }

    public void removePosition(int i){
        position.remove(position.get(i));
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getColor() {
        return this.color;
    }

    public String getNameColor(){
        if (this.color.get() == 1) return "Black";
        else return "White";
    }

    public void SetColor(int i) {
        this.color.set(i);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) { this.score = score; }

    void PrintPositions(){
        System.out.println("movements for player "+this.name+":");
        for(Piece model : position) {
            System.out.println(model.getX()+" "+model.getY());
        }
    }

    public List<Piece> getPositions(){
        return position;
    }

    public boolean checkInMoves(Piece m){ return position.contains(m); }

    public boolean checkAllMoves(Player p){
        List<Piece> intersection = new ArrayList<>(this.position);
        intersection.retainAll(p.getPositions());
        return intersection.isEmpty();
    }
}
