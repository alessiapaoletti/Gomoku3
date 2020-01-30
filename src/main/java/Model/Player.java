package Model;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private PieceColor color;
    private List<Piece> movesList = new ArrayList<>();

    public Player(final String name, PieceColor color){
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

    public PieceColor getColor() {
        return this.color;
    }

    public String getColorName(){ return this.color.name(); }

    public void setColor(final PieceColor color) {
        this.color = color;
    }

    public List<Piece> getMoves(){return movesList;}

    public boolean isPlayerMove(final Piece piece){
        for(Piece p : this.getMoves()) {
            if (piece.samePosition(p)) return true;
        }
        return false;
    }

}
