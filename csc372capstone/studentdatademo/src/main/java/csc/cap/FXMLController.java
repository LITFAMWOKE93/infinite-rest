package csc.cap;
/*
Put header here


 */

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

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

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    @FXML
    private TextField inputField;
    @FXML
    private LinkedList<Student> linkedList = new LinkedList<>();
    @FXML
    private Button submitButton;

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up a binding for the submit button's disable property
        // Set up for any bindings to button properties
        

        // Example: Enable the submit button based on a certain condition
        // You can replace this with your actual condition logic
        submitButton.disableProperty().bind(Bindings.createBooleanBinding(() -> !allInputsFilled(), 
        inputField.textProperty()));
    }

    
// Return the true/false content of the inputFields
    private boolean allInputsFilled() {

        return !inputField.getText().isEmpty();
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
    private void btnClearFields(ActionEvent event) {
        clearInputFieldsRecursively(inputField.getScene().getRoot());
    }

    private void clearInputFieldsRecursively(Node node) {
            if (node instanceof TextField && "inputField".equals(node.getId())) {
                        ((TextField) node).clear();
        }
    
            if (node instanceof Parent) {
                for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                        clearInputFieldsRecursively(child);
        }
        }
    }      
    @FXML
    public void toggleSubmitDisable(boolean disabled) {
        if (submitButton != null ) {
            submitButton.setDisable(disabled);
        }
    }

    
   
}
