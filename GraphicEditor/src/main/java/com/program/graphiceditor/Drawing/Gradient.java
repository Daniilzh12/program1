package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Gradient extends Shape{
    @Override
    public void draw(GraphicsContext gr) {

    }

    @Override
    public void fill(GraphicsContext gr) {
        Stop[] stops = new Stop[] { new Stop(0, color), new Stop(1, secondColor)};
        LinearGradient lg = new LinearGradient(startX, startY, endX, endY, false, CycleMethod.NO_CYCLE, stops);
        gr.setFill(lg);
        gr.fillRect(0,0, gr.getCanvas().getWidth(), gr.getCanvas().getHeight());
    }

    @Override
    public void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2) {

    }
}
