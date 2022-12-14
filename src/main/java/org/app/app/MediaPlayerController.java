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
import java.util.Arrays;
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
            //getClass().getResource("/videos/Video1.mp4"
            File file = new File("/home/pi/CarePump/Video1.mp4");
            final String MEDIA_URL = file.toURI().toString();
            media = new Media(MEDIA_URL);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnError(() -> {
                System.out.println(mediaPlayer.getError().getMessage());
                System.out.println(Arrays.toString(mediaPlayer.getError().getStackTrace()));
                mediaPlayer.getError().printStackTrace();
                System.out.println(mediaPlayer.getError().getType());
            });
            System.out.println(media.getSource());
            mediaPlayer.setOnPlaying(() -> System.out.println("Playing: " + media.getSource()));
            media_view.setMediaPlayer(mediaPlayer);
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
