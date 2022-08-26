package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class Eraser extends Shape{
    @Override
    public void draw(GraphicsContext gr) {
        gr.setStroke(Color.WHITE);
        gr.setLineWidth(lineWidth);
        gr.strokeOval(x,y,1,1);
    }

    @Override
    public void fill(GraphicsContext gr) {
    }

    @Override
    public void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2) {

    }
}
