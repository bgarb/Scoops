package scoops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class StartscreenController implements Initializable {
    @FXML 
    private Label label;
    
    @FXML
    private void handleButtonAction (ActionEvent event){
        Parent root;
        try{
            root= FXMLLoader.load(getClass().getResourse("OfficalPlayScreen.fxml"));
            Scene scene = new Scene(root);
            
        }
    
    
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
