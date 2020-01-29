package View;

import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;

public class GridStructure {

    Line[] horizontal;
    Line[] vertical;
    private Translate[] horizontalTranslate;
    private Translate[] verticalTranslate;
    private double cellWidth;
    private double cellHeight;
    private double startX;
    private double startY;
    private int size;

    public GridStructure(int size){
        this.size = size;
        this.horizontal = new Line[this.size + 1];
        this.vertical = new Line[this.size + 1];
        this.horizontalTranslate = new Translate[this.size + 1];
        this.verticalTranslate = new Translate[this.size + 1];
    }

    private void createHorizontalLines(){
        for (int i = 0; i < this.size; ++i) {
            this.horizontal[i] = new Line();
            this.horizontal[i].setStartX(0);
            this.horizontal[i].setStartY(0);
            this.horizontal[i].setEndY(0);
            this.horizontalTranslate[i] = new Translate(0, 0);
            this.horizontal[i].getTransforms().add(this.horizontalTranslate[i]);
        }
    }

    private void createVerticalLines(){
        for (int i = 0; i < this.size; ++i) {
            this.vertical[i] = new Line();
            this.vertical[i].setStartX(0);
            this.vertical[i].setStartY(0);
            this.vertical[i].setEndX(0);
            this.verticalTranslate[i] = new Translate(0, 0);
            this.vertical[i].getTransforms().add(this.verticalTranslate[i]);
        }
    }


    void initializeLines(){
        this.createHorizontalLines();
        this.createVerticalLines();
    }

    void horizontalResizeRelocate(final double width) {
        for (int i = 0; i < this.size; ++i) {
            this.horizontal[i].setStartX(this.startX);
            this.horizontal[i].setEndX(this.startX + width);
            this.horizontalTranslate[i].setY(this.startY + this.cellHeight * i);
        }
    }

    void verticalResizeRelocate(final double height) {
        for (int i = 0; i < this.size; ++i) {
            this.vertical[i].setStartY(this.startY);
            this.vertical[i].setEndY(this.startY + height);
            this.verticalTranslate[i].setX(this.startX + this.cellWidth * i);
        }
    }


    void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }

    public double getCellWidth() {
        return cellWidth;
    }


    public double getCellHeight() {
        return cellHeight;
    }

    void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }

    public double getStartX() {
        return startX;
    }

    void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    void setStartY(double startY) {
        this.startY = startY;
    }



}
