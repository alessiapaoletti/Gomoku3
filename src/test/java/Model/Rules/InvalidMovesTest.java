package Model.Rules;

import Model.Piece.*;
import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvalidMovesTest {

    private BlackPlayer black = new BlackPlayer("mario");
    private WhitePlayer white = new WhitePlayer("mario");

    private int gridDim = 18;
    private InvalidMoves invalidMoves = new InvalidMoves();

    @Test
    public void initialization(){
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        assertEquals(black.getColor(),PieceColor.BLACK);
        assertEquals(white.getColor(),PieceColor.WHITE);
    }

    private void horizontalVertical(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,5,PieceColor.BLACK));
        this.black.addMove(new Piece(4,5,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
        this.black.addMove(new Piece(5,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalVerticalTest() {
        /*number 1*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalVertical();
        invalidMoves.threeAndThree();
    }

//    private void createVerticalHorizontalForkWhite(){
//        this.black.getMoves().clear();
//        this.black.addMove(new Piece(12,11,PieceColor.BLACK));
//        this.white.addMove(new Piece(3,5,PieceColor.WHITE));
//        this.white.addMove(new Piece(4,5,PieceColor.WHITE));
//        this.white.addMove(new Piece(5,4,PieceColor.WHITE));
//        this.white.addMove(new Piece(5,3,PieceColor.WHITE));
//        this.white.addMove(new Piece(5,5,PieceColor.WHITE));
//    }
//
//    @Test(expected = Test.None.class)
//    public void verticalHorizontalForkWhite() {
//        /*no error expected -> invalid moves only for the black player*/
//        invalidMoves.setPlayers(black, white);
//        invalidMoves.setDimBoard(gridDim);
//        createVerticalHorizontalForkWhite();
//        invalidMoves.threeAndThree();
//    }

    private void horizontalVerticalGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(2,5,PieceColor.BLACK));
        this.black.addMove(new Piece(3,5,PieceColor.BLACK));
        this.black.addMove(new Piece(5,2,PieceColor.BLACK));
        this.black.addMove(new Piece(5,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalVerticalGapTest() {
        /*number 2*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalVerticalGap();
        invalidMoves.threeAndThree();
    }

    private void diagonalOneDiagonalTwo(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,2,PieceColor.BLACK));
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(6,3,PieceColor.BLACK));
        this.black.addMove(new Piece(7,2,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagonalOneDiagonalTwoTest() {
        /*number 3*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        diagonalOneDiagonalTwo();
        invalidMoves.threeAndThree();
    }

    private void diagonalOneDiagonalTwoGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(3,2,PieceColor.BLACK));
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(8,3,PieceColor.BLACK));
        this.black.addMove(new Piece(9,2,PieceColor.BLACK));
        this.black.addMove(new Piece(6,5,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagonalOneDiagonalTwoGapTest() {
        /*number 4*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        diagonalOneDiagonalTwoGap();
        invalidMoves.threeAndThree();
    }


    private void horizontalDiagonal(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,5,PieceColor.BLACK));
        this.black.addMove(new Piece(8,6,PieceColor.BLACK));
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(11,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,7,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalDiagonalTest() {
        /*number 5*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalDiagonal();
        invalidMoves.threeAndThree();
    }

    private void horizontalVerticalMiddle(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(11,4,PieceColor.BLACK));
        this.black.addMove(new Piece(11,5,PieceColor.BLACK));
        this.black.addMove(new Piece(10,6,PieceColor.BLACK));
        this.black.addMove(new Piece(12,6,PieceColor.BLACK));
        this.black.addMove(new Piece(11,6,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalVerticalMiddleTest() {
        /* numero 6 */
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalVerticalMiddle();
        invalidMoves.threeAndThree();
    }

    private void diagonalOneDiagonalTwoMiddle(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,6,PieceColor.BLACK));
        this.black.addMove(new Piece(9,6,PieceColor.BLACK));
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(8,7,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void diagonalOneDiagonalTwoMiddleTest() {
        /* numero 7 */
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        diagonalOneDiagonalTwoMiddle();
        invalidMoves.threeAndThree();
    }

    private void horizontalDiagonalGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(4,3,PieceColor.BLACK));
        this.black.addMove(new Piece(5,4,PieceColor.BLACK));
        this.black.addMove(new Piece(9,6,PieceColor.BLACK));
        this.black.addMove(new Piece(10,6,PieceColor.BLACK));
        this.black.addMove(new Piece(7,6,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalDiagonalGapTest() {
        /*numero 8*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalDiagonalGap();
        invalidMoves.threeAndThree();
    }


    private void verticalDiagonal(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(8,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(9,9,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiagonalTest() {
        /*numero 9*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        verticalDiagonal();
        invalidMoves.threeAndThree();
    }

    private void verticalDiagonalGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(8,8,PieceColor.BLACK));
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(10,8,PieceColor.BLACK));
        this.black.addMove(new Piece(10,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiagonalGapTest() {
        /*numero 10*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        verticalDiagonalGap();
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
        /*numero 11*/
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

    private void horizontalVerticalMiddleGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(7,7,PieceColor.BLACK));
        this.black.addMove(new Piece(7,8,PieceColor.BLACK));
        this.black.addMove(new Piece(6,10,PieceColor.BLACK));
        this.black.addMove(new Piece(9,10,PieceColor.BLACK));
        this.black.addMove(new Piece(7,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void horizontalVerticallMiddleGapTest() {
        /*numero 13 */
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        horizontalVerticalMiddleGap();
        invalidMoves.threeAndThree();
    }

    private void verticalDiagonalOneGap(){
        this.black.getMoves().clear();
        this.black.addMove(new Piece(10,7,PieceColor.BLACK));
        this.black.addMove(new Piece(9,8,PieceColor.BLACK));
        this.black.addMove(new Piece(7,12,PieceColor.BLACK));
        this.black.addMove(new Piece(7,13,PieceColor.BLACK));
        this.black.addMove(new Piece(7,10,PieceColor.BLACK));
    }

    @Test(expected = java.lang.Error.class)
    public void verticalDiagonalOneGapTest() {
        /*numero 14*/
        invalidMoves.setPlayers(black, white);
        invalidMoves.setDimBoard(gridDim);
        verticalDiagonalOneGap();
        invalidMoves.threeAndThree();
    }

}