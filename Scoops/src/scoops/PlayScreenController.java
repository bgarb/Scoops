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
<<<<<<< HEAD
import javafx.scene.shape.Circle;
=======
import javafx.animation.Animation;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
>>>>>>> 765c5490998eb4f0329f9f62f8ba4c8d24c4309e





/**
 *
 * @author csstudent
 */

/**
 * FXML Controller class
 *
 * @author csstudent
 */
<<<<<<< HEAD
public class PlayScreenController implements Initializable{
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
=======

public class PlayScreenController implements Initializable {
  
       
    Image IceCream = new Image("http://foodservice.bluebunny.com/content/cms/products/204x154/french_vanilla_3gal.s3v1.png");
   // public static final int COLUMNS  =   4;
    //public static final int COUNT    =  10;
   public static final int OFFSET_X =  50;
    public static  int OFFSET_Y =  50;
    public static final int WIDTH    = 204;
    public static final int HEIGHT   = 154;
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        
        
        ImageView imageView = new ImageView(IceCream);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        mainPane.getChildren().add(imageView);
       
        
       final Animation animation = new IceCreamAnimation(
                imageView,
                Duration.millis(1000),
                mainPane.getHeight(),
                 OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    
        
    
    }
    @FXML
    private AnchorPane mainPane;
    
    @FXML
>>>>>>> 765c5490998eb4f0329f9f62f8ba4c8d24c4309e
    private javafx.scene.control.Label label;
    private int conePosition;
     
    @FXML
    private ImageView cone;
    
    @FXML
    private void handleKeyPressed (KeyEvent event) {
        KeyCode key = event.getCode();
<<<<<<< HEAD
        conePosition = 0;
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        if (key == RIGHT) {
            conePosition++;
=======
        keyPressed = 0;
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (keyPressed == 0) {
                        keyPressed = now;
                    } else if (true){//now - keyPressed > 200) {
                        if (key == RIGHT) {                           
                            conePosition++;
                            keyPressed = now;
                        }else if (key == LEFT) {
                            conePosition--;
                            keyPressed = now;        
                        }

                        cone.setX(conePosition);
                    }
                }    
            }.start();       
    }

    private void handleKeyReleased(KeyEvent event) {
        KeyCode key = event.getCode();
       
        
    }
    int x = 0;
    int y = 0;
    public int getY(){
        if( x >= 0){
            conePosition += x;
            y = conePosition;
>>>>>>> 765c5490998eb4f0329f9f62f8ba4c8d24c4309e
        }
        else if (key == LEFT) {
            conePosition--;
        }
           
        cone.setX(conePosition);
        
<<<<<<< HEAD
    }
    
    
   
        @FXML
    
    private void quitButton() {
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
    
    private ImageView Onion; 
    
    private boolean caughtOnion(){
        if (Onion.getY() == cone.getY() && Onion.getX() == cone.getX()){
            Onion.setVisible(false);
            return true;
        }
        else {
            return false;
        }
    }

    private int lives = 3; 
    private final Circle Circle1 = new Circle();
    
    private void pointLost(){
        if(caughtOnion() == true){
            lives = lives - 1;
            Circle1.setStyle("-fx-opacity-0.3");
        }
            if(lives == 3){
            quitButton();
        }            
    

   
    }
}





