package Model;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private Piece.PieceType color;
    private List<Piece> movesList = new ArrayList<>();

    public Player(final String name, Piece.PieceType color){
        this.name = name;
        this.color = color;
    }

    public void addMove(final Piece piece){
        movesList.add(piece);
    }

    public void removeMove(final int position){
        movesList.remove(movesList.get(position));
    }

    public String getName() {
        return name;
    }

    public Piece.PieceType getColor() {
        return this.color;
    }

    public String getColorName(){ return this.color.name(); }

    public void setColor(final Piece.PieceType color) {
        this.color = color;
    }

    public List<Piece> getMoves(){return movesList;}

    public boolean isPlayerMove(final Piece piece){
        for(Piece p : this.getMoves()) {
            if (piece.samePosition(p)) return true;
        }
        return false;
    }

    public boolean checkAllMoves(final Player opponent){
        List<Piece> intersection = new ArrayList<>(this.movesList);
        intersection.retainAll(opponent.getMoves());
        return intersection.isEmpty();
    }

    public void printMoves(){
        System.out.println("movements for player "+this.name+":");
        for(Piece piece : movesList) {
            System.out.println(piece.getX() +" "+ piece.getY());
        }
    }
}
