package src.appPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;



/* 
 * Project Requirements:
 * Interface with drop down menu that has four items
 * First menu option prints date and time in a text box
 * second menu option same text box contents are written a text file named "log.txt"
 * third menu option changes frame background color to random hue of green, menu option dispalys the hue each time the option is hovered
 * fourth option the program is closed gracefully
 * 
 */



public class MainApp extends Application {

    private static Color randGreen;

    // APPLICATION CONSTRUCTOR

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menus in Java");
        // Vertically aligned box perfect for dropdown menu
        VBox root = new VBox();

        MenuBar menuBar = new MenuBar();
        MenuButton menuButton = new MenuButton("Options");

        // Create and layout text area for date and time

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setPrefSize(100, 100);
        VBox.setMargin(outputTextArea, new Insets(150));


        // create menu items to populate menu with and apply action events for selections

        MenuItem item1 = new MenuItem("Print Date and Time");
        item1.setOnAction(event -> {
            printDateTime(outputTextArea);
        });
        


        MenuItem item2 = new MenuItem("Write to log.txt");
        item2.setOnAction(event -> {
            writeToFile(outputTextArea);
        });
        
        MenuItem item3 = new MenuItem("Change Background Color");

        item3.setOnAction( event -> {
            root.setStyle("-fx-background-color: #" + getColor().toString().substring(2));

        });

        MenuItem item4 = new MenuItem("Exit");
        item4.setOnAction(event -> {
            System.out.println("Program exiting");
            primaryStage.close();
        });

        menuButton.getItems().addAll(item1, item2, item3, item4);
        menuBar.getMenus().add(new Menu("", menuButton));

        // Enter event set for opening options menu to call the random color change functionality everytime the menu is acccessed.

        menuButton.setOnMouseEntered(event -> {
            System.out.println("Mouse has entered the Options menu.");
            Color color = getRandomGreen();
            MainApp.setColor(color);
            item3.setStyle("-fx-background-color: #" + getColor().toString().substring(2));
        });


        //populate root with the menu children

        root.getChildren().addAll(menuBar, outputTextArea);

        Scene scene = new Scene(root, 480, 556);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // FUNCTION DEFINITIONS FOR APPLICATION

    // setColor accesses the static color variable beloning to MainApp so the randomColor hue can be stored and persists across action events
    public static void setColor(Color color) {
        randGreen = color;
    }

    // getColor returns the static value so that the hue persists across action events
    public static Color getColor() {
        if (randGreen == null) {
            randGreen = getRandomGreen();
        }
        return randGreen;
    }

    // printeDateTime accesses local system time and inputs the value into the text field belonging to the MainApp application

    private void printDateTime(TextArea outputTextArea) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        outputTextArea.setText(formattedDateTime);
        System.out.println("Printing date and time");
    }
    // writeToFile creates a new buffered writer, gets the output text and writes it a file, returning an error if input is invalid and automatically closing when done
    private void writeToFile(TextArea outputTextArea) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(outputTextArea.getText());
            writer.newLine();
            writer.flush();

            System.out.println("Writing to \"log.txt\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Color getRandomGreen() {
        Random random = new Random();
        Color randomColor = Color.rgb(0, random.nextInt(256), 0);
        return randomColor;
    }

    // PROGRAM EXECUTION

    public static void main(String[] args) {
        launch(args);
    }
}
