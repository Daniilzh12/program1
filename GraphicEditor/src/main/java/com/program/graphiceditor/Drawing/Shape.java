package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public abstract class Shape {
    Color color;
    Color secondColor;
    Integer lineWidth;
    double x;
    double y;
    double startX;
    double startY;
    double endX;

    public void setSecondColor(Color secondColor) {
        this.secondColor = secondColor;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    double endY;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract void draw(GraphicsContext gr);

    public abstract void fill(GraphicsContext gr);

    public abstract void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2);

    public Shape() {

    }
}
