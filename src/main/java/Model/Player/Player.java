package Model.Player;

import java.util.ArrayList;
import Model.Piece.*;
import java.util.List;

public abstract class Player {

    private String name;
    private PieceColor color;
    private List<Piece> movesList = new ArrayList<>();

     Player(final String name, PieceColor color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return this.color;
    }

    public String getColorName(){ return this.color.name(); }

    public List<Piece> getMoves(){return movesList;}

    public void addMove(final Piece piece){
        movesList.add(piece);
    }

    public void removeMove(final int position){
        movesList.remove(movesList.get(position));
    }

    public void setColor(final PieceColor color) {
        this.color = color;
    }

    public void setName(String name){ this.name = name; }

    public int listSize(){ return this.movesList.size(); }

    public boolean isPlayerMove(final Piece piece){
        return movesList.stream().anyMatch(piece::samePosition);

        /*for(Piece p : this.getMoves()) {
            if (piece.samePosition(p)) return true;
        }
        return false;*/
    }

//    public boolean checkAllMoves(final Player opponent){
//        List<Piece> intersection = new ArrayList<>(this.movesList);
//        intersection.retainAll(opponent.getMoves());
//        return intersection.isEmpty();
//    }
//
//    public void printMoves(){
//        System.out.println("movements for player "+this.name+":");
//        for(Piece piece : movesList) {
//            System.out.println(piece.getX() +" "+ piece.getY());
//        }
//    }


}
