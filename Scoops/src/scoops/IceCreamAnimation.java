/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
//import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
/**
 *
 * @author csstudent
 */
public class IceCreamAnimation extends Transition {
 
    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;

    private int lastIndex;

    public IceCreamAnimation(
            ImageView imageView, 
            Duration duration, 
            int count,   int columns,
            int offsetX, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate(double v) {
        final int index = Math.min((int) Math.floor(v * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % columns) * width;
            final int y = (index / columns) * height + offsetY;
            lastIndex = index;
        }
    }
}