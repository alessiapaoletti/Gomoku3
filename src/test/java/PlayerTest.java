import Model.Player;
import Model.Piece;
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
        Player p=new Player("mario","white");
        assertEquals(p.getName(),"mario");
        assertEquals(p.getColor().intValue(),2);
        p.SetColor(1);
        assertEquals(p.getColor().intValue(),1);
    };

    /* *  Test constructor,addposition(),getPositions(),removeposition() */
    @Test
    public void fillMoves(){
        Player p=new Player("mario","white");
        Piece pie=new Piece(2);
        pie.setX(1);
        pie.setY(2);
        p.addPosition(pie);
        assertEquals(p.getPositions().get(0),pie);
        p.removePosition(0);
        assertEquals(p.getPositions().size(),0);
    };

    /* *  Test constructor,CheckinMoves() */
    @Test
    public void checkInmoves(){
        Player p=new Player("mario","white");
        Piece pie=new Piece(2);
        pie.setX(1);
        pie.setY(2);
        p.addPosition(pie);
        Piece pie1=new Piece(2);
        pie1.setX(4);
        pie1.setY(2);
        assertEquals(p.CheckinMoves(pie1),false);

    }

    /* *  Test constructor,CheckAllMoves()  */
    @Test
    public void checkAllmoves(){
        Player p=new Player("mario","white");
        Piece pie=new Piece(2);
        pie.setX(1);
        pie.setY(2);
        p.addPosition(pie);
        Player p1=new Player("mario","black");
        Piece pie1=new Piece(2);
        pie1.setX(4);
        pie1.setY(2);
        p1.addPosition(pie1);
        assertEquals(p.CheckAllMoves(p1),true);

    }

}