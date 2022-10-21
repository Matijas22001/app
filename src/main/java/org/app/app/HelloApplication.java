package org.app.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.addEventFilter(TouchEvent.ANY, System.out::println);
        scene.addEventFilter(MouseEvent.ANY, System.out::println);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        HelloController ctrl = fxmlLoader.getController();
        ctrl.initClock();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}