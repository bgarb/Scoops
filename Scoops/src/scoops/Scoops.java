package scoops;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author csstudent
 */
public class Scoops extends Application {
    
    static Stage mainWindow;
    private static final Image IceCream = new Image("http://foodservice.bluebunny.com/content/cms/products/204x154/french_vanilla_3gal.s3v1.png");
    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  5;
    private static final int WIDTH    = 204;
    private static final int HEIGHT   = 154;
    
    @Override
    public void start(Stage stage) throws Exception {
        mainWindow = stage;
        Parent root = FXMLLoader.load(getClass().getResource("OfficalStartScreen.fxml"));
        
        final ImageView imageView = new ImageView(IceCream);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        final Animation animation = new IceCreamAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    
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
    

   /* 
    private ImageView iceCream1;
    public void collisionDectection(){
        int retval = Double.compare(iceCream1.yProperty(), 101);
        if(retval < 0){
           iceCream1.setValue(visible) = false; 
        }
    }                  


}

