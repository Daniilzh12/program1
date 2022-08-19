package com.pp.program1;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;

public class Slide implements Serializable {
    transient private BackgroundImage background;
    transient private Canvas graphics;
    private final ArrayList<Text> texts;

    public Slide(SlideBuilder slideBuilder)
    {
        background = slideBuilder.img;
        graphics = slideBuilder.graphics;
        texts = slideBuilder.texts;
    }

    public ArrayList<Text> getTexts()
    {
        return texts;
    }
    public void addText(Text text)
    {
        texts.add(text);
    }
    public void setTexts(ArrayList<Text> Texts)
    {
        texts.clear();
        texts.addAll(Texts);
    }
    public Canvas getGraphic()
    {
        return graphics;
    }
    public BackgroundImage getImage()
    {
        return background;
    }
    public void setImg(BackgroundImage img)
    {
        this.background = img;
    }
    public void setCanvas(Canvas canvas)
    {
        this.graphics = new Canvas(canvas.getWidth(),canvas.getHeight());
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = canvas.snapshot(params, null);
        graphics.getGraphicsContext2D().drawImage(image, 0, 0);
    }

    public static class SlideBuilder {
        private BackgroundImage img;
        private Canvas graphics;
        ArrayList<Text> texts;

        public SlideBuilder(Canvas canvas){
            img = null;
            graphics = new Canvas(canvas.getWidth(),canvas.getHeight());
            texts = new ArrayList<>();
        }

        public SlideBuilder setTexts(ArrayList<Text> texts)
        {
            this.texts.addAll(texts);
            return this;
        }

        public  SlideBuilder setCanvas(Canvas canvas) {
            this.graphics = new Canvas(canvas.getWidth(),canvas.getHeight());
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            WritableImage image = canvas.snapshot(params, null);
            graphics.getGraphicsContext2D().drawImage(image, 0, 0);
            return this;
        }
        public  SlideBuilder setImg(BackgroundImage image) {
            this.img = image;
            return this;
        }

        public Slide build() {
            return new Slide(this);
        }
    }

}

