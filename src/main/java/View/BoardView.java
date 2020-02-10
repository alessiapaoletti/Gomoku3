package View;

import Model.Piece.PieceColor;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BoardView{
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";

    GridStructure gridStructure;
    private int boardSize;

    public BoardView(int inputSize, String gomokuType){
        String SINGLE_STAR = "*";
        this.boardSize = inputSize + 1;
        System.out.println(ANSI_PURPLE + SINGLE_STAR.repeat(36) + "  " + gomokuType.toUpperCase() + "  " +
                SINGLE_STAR.repeat(36) + ANSI_RESET);
        this.gridStructure = new GridStructure(this.boardSize);
    }

    public int getX(String PlayerColor){
        System.out.println("\n" + ANSI_PURPLE + "Insert new " + PlayerColor + " piece (x coordinate): " + ANSI_RESET);
        try {
           return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e){
            System.out.println(ANSI_RED + "Invalid coordinate " + ANSI_RESET + new String(Character.toChars(0x1F6AB)));
           return this.getX(PlayerColor);
        }
    }

    public int getY(String PlayerColor){
        System.out.println("\n" + ANSI_PURPLE + "Insert new " + PlayerColor + " piece (y coordinate): " + ANSI_RESET);
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e){
            System.out.println(ANSI_RED+"Invalid coordinate " + ANSI_RESET + new String(Character.toChars(0x1F6AB)));
            return this.getY(PlayerColor);
        }
    }

    public void setPiece(int x, int y,final PieceColor color){
        this.gridStructure.setPiece(x,y,color);
    }

    public void removePiece(int x ,int y){ this.gridStructure.removePiece(x,y);}

    public void createBoard(){

        System.out.println("\n");

        this.gridStructure.createHorizontalNumbers();
        IntStream.range(0, this.boardSize-1)
                .forEach(index -> {
                    this.gridStructure.createHorizontalLines(index);
                    this.gridStructure.createVerticalLines();
                });

        this.gridStructure.createHorizontalLines(this.boardSize-1);
    }

}
