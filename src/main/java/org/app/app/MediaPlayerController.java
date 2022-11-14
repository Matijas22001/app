package org.app.app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;


public class MediaPlayerController implements Initializable {
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;
    private Parent root;
    @FXML
    private ImageView accept_button;
    @FXML
    private MediaView media_view;
    @FXML
    private TextField time_tv;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button restartButton;

    private MediaPlayer mediaPlayer;
    private Media media;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        try{
            media = new Media(getClass().getResource("/videos/Video1.mp4").toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            media_view.setMediaPlayer(mediaPlayer);
            if(mediaPlayer.statusProperty() != null) System.out.println("Status: "+mediaPlayer.statusProperty().toString());
            if(mediaPlayer.getError() != null) System.out.println("Err: "+mediaPlayer.getError().toString());
            if(mediaPlayer.errorProperty() != null) System.out.println("Err0: "+mediaPlayer.errorProperty().toString());
            if(mediaPlayer.statusProperty() != null) System.out.println("Status: "+mediaPlayer.statusProperty().toString());
            if(media.getSource() != null) System.out.println("Source: "+media.getSource().toString());
            if(media.durationProperty() != null) System.out.println("Dur1: "+media.durationProperty().toString());
            if(media.errorProperty()!= null) System.out.println("Err1: "+media.errorProperty().toString());
            if(media.getError() != null) System.out.println("Err2: "+media.getError().toString());
            if(media.getDuration()!= null) System.out.println("Dur2: "+media.getDuration().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void play_media_player(){
        mediaPlayer.play();
    }
    @FXML
    private void play_stop_player(){
        mediaPlayer.pause();
    }
    @FXML
    private void play_restart_player(){
        mediaPlayer.stop();
    }
    public void switch_to_main_scene(){
        accept_button.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEvent -> {
            loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            try {
                root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            HelloController ctrl = loader.getController();
            ctrl.initClock();
            stage.show();
        });
    }

    @FXML
    public void initClock(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time_tv.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
        ),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
