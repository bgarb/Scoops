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
public class IceCreamAnimation extends Transition {
    
    //private final Duration duration;
    private final ImageView imageView;
    
    
    private  int offsetY;
    private final int width;
    private final int height;
    private double screenHeight;

    private int lastIndex;

    public IceCreamAnimation(
            ImageView imageView, 
            Duration duration,double screenHeight, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.offsetY   = offsetY;
        this.screenHeight = 430;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }
    //int count = 0; 
   
    protected void interpolate(double v) {
  
          imageView.setY(v*screenHeight);
          
          if(v*screenHeight==400){
          imageView.setX(Math.random()*400);
          
      }
          
       
     ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty{
        


}
       
     /**if(screenHeight==430){
        imageView.setX(Math.random()*200);
      }**/
     
      //imageView.setY(v*screenHeight);
      //System.out.println(v*screenHeight); 
      
    }
}
