import Model.Player;
import Model.Piece;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
* Test class for the player class implementation.
*
*/

public class PlayerTest {

    /*  *  Test constructor,getname(),getColor(),SetColor()  */
    @Test
    public void createNewPlayer(){
        Player player=new Player("mario","white");
        assertEquals(player.getName(),"mario");
        assertEquals(player.getColor(), Piece.PieceType.WHITE);
        player.setColor(Piece.PieceType.BLACK);
        assertEquals(player.getColor(), Piece.PieceType.BLACK);
    }

    /* *  Test constructor,addposition(),getPositions(),removeposition() */
    @Test
    public void fillMoves(){
        Player player =new Player("mario","white");
        //Piece piece = new Piece(Piece.PieceType.WHITE);
        Pair<Integer, Integer> piece = new Pair<>(1,2);
        player.addPosition(piece);
        assertEquals(player.getPositions().get(0),piece);
        player.removePosition(0);
        assertEquals(player.getPositions().size(),0);
    }

    /* *  Test constructor,CheckinMoves() */
    @Test
    public void checkInmoves(){
//        Player p=new Player("mario","white");
//        Piece pie=new Piece(2);
//        pie.setX(1);
//        pie.setY(2);
//        p.addPosition(pie);
//        Piece pie1=new Piece(2);
//        pie1.setX(4);
//        pie1.setY(2);
//        assertEquals(p.checkMoves(pie1),false);

    }

    /* *  Test constructor,CheckAllMoves()  */
    @Test
    public void checkAllmoves(){
//        Player p=new Player("mario","white");
//        Piece pie=new Piece(2);
//        pie.setX(1);
//        pie.setY(2);
//        p.addPosition(pie);
//        Player p1=new Player("mario","black");
//        Piece pie1=new Piece(2);
//        pie1.setX(4);
//        pie1.setY(2);
//        p1.addPosition(pie1);
//        assertEquals(p.checkAllMoves(p1),true);

    }

}