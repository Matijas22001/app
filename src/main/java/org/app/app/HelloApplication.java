package org.app.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
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
        scene.addEventFilter(MouseEvent.ANY, e -> System.out.println(e.getEventType()));
        scene.addEventFilter(MouseDragEvent.ANY, e -> System.out.println(e.getEventType()));
        scene.addEventFilter(DragEvent.ANY, e -> System.out.println(e.getEventType()));
        stage.setScene(scene);
        HelloController ctrl = fxmlLoader.getController();
        ctrl.initClock();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}