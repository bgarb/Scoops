/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoops;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author csstudent
 */
public class Scoops extends Application {
    static Stage mainWindow;
    
    @Override
    public void start(Stage stage) throws Exception {
        mainWindow = stage;
        Parent root = FXMLLoader.load(getClass().getResource("OfficalStartScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

   
    /* private ImageView iceCream1;
    public void collisionDectection(){
        int retval = Double.compare(iceCream1.gety(), 101);
        if(retval < 0){
           iceCream1.setVisible(false); 
        }
    }                  
*/

}

