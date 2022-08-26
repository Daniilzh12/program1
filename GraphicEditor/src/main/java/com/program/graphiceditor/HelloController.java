package com.program.graphiceditor;

import com.program.graphiceditor.Drawing.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Canvas drawingArea;
    public Slider brushSize;
    public ColorPicker firstColor;
    public ColorPicker secondColor;
    public Pane container;
    public BorderPane drawer;
    Shape temp = new Pencil();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        container.widthProperty().addListener(e -> {drawingArea.setWidth(container.getWidth());
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0,drawingArea.getWidth(),drawingArea.getHeight());
        });
        container.heightProperty().addListener(e -> {drawingArea.setHeight(container.getHeight());
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0,drawingArea.getWidth(),drawingArea.getHeight());});
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,drawingArea.getWidth(),drawingArea.getHeight());
    }
    @FXML
    private void GradientFill()
    {
        temp = new Gradient();
    }
    @FXML
    private void Fill()
    {
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        gc.setFill(firstColor.getValue());
        gc.fillRect(0,0, drawingArea.getWidth(), drawingArea.getHeight());
    }
    @FXML
    private void PencilClick()
    {
        temp = new Pencil();
    }
    @FXML
    private void BrushClick()
    {
        temp = new Brush();
    }
    @FXML
    private void EraseClick()
    {
        temp = new Eraser();
    }
    @FXML
    private void PipetteClick()
    {
        temp = new Pipette();
    }
    @FXML
    private void setBackGroundImage()
    {
        temp = new Images();
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        temp.draw(gc);
        temp = new Pencil();
    }
    @FXML
    private void DrawAreaMousePressed(MouseEvent mouseEvent) {
        temp.setStartX(mouseEvent.getX());
        temp.setStartY(mouseEvent.getY());
        temp.setLineWidth((int) brushSize.getValue());

        temp.setX(mouseEvent.getX());
        temp.setY(mouseEvent.getY());
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        temp.pipetts(gc, firstColor, secondColor);
    }
    @FXML
    private void DrawAreaMouseDragged(MouseEvent mouseEvent) {
        temp.setColor(firstColor.getValue());
        temp.setX(mouseEvent.getX());
        temp.setY(mouseEvent.getY());

        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        temp.draw(gc);
    }
    @FXML
    private void DrawAreaMouseReleased(MouseEvent mouseEvent) {
        temp.setSecondColor(secondColor.getValue());
        temp.setEndX(mouseEvent.getX());
        temp.setEndY(mouseEvent.getY());

        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        temp.fill(gc);
        temp.draw(gc);
    }
    @FXML
    private void clearArea()
    {
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
    @FXML
    private void DrawAreaScroll(ScrollEvent scrollEvent) {
        if(scrollEvent.isControlDown()) {
            double x = drawingArea.getScaleX();
            double y = drawingArea.getScaleY();
            drawingArea.setScaleX(x + scrollEvent.getDeltaY() / 800);
            drawingArea.setScaleY(y + scrollEvent.getDeltaY() / 800);
        }
    }
}