package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.WritableImage;

public class Pipette extends Shape{
    public ColorPicker colorPick;
    public ColorPicker SecondColPick;
    @Override
    public void draw(GraphicsContext gr) {
    }

    @Override
    public void fill(GraphicsContext gr) {
    }

    @Override
    public void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2) {
        WritableImage snap = gr.getCanvas().snapshot(null, null);
        this.colorPick = colPick;
        this.SecondColPick = colPick2;
        SecondColPick.setValue(colorPick.getValue());
        colorPick.setValue(snap.getPixelReader().getColor((int) x, (int) y));
    }
}
