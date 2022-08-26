package com.program.graphiceditor.Drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Images extends Shape{
    @Override
    public void draw(GraphicsContext gr) {
        double imageWidth = 0, imageHeight = 0, percent;
        Stage s = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть изображение");
        File file = fileChooser.showOpenDialog(s);
        if(file != null) {
            Image imageGr = new Image("file:/" + file.getAbsolutePath());
            if(imageGr.getHeight() > imageGr.getWidth()) {
                percent = imageGr.getHeight()/gr.getCanvas().getHeight();
                imageWidth = imageGr.getWidth()/percent;
                imageHeight = gr.getCanvas().getHeight();
            }
            else {
                if(imageGr.getHeight() < imageGr.getWidth()) {
                    percent = imageGr.getWidth()/gr.getCanvas().getWidth();
                    imageWidth = gr.getCanvas().getWidth();
                    imageHeight = imageGr.getHeight()/percent;
                }
                else {
                    imageWidth = gr.getCanvas().getHeight();
                    imageHeight = gr.getCanvas().getHeight();
                }
            }
            gr.drawImage(imageGr, 0,0, imageWidth, imageHeight);
        }
    }

    @Override
    public void fill(GraphicsContext gr) {
    }

    @Override
    public void pipetts(GraphicsContext gr, ColorPicker colPick, ColorPicker colPick2) {

    }
}
