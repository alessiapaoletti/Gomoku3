package Model;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Piece.PieceType color;
    private List<Piece> movesList = new ArrayList<>();

    //le stringhe bho??
    public Player(String name,String color){
        this.name = name;
        if(color.equals("Black")) { this.color = Piece.PieceType.BLACK;}
        else {this.color = Piece.PieceType.WHITE;}
    }

    public void addMove(Piece piece){
        movesList.add(piece);
    }

    public void removeMove(int position){
        movesList.remove(movesList.get(position));
    }

    public String getName() {
        return name;
    }

    public Piece.PieceType getColor() {
        return this.color;
    }

    public String getColorName(){ return this.color.name(); }

    public void setColor(Piece.PieceType color) {
        this.color = color;
    }

    public List<Piece> getMoves(){return movesList;}

    public boolean isPlayerMove(Piece piece){
        for(Piece p : this.getMoves()) {
            if (piece.samePosition(p)) return true;
        }
        return false;
    }

    boolean checkAllMoves(Player opponent){
        List<Piece> intersection = new ArrayList<>(this.movesList);
        intersection.retainAll(opponent.getMoves());
        return intersection.isEmpty();
    }

    void printMoves(){
        System.out.println("movements for player "+this.name+":");
        for(Piece piece : movesList) {
            System.out.println(piece.getX() +" "+ piece.getY());
        }
    }
}
