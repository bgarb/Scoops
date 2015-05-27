/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.animation.Animation;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;





/**
 *
 * @author csstudent
 */
/**
 * FXML Controller class
 *
 * @author csstudent
 */

public class PlayScreenController implements Initializable {
  
       
    Image IceCream = new Image("http://40.media.tumblr.com/89c8768c2980e4301383e9dfebc6a3e4/tumblr_nopqe9zTje1uvakkzo1_100.png");
   // public static final int COLUMNS  =   4;
    //public static final int COUNT    =  10;
   public static final int OFFSET_X =  0;
    public static  int OFFSET_Y =  0;
    public static final int WIDTH    = 204;
    public static final int HEIGHT   = 174;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        
        
        ImageView imageView = new ImageView(IceCream);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        mainPane.getChildren().add(imageView);
       /** int scaledImageSizeW;
        
        scaledImageSizeW = (int) IceCream.getWidth()/2;
        
       int scaledImageSizeH;
        
        scaledImageSizeH = (int) IceCream.getHeight()/2;
         imageView.setScaleX(1/2);
         imageView.setScaleY(1/2);**/
         
         
       final Animation animation = new IceCreamAnimation(
                imageView,
                Duration.millis(1000),
                mainPane.getHeight(),
                 OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        //animation.setOnFinished(new EventHandler<ActionEvent>() {
       
       //public void handle(ActionEvent event){
           
       //imageView.setX(Math.random()*400);
       
       //}
               
    
    //});
        animation.play();
    
        
      
    }

    @FXML
    private javafx.scene.control.Label label;
    private int conePosition;
    private long keyPressed;

    @FXML
    private ImageView cone;
    
    @FXML
    private AnchorPane mainPane;

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        KeyCode key = event.getCode();
        conePosition = 0;
        keyPressed = 0;
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (keyPressed == 0) {
                    keyPressed = now;
                } else if (now - keyPressed > 200) {
                    if (key == RIGHT) {
                        conePosition++;
                        keyPressed = now;
                    } else if (key == LEFT) {
                        conePosition--;
                        keyPressed = now;
                    }

                    cone.setX(conePosition);
                }

            }
        }.start();
    }
    
    
   
        @FXML
    
    private void quitButton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("OfficialStartScreen.fxml"));
            Scene scene = new Scene(root);
            Scoops.mainWindow.setScene(scene);
            Scoops.mainWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

   
}
