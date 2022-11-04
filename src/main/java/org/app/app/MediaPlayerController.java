package org.app.app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


public class MediaPlayerController {
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

    private static final String MEDIA_URL = "/videos/Video1.mp4";


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

    @FXML
    public void start_playing_video(){
        Media media = new Media(getClass().getResource("/videos/Video1conv.mp4").toExternalForm());
        MediaPlayer mediaPlayer = null;
        try{
            mediaPlayer = new MediaPlayer(media);
        }catch(Exception e){
            e.printStackTrace();
        }
        mediaPlayer.setAutoPlay(true);
        media_view.setMediaPlayer(mediaPlayer);
    }
}
