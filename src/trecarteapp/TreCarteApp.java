
package trecarteapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TreCarteApp extends Application {

    public static void main(String[] args) {
        
        launch(args);
        
    }

    @Override
    public void start(Stage s) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }
    
}
