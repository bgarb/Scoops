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
     * @param url
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
    private void handleKeyPressed(KeyEvent event) {
        KeyCode key = event.getCode();
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
        }
        return y;   
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
            Circle1.setStyle("-fx-opacity-0.21");
        }
            if(lives == 3){
            quitButton();
        }            
    

   
    }
}





