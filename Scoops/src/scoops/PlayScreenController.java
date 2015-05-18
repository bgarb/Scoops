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
import javafx.scene.shape.Circle;





/**
 *
 * @author csstudent
 */

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class PlayScreenController implements Initializable{
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private javafx.scene.control.Label label;
    private int conePosition;
     
    @FXML
    private ImageView cone;
    
    @FXML
    private void handleKeyPressed (KeyEvent event) {
        KeyCode key = event.getCode();
        conePosition = 0;
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        if (key == RIGHT) {
            conePosition++;
        }
        else if (key == LEFT) {
            conePosition--;
        }
           
        cone.setX(conePosition);
        
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
    
    private boolean caughtOnion(){
        return true; 
    }
    
    private int lives = 3; 
    private Circle Circle1 = new Circle();
    
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
