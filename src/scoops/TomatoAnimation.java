/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
/**
 *
 * @author csstudent
 */
public class TomatoAnimation extends Transition {
    
    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetY;
    private final int width;
    private final int height;

    private int lastIndex;

    public TomatoAnimation(
        ImageView imageView, 
        Duration duration, 
        int count,   int columns,
        int offsetX, int offsetY,
        int width,   int height) {
        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height; 
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }


    @Override
    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final int y = (index / columns) * height + offsetY;
            imageView.setY(height);
           lastIndex = index;
        }
    }
}

