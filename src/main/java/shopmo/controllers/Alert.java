package shopmo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Alert implements Initializable {

    @FXML
    private Button okBtn;
    @FXML
    private Label message;


    public Label getMessage() {
        return message;
    }

    @FXML
    private void handleButton() {
        okBtn.setOnAction(event -> {
            Stage stage = (Stage)okBtn.getScene().getWindow();
            stage.close();
        });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
