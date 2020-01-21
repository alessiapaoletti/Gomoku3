package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;

public class PieceView extends Group {

    private int color;		// the player that this piece belongs to
    private Ellipse ellipse;	// ellipse representing the player's piece
    private int x;          // x position
    private int y;          // y position

    private RadialGradient WHITE_COLOR = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.WHITE), new Stop(1, Color.GREY));
    private RadialGradient BLACK_COLOR = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.DARKSLATEGREY), new Stop(1, Color.BLACK));


    public PieceView() {
        //this.color = color;
        this.ellipse = new Ellipse();
        this.getChildren().add(this.ellipse);
        this.setPiece(0);
    }

    // overridden version of the resize method to give the piece the correct size
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.ellipse.setCenterX(width / 2.0);
        this.ellipse.setCenterY(height / 2.0);
        this.ellipse.setRadiusX(width / 2.0);
        this.ellipse.setRadiusY(height / 2.0);
    }


    // method that will set the piece type
    void setPiece(final int type) {
        this.color = type;
        if (this.color == 0)
            this.ellipse.setFill(Color.TRANSPARENT);
        else
            this.ellipse.setFill(this.color == 2 ? this.WHITE_COLOR : this.BLACK_COLOR);
    }

    //method that will allow to remove the piece
    void removePiece() {
        this.ellipse.setFill(Color.TRANSPARENT);
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }


//    // returns the type of this piece
//    int getColor() {
//        return (this.color);
//    }
//
//    int getX() {
//        return (this.x);
//    }
//
//    int getY() {
//        return (this.y);
//    }

}
