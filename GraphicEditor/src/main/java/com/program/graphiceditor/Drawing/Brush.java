package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Brush extends Shape{
    double w, h;
    @Override
    public void draw(GraphicsContext gr) {
        w = lineWidth;
        h = lineWidth;
        gr.setStroke(color);
        gr.setFill(color);
        gr.setLineWidth(1);
        gr.beginPath();

        gr.moveTo(w*0.5+x,y);
        gr.lineTo(w*0.38+x, h*0.38+y);
        gr.lineTo(0+x,h*0.38+y);
        gr.lineTo(w*0.32+x,h*0.62+y);
        gr.lineTo(w*0.2+x,h+y);
        gr.lineTo(w*0.5+x,h*0.75+y);
        gr.lineTo(w*0.8+x,h+y);
        gr.lineTo(w*0.68+x,h*0.62+y);
        gr.lineTo(w+x,h*0.38+y);
        gr.lineTo(w*0.62+x, h*0.38+y);
        gr.lineTo(w*0.5+x,y);

        gr.stroke();
        gr.fill();
        gr.closePath();
    }

    @Override
    public void fill(GraphicsContext gr) {

    }

    @Override
    public void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2) {

    }
}
