package Model;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Piece.PieceType color;
    private List<Piece> positionsList = new ArrayList<>();

    public Player(String name,String color){
        this.name = name;
        if(color.equals("Black")) { this.color = Piece.PieceType.BLACK;}
        else {this.color = Piece.PieceType.WHITE;}
    }

    public void addPosition(Piece piece){
        positionsList.add(piece);
    }

    public void removePosition(int position){
        positionsList.remove(positionsList.get(position));
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

    public List<Piece> getPositions(){return positionsList;}

    boolean isPlayerMove(Piece piece){
        for(Piece p : this.getPositions()) {
            if (piece.equalsCoordinates(p)) return true;
        }
        return false;
    }

    boolean checkAllMoves(Player p){
        List<Piece> intersection = new ArrayList<>(this.positionsList);
        intersection.retainAll(p.getPositions());
        return intersection.isEmpty();
    }

    void printPositions(){
        System.out.println("movements for player "+this.name+":");
        for(Piece piece : positionsList) {
            System.out.println(piece.getX() +" "+ piece.getY());
        }
    }
}
