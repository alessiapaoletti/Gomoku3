package Model.HotFormations;

import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.Player.*;
import Model.Piece.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class FiveTest {

    BlackPlayer black=new BlackPlayer("mario");
    WhitePlayer white=new WhitePlayer("gino");
    private Directions dir = new DirectionFactory().getDir(Directions.Dir.HORIZONTAL);
    private Five f=new Five();

    void fillPlayer(Player p){
        for(int i=0;i<5;i++) p.addMove(new Piece(i,0, p.getColor()));
    }

    @Test
    public void testConsecutiveFive(){
        this.fillPlayer(black);
        f.setPlayers(black,white);
        assertTrue(f.consecutiveFivePiece(new Piece(0,0,black.getColor()),1,black.getColor(),dir));
    }

    @Test
    public void testfiveBoundaries(){
        this.fillPlayer(black);
        f.setPlayers(black,white);
        assertTrue(f.fiveBoundaries(new Piece(0,0,black.getColor()),1,black.getColor(),dir));
    }

}