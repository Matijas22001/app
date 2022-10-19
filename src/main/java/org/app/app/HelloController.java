package org.app.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {
    @FXML private ImageView exitButton;

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}