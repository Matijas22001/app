package org.app.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        scene.addEventFilter(ScrollEvent.ANY, e -> System.out.println(e.getEventType()));
        stage.setScene(scene);
        HelloController ctrl = fxmlLoader.getController();
        ctrl.initClock();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}