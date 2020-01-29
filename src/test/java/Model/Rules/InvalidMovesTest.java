package Model.Rules;

import Model.Piece;
import Model.PieceColor;
import Model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvalidMovesTest {

    private Player black=new Player("mario", PieceColor.BLACK);
    private Player white=new Player("mario",PieceColor.WHITE);

    private int gridDim = 18;
    private InvalidMoves invalidMoves = new InvalidMoves();

    @Test
    public void initialization(){
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        assertEquals(black.getColor(),PieceColor.BLACK);
        assertEquals(white.getColor(),PieceColor.WHITE);
    }

    private void createVerticalHorizontalFork(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,5,PieceColor.BLACK));
        this.black.addMove(new Piece(4,5,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
        this.black.addMove(new Piece(5,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalHorizontalFork() {
        /*number 1*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalHorizontalFork();
        invalidMoves.threeAndThree();
    }

    private void createVerticalHorizontalForkWhite(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(12,11,PieceColor.BLACK));
        this.white.addMove(new Piece(3,5,PieceColor.WHITE));
        this.white.addMove(new Piece(4,5,PieceColor.WHITE));
        this.white.addMove(new Piece(5,4,PieceColor.WHITE));
        this.white.addMove(new Piece(5,3,PieceColor.WHITE));
        this.white.addMove(new Piece(5,5,PieceColor.WHITE));
    }

    @Test(expected = Test.None.class)
    public void verticalHorizontalForkWhite() {
        /*no error expected -> invalid moves only for the black player*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalHorizontalForkWhite();
        invalidMoves.threeAndThree();
    }

    private void createVerticalHorizontalForkGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(2,5,PieceColor.BLACK));
        this.black.addMove(new Piece(3,5,PieceColor.BLACK));
        this.black.addMove(new Piece(5,2,PieceColor.BLACK));
        this.black.addMove(new Piece(5,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalHorizontalForkGap() {
        /*number 2*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalHorizontalForkGap();
        invalidMoves.threeAndThree();
    }

    private void createDiagDiagFork(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,2,PieceColor.BLACK));
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(6,3,PieceColor.BLACK));
        this.black.addMove(new Piece(7,2,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagDiagFork() {
        /*number 3*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createDiagDiagFork();
        invalidMoves.threeAndThree();
    }

    private void createDiagDiagForkGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,2,PieceColor.BLACK));
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(8,3,PieceColor.BLACK));
        this.black.addMove(new Piece(9,2,PieceColor.BLACK));
        this.black.addMove(new Piece(6,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagDiagForkGap() {
        /*number 4*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createDiagDiagForkGap();
        invalidMoves.threeAndThree();
    }


    private void createDiagHorizontalFork(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,5,PieceColor.BLACK));
        this.black.addMove(new Piece(8,6,PieceColor.BLACK));
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(11,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,7,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagHorizontalFork() {
        /*number 5*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createDiagHorizontalFork();
        invalidMoves.threeAndThree();
    }

    private void createVerticalHorizontalMiddle(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(11,4,PieceColor.BLACK));
        this.black.addMove(new Piece(11,5,PieceColor.BLACK));
        this.black.addMove(new Piece(10,6,PieceColor.BLACK));
        this.black.addMove(new Piece(12,6,PieceColor.BLACK));
        this.black.addMove(new Piece(11,6,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalHorizontalMiddle() {
        /* l'ultima pedina inserita è quella centrale
        * numero 6 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalHorizontalMiddle();
        invalidMoves.threeAndThree();
    }

    private void createDiagDiagMiddle(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,6,PieceColor.BLACK));
        this.black.addMove(new Piece(9,6,PieceColor.BLACK));
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(8,7,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagDiagMiddle() {
        /* l'ultima pedina inserita è quella centrale
        * (ho le due diagonali e l'ultima inserita è quella centrale per entrambe
        * numero 7 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createDiagDiagMiddle();
        invalidMoves.threeAndThree();
    }

    private void createDiagHorizontalkGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
        this.black.addMove(new Piece(9,6,PieceColor.BLACK));
        this.black.addMove(new Piece(10,6,PieceColor.BLACK));
        this.black.addMove(new Piece(7,6,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagHorizontalGap() {
        /*numero 8 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createDiagHorizontalkGap();
        invalidMoves.threeAndThree();
    }


    private void createVerticalDiagonal(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(8,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,9,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiag() {
        /*numero 9 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalDiagonal();
        invalidMoves.threeAndThree();
    }

    private void createVerticalDiagonalGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(8,8,PieceColor.BLACK));
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(10,8,PieceColor.BLACK));
        this.black.addMove(new Piece(10,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiagGap() {
        /*numero 10 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalDiagonalGap();
        invalidMoves.threeAndThree();
    }

    private void createHorizontalDiagonalMiddle(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(7,9,PieceColor.BLACK));
        this.black.addMove(new Piece(9,9,PieceColor.BLACK));
        this.black.addMove(new Piece(9,10,PieceColor.BLACK));
        this.black.addMove(new Piece(8,9,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalDiagonalMiddle() {
        /*numero 11 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createHorizontalDiagonalMiddle();
        invalidMoves.threeAndThree();
    }


    private void createHorizontalDiagonalMiddleGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(7,10,PieceColor.BLACK));
        this.black.addMove(new Piece(10,10,PieceColor.BLACK));
        this.black.addMove(new Piece(10,11,PieceColor.BLACK));
        this.black.addMove(new Piece(9,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalDiagonalMiddleGap() {
        /*numero 12 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createHorizontalDiagonalMiddleGap();
        invalidMoves.threeAndThree();
    }

    private void createHorizontalVerticalMiddleGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(6,10,PieceColor.BLACK));
        this.black.addMove(new Piece(9,10,PieceColor.BLACK));
        this.black.addMove(new Piece(7,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalVerticallMiddleGap() {
        /*numero 13 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createHorizontalVerticalMiddleGap();
        invalidMoves.threeAndThree();
    }

    private void createVerticalDiagonalInvGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(7,12,PieceColor.BLACK));
        this.black.addMove(new Piece(7,13,PieceColor.BLACK));
        this.black.addMove(new Piece(7,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiagInvGap() {
        /*numero 14 quaderno*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        createVerticalDiagonalInvGap();
        invalidMoves.threeAndThree();
    }





//    @Test(expected = Test.None.class /* no exception expected */)
//    public void test_printLine() {
//        Printer.printLine("line");
//    }
//
//


}