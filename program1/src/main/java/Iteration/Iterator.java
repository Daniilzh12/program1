package Iteration;

import com.pp.program1.Slide;
import javafx.scene.canvas.Canvas;

public interface Iterator {
    boolean hasNext(int mode);
    Object next();
    Object moveForward(Canvas canvas);
    Object moveBackward(Canvas canvas);
    Object preview();
    boolean hasPrev(int mode);
    Object prev();
    int getCurrent();
    void addSlides(Slide slide);
    public Slide getCurrentSlide();
}