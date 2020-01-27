package test.java.Model.HotFormations;
import Model.Piece;
import Model.Player;
import  Model.Directions.*;
import Model.HotFormations.Five;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiveTest {
    protected Player black=new Player("mario", Piece.PieceType.BLACK);
    protected Player white=new Player("mario", Piece.PieceType.WHITE);
    Directions dir = DirectionFactory.getDir(Directions.Dir.HORIZONTAL);
    Five f=new Five();

    protected void FillPlayer(Player p){
        p.addMove(new Piece(0,0, p.getColor()));
        p.addMove(new Piece(1,0, p.getColor()));
        p.addMove(new Piece(2,0, p.getColor()));
        p.addMove(new Piece(3,0, p.getColor()));
        p.addMove(new Piece(4,0, p.getColor()));
    };

    @Test
     void TestConsecutiveFive(){
        this.FillPlayer(black);
        f.setPlayers(black,white);
        assertTrue(f.consecutiveFivePiece(new Piece(0,0,black.getColor()),1,black.getColor(),dir));
    };

    @Test
     void TestfiveBoundaries(){
        this.FillPlayer(black);
        f.setPlayers(black,white);
        assertTrue(f.fiveBoundaries(new Piece(0,0,black.getColor()),1,black.getColor(),dir));
    };
}