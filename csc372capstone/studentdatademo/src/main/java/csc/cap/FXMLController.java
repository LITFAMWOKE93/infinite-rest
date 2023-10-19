package csc.cap;
/*
Put header here


 */

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;



import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;



public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField gradeField;
    @FXML
    private TextField studentAddressField;
    @FXML
    private LinkedList<Student> studentList = new LinkedList<>();
    @FXML
    private Button submitButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button sortButton;
    @FXML
    private ScrollPane displayPane;

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Init enter key assignment to simulate mouse click for submitButton

        studentNameField.setOnKeyPressed(this::handleEnterKeyPress);
        studentAddressField.setOnKeyPressed(this::handleEnterKeyPress);
        gradeField.setOnKeyPressed(this::handleEnterKeyPress);


        // Regex pattern for allowing only alpha characters into the ftext fields.
        Pattern pattern = Pattern.compile("[a-zA-Z ]*");
        Pattern gpaPattern = Pattern.compile("^([0-4](\\.\\d{0,2})?)?$");


        // A unary operator filters the input and rejects non-matches and gives a null input

        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                return change;
            } else {
                return null;
            }
        };
        // A unary operator filter for GPA pattern.
        UnaryOperator<TextFormatter.Change> gpaFilter = change -> {
            String newText = change.getControlNewText();
            if (gpaPattern.matcher(newText).matches()) {
                return change;
            } else {
                return null; 
            }
        };

        // Action event assignments for buttons

        resetButton.setOnAction(event -> clearTextFields());
        submitButton.setOnAction(event -> createStudentFromInput());
        sortButton.setOnAction(event -> sortAscending());


        // String formatter filters for Regex
        TextFormatter<String> gpaTextFormatter = new TextFormatter<>(gpaFilter);
        TextFormatter<String> textFormatterLetterOnly = new TextFormatter<>(filter);
        studentNameField.setTextFormatter(textFormatterLetterOnly);
        gradeField.setTextFormatter(gpaTextFormatter);
        
        

        // Inline function toggles the disable feature of the submit button based on boolean expression binding.
        submitButton.disableProperty().bind(Bindings.createBooleanBinding(() -> !allInputsFilled(), 
        studentNameField.textProperty(), studentAddressField.textProperty(), gradeField.textProperty()));
    }

    @FXML
    private void handleEnterKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Simulate a button click event when Enter key is pressed
            submitButton.fire();
        }
    }

    
// Return the true/false content of the inputFields
    private boolean allInputsFilled() {

        return !(studentAddressField.getText().isEmpty() || studentNameField.getText().isEmpty()  || gradeField.getText().isEmpty()) ;
    }

    private void sortAscending() {
        studentList.sort(new NameCompare());

        updateScrollPaneContent();
    }
// clearTextFields is a list of TextFields that will be emptied when clicking resetButton
    private void clearTextFields() {

        studentNameField.clear();
        studentAddressField.clear();
        gradeField.clear();
    }

// Create a new student object from the input data and insert it into the linkedList structure

    @FXML
    private void createStudentFromInput() {
        String name = studentNameField.getText();
        String address = studentAddressField.getText();
        String stringGPA = gradeField.getText();

        System.out.println(name);
        System.out.println(address);
        System.out.println(stringGPA);


        double grade = Double.parseDouble(stringGPA);

        Student newStudent = new Student(name, address, grade);

        // Add student to linked list structure

        studentList.add(newStudent);

        updateScrollPaneContent();

        clearTextFields();
        studentNameField.requestFocus();
        System.out.printf("Student Created", newStudent.toString());
    }

    private void updateScrollPaneContent() {
        // vbox organizes the content vertically for the ScrollPane
        VBox content = new VBox(); 

        // Enhanced loop through linkedList and create labels for each

        for(Student student : studentList ) {
            Label studentLabel = new Label(student.toString());
            content.getChildren().add(studentLabel);
        }

        displayPane.setContent(content);

    }


    
    @FXML
    private void btnClickAction(ActionEvent event) {
        lblOut.setText("Hello World!");
    }

    @FXML
    private void btnSubmitNameAction(ActionEvent event) {
        lblOut.setText("Submitting Name");
    }

    @FXML
    private void btnSubmitToField(ActionEvent event) {
        System.out.println("Submitting data to field");

    }

   

         
    @FXML
    public void toggleSubmitDisable(boolean disabled) {
        if (submitButton != null ) {
            submitButton.setDisable(disabled);
        }
    }

    
   
}
