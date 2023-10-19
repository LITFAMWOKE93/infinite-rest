package csc.cap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;


public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","Student Enrollment Manager");

        
        
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        Parent root = fxmlLoader.load();
       
        
        
    
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        stage.setTitle(title);
        stage.setScene(scene);


        // controller.toggleSubmitDisable(true);
        stage.show();
    }
   
    


    public static void main(String[] args) {

        launch(args);
    }


}
