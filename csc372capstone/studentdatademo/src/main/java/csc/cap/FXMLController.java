package csc.cap;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    @FXML
    private TextField inputField;
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
