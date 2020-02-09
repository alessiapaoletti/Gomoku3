package ViewJF;

import Model.Piece.PieceColor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;

public class PieceView extends Group {

    private PieceColor color;
    private Ellipse ellipse;
    private int x;
    private int y;

    private RadialGradient whiteColor = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.WHITE), new Stop(1, Color.GREY));
    private RadialGradient blackColor = new RadialGradient(0.5, 0.5, 0, 0, 1.5, true, CycleMethod.REFLECT, new Stop(0, Color.DARKSLATEGREY), new Stop(1, Color.BLACK));

    PieceView(int x, int y) {
        this.ellipse = new Ellipse();
        this.getChildren().add(this.ellipse);
        this.setPiece(PieceColor.EMPTY);
        this.x = x;
        this.y = y;
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.ellipse.setCenterX(width / 2.0);
        this.ellipse.setCenterY(height / 2.0);
        this.ellipse.setRadiusX(width / 2.0);
        this.ellipse.setRadiusY(height / 2.0);
    }

    void setPiece(final PieceColor type) {
        this.color = type;
        if (this.color == PieceColor.EMPTY)
            this.ellipse.setFill(Color.TRANSPARENT);
        else
            this.ellipse.setFill(this.color == PieceColor.WHITE ? this.whiteColor : this.blackColor);
    }

    void removePiece() {
        this.ellipse.setFill(Color.TRANSPARENT);
    }

}
