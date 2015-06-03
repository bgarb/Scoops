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
    public static final int OFFSET_X =  0;
    public static  int OFFSET_Y =  0;
    public static final int WIDTH    = 204;
    public static final int HEIGHT   = 174;
    
    private static final int KEYBOARD_MOVEMENT = 10;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }
    @FXML
    private ImageView cone;
    
    private Scene scene;
    
    @FXML
    private AnchorPane mainPane;
        
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
            root = FXMLLoader.load(getClass().getResource("OfficialStartScreen.fxml"));
            Scene scene = new Scene(root);
            Scoops.mainWindow.setScene(scene);
            Scoops.mainWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
