/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;

import javafx.animation.Animation;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.geometry.Rectangle2D;




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
  
    Image tomato = new Image("https://40.media.tumblr.com/f015405bdad172dfa51a6055941cec6d/tumblr_npbyxjva7m1uwdbf1o1_100.png");  
    Image IceCream = new Image("http://40.media.tumblr.com/89c8768c2980e4301383e9dfebc6a3e4/tumblr_nopqe9zTje1uvakkzo1_100.png");
   // public static final int COLUMNS  =   4;
    //public static final int COUNT    =  10;
    public static final int OFFSET_X =  0;
    public static  int OFFSET_Y =  0;
    public static final int WIDTH    = 204;
    public static final int HEIGHT   = 174;
    ImageView imageView= new ImageView(IceCream);
    
    private static final int KEYBOARD_MOVEMENT = 10;
    
      
    @FXML
    private AnchorPane mainPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
         
        
       
        
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        mainPane.getChildren().add(imageView);
       /** int scaledImageSizeW;
        
        scaledImageSizeW = (int) IceCream.getWidth()/2;
        
       int scaledImageSizeH;
        
        scaledImageSizeH = (int) IceCream.getHeight()/2;
         imageView.setScaleX(1/2);
         imageView.setScaleY(1/2);**/
         
         
         
        IceCreamAnimation animation = new IceCreamAnimation(
                imageView,
                Duration.millis(1500),
                mainPane.getHeight(),
                 OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(1);

        animation.setOnFinished(new EventHandler<ActionEvent>() {
            
       @Override
       public void handle(ActionEvent event){
        imageView.setOpacity(0.0);
        int gen = (int) (Math.random()*100);
        if(gen <=80){
        imageView = new ImageView(IceCream);
        animation.setImageView(imageView);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        mainPane.getChildren().add(imageView);
        imageView.setX(Math.random()*400);
        
        animation.play();
        
        }else{
            
        imageView = new ImageView(tomato);
        animation.setImageView(imageView);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        mainPane.getChildren().add(imageView);
        imageView.setX(Math.random()*400);
        animation.play();
        
        
        }    
      
       
       }
               
    
    });
        animation.play();
         
        
    
    
    }
    
    ActionEvent stop = new ActionEvent(); 
    
    private boolean caughtTomato(ImageView cone){
        if(imageView.getImage() == tomato){
        double tomatox = imageView.getX();
        double tomatob = imageView.getY();
        double conex = cone.getY();
         double coneb = cone.getX();
            if (Math.abs(imageView.getY() - cone.getY()) <= 60 && Math.abs(imageView.getX() - cone.getX()) <= 70){
                imageView.setVisible(false);
                return true;
            }

        }
            return false;
        }

    private int lives = 3; 
    private final Circle Circle1 = new Circle();
    
    private void pointLost(){
        if(caughtTomato(cone) == true){
            lives = lives - 1;
            Circle1.setStyle("-fx-opacity-0.3");
        }
            if(lives == 3){
            quitButton(stop);
        }            
    

   
    } 


    @FXML
    private javafx.scene.control.Label label;
    private int conePosition;
    private long keyPressed;

    @FXML
    private ImageView cone;
    
    private Scene scene;
  
        
    /*ImageView imageView = new ImageView(IceCream);
    
    imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
    mainPane.getChildren().add(imageView);
         
    final Animation animation = new IceCreamAnimation(
        imageView,
        Duration.millis(1500),
        mainPane.getHeight(),
        OFFSET_Y,
        WIDTH, HEIGHT
    );
    animation.setCycleCount(1);
    animation.setOnFinished(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event){    
            imageView.setX(Math.random()*400);
            animation.play();
        }
    });
    animation.play();*/ 
    
    @FXML
     void setScene(Scene scene) {
        this.scene = scene;
    }
    
    @FXML
    private void moveConeOnKeyPress(KeyEvent event) {
        //playScreen = getPlayScreen();
        scene.setOnKeyPressed((KeyEvent keyEvent) -> {
            switch (keyEvent.getCode()) {
                case RIGHT: cone.setX(cone.getX() + KEYBOARD_MOVEMENT); break;
                case LEFT:  cone.setX(cone.getX() - KEYBOARD_MOVEMENT); break;
            }
        });
    }
    
    @FXML
    private void quitButton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("OfficalStartScreen.fxml"));
            Scene scene = new Scene(root);
            Scoops.mainWindow.setScene(scene);
            Scoops.mainWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
