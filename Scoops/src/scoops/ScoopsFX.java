/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ScoopsFX extends Application {  
    
    private static final Image iceCream = new Image("http://www.bluebunny.com/content/cms/products/204x154/French_Vanilla_3gal.s3v1.png"); 

    private final int count = 0;
    private final int columns = 0;
    private final int offsetY = 0;
    private final int width = 0;
    private final int height = 0;
    
    public static void main(String[] args){
        launch(args);
    }

    
   public void start(Stage primaryStage) throws Exception {
       
        final Animation animation = new IceCreamAnimation(
                
                Duration.millis(1000),
                COUNT, COLUMNS, 
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
                
                
                );
        

    }
}
