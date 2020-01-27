package View;

import Model.Piece;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;

public class PieceView extends Group {

    private Piece.PieceType color;
    private Ellipse ellipse;
    private int x;
    private int y;

    private RadialGradient WHITE_COLOR = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.WHITE), new Stop(1, Color.GREY));
    private RadialGradient BLACK_COLOR = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.DARKSLATEGREY), new Stop(1, Color.BLACK));

    PieceView() {
        this.ellipse = new Ellipse();
        this.getChildren().add(this.ellipse);
        this.setPiece(Piece.PieceType.EMPTY);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.ellipse.setCenterX(width / 2.0);
        this.ellipse.setCenterY(height / 2.0);
        this.ellipse.setRadiusX(width / 2.0);
        this.ellipse.setRadiusY(height / 2.0);
    }

    void setPiece(final Piece.PieceType type) {
        this.color = type;
        if (this.color == Piece.PieceType.EMPTY)
            this.ellipse.setFill(Color.TRANSPARENT);
        else
            this.ellipse.setFill(this.color == Piece.PieceType.WHITE ? this.WHITE_COLOR : this.BLACK_COLOR);
    }

    void removePiece() {
        this.ellipse.setFill(Color.TRANSPARENT);
    }

    void setX(final int x) {
        this.x = x;
    }

    void setY(final int y) {
        this.y = y;
    }

}
