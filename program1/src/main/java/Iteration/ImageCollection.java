package Iteration;

import com.pp.program1.Slide;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageCollection implements Aggregate, Serializable {
    private final ArrayList<Slide> Slides;
    transient private Image bi;

    public ImageCollection(ArrayList<Slide> slides) {
        Slides = slides;
    }
    public void addSlide(Slide slide)
    {
        Slides.add(slide);
    }

    public ArrayList<Slide> getSlides() {
        return Slides;
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator(Slides);
    }
}