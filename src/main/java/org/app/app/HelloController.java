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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class HelloController {
    @FXML private ImageView exitButton;
    @FXML private ImageView add_bar_btn;
    @FXML private ImageView add_hz_btn;
    @FXML private ImageView add_hit_btn;
    @FXML private ImageView sub_bar_btn;
    @FXML private ImageView sub_hz_btn;
    @FXML private ImageView sub_hit_btn;
    @FXML private ImageView iv_border_1;
    @FXML private ImageView iv_border_2;
    @FXML private ImageView iv_border_3;
    @FXML private ImageView iv_border_4;
    @FXML private ImageView iv_border_5;
    @FXML private ImageView iv_border_6;
    @FXML private TextField bar_tv;
    @FXML private TextField hz_tv;
    @FXML private TextField hit_tv;
    @FXML private TextField sum_hit_tv;
    @FXML
    private TextField time_tv;
    @FXML
    private ImageView size_icon;
    @FXML
    private ImageView size_text;
    @FXML
    private ImageView mode_icon;
    @FXML
    private TextField mode_text;
    @FXML
    private ImageView move_icon;
    @FXML
    private TextField move_text;
    private Timeline watcher_timeline;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private FXMLLoader loader;

    @FXML private ImageView go_to_switch_size;
    @FXML private ImageView go_to_switch_mode;
    @FXML private ImageView go_to_switch_move;

    private SizeChoice currentChoice = SizeChoice.size_15mm;
    private ModeChoice currentModeChoice = ModeChoice.continuous_mode;
    private MoveChoice currentMoveChoice = MoveChoice.linear_movement;
    private Double current_bar_value = 2.0;
    private Integer current_hz_value = 10;
    private Integer current_hit_value = 2000;
    @FXML
    private ImageView go_to_media_player_view;

    @FXML
    private void add_bar_value(){
        iv_border_1.setVisible(true);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_bar_value = Double.parseDouble(bar_tv.getText());
        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        if(current_bar_value<6){
            bar_tv.setText(String.valueOf(df.format(current_bar_value+0.1)));
        }
    }

    @FXML
    private void add_bar_value_sequence() {
        add_bar_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(true);
                iv_border_2.setVisible(false);
                iv_border_3.setVisible(false);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_bar_value = Double.parseDouble(bar_tv.getText());
                DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
                if(current_bar_value<6){
                    bar_tv.setText(String.valueOf(df.format(current_bar_value+0.1)));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }

    @FXML
    private void add_hz_value(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(true);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_hz_value = Integer.parseInt(hz_tv.getText());
        if(current_hz_value<20){
            hz_tv.setText(String.valueOf(current_hz_value+1));
        }
    }

    @FXML
    private void add_hz_value_sequence(){
        add_hz_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(false);
                iv_border_2.setVisible(true);
                iv_border_3.setVisible(false);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_hz_value = Integer.parseInt(hz_tv.getText());
                if(current_hz_value<20){
                    hz_tv.setText(String.valueOf(current_hz_value+1));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }

    @FXML
    private void add_hit_value(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(true);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_hit_value = Integer.parseInt(hit_tv.getText());
        if(current_hit_value<3000){
            hit_tv.setText(String.valueOf(current_hit_value+100));
            sum_hit_tv.setText(String.valueOf(current_hit_value+100));
        }
    }

    @FXML
    private void add_hit_value_sequence(){
        add_hit_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(false);
                iv_border_2.setVisible(false);
                iv_border_3.setVisible(true);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_hit_value = Integer.parseInt(hit_tv.getText());
                if(current_hit_value<3000){
                    hit_tv.setText(String.valueOf(current_hit_value+100));
                    sum_hit_tv.setText(String.valueOf(current_hit_value+100));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }

    @FXML
    private void sub_bar_value(){
        iv_border_1.setVisible(true);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_bar_value = Double.parseDouble(bar_tv.getText());
        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        if(current_bar_value>0){
            bar_tv.setText(String.valueOf(df.format(current_bar_value-0.1)));
        }
    }

    @FXML
    private void sub_bar_value_sequence() {
        sub_bar_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(true);
                iv_border_2.setVisible(false);
                iv_border_3.setVisible(false);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_bar_value = Double.parseDouble(bar_tv.getText());
                DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
                if(current_bar_value>0){
                    bar_tv.setText(String.valueOf(df.format(current_bar_value-0.1)));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }

    @FXML
    private void sub_hz_value(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(true);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_hz_value = Integer.parseInt(hz_tv.getText());
        if(current_hz_value>0){
            hz_tv.setText(String.valueOf(current_hz_value-1));
        }
    }

    @FXML
    private void sub_hz_value_sequence(){
        sub_hz_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(false);
                iv_border_2.setVisible(true);
                iv_border_3.setVisible(false);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_hz_value = Integer.parseInt(hz_tv.getText());
                if(current_hz_value>0){
                    hz_tv.setText(String.valueOf(current_hz_value-1));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }


    @FXML
    private void sub_hit_value(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(true);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        current_hit_value = Integer.parseInt(hit_tv.getText());
        if(current_hit_value>0){
            hit_tv.setText(String.valueOf(current_hit_value-100));
            sum_hit_tv.setText(String.valueOf(current_hit_value-100));
        }
    }

    @FXML
    private void sub_hit_value_sequence(){
        sub_hit_btn.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseEvent -> stopWatcher());
        if(watcher_timeline == null){
            watcher_timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                iv_border_1.setVisible(false);
                iv_border_2.setVisible(false);
                iv_border_3.setVisible(true);
                iv_border_4.setVisible(false);
                iv_border_5.setVisible(false);
                iv_border_6.setVisible(false);
                current_hit_value = Integer.parseInt(hit_tv.getText());
                if(current_hit_value>0){
                    hit_tv.setText(String.valueOf(current_hit_value-100));
                    sum_hit_tv.setText(String.valueOf(current_hit_value-100));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }

    public void changeViewStateOnReturn(Double bar_value, Integer hz_value, Integer hit_value, SizeChoice sizeChoice, ModeChoice modeChoice, MoveChoice moveChoice){
        current_bar_value = bar_value;
        current_hz_value = hz_value;
        current_hit_value = hit_value;
        currentChoice = sizeChoice;
        currentModeChoice = modeChoice;
        currentMoveChoice = moveChoice;
        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        bar_tv.setText(df.format(current_bar_value));
        hz_tv.setText(String.valueOf(current_hz_value));
        hit_tv.setText(String.valueOf(current_hit_value));
        sum_hit_tv.setText(String.valueOf(current_hit_value));
        switch (currentChoice){
            case size_20mm:
                size_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe2white.png"))));
                size_text.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/20 mm.png"))));
                break;
            case size_40mm:
                size_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe3white.png"))));
                size_text.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/40 mm.png"))));
                break;
            default:
                size_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/TRANSMITER.png"))));
                size_text.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/15 mm2.png"))));
                break;
        }
        switch (currentModeChoice){
            case burst_mode:
                mode_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/burst_white.png"))));
                mode_text.setText("Tryb burst");
                break;
            case dimmer_mode:
                mode_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dimmer_white.png"))));
                mode_text.setText("Tryb dimmer");
                break;
            case swing_mode:
                mode_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/swing_white.png"))));
                mode_text.setText("Tryb swing");
                break;
            default:
                mode_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/continous_white.png"))));
                mode_text.setText("Tryb ciągły");
                break;
        }
        if (currentMoveChoice == MoveChoice.spiral_movement) {
            move_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/spiral_white.png"))));
            move_text.setText("Ruch spiralny");
        } else {
            move_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/linear_white.png"))));
            move_text.setText("Ruch liniowy");
        }
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
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void stopWatcher(){
        if(watcher_timeline != null){
            watcher_timeline.stop();
            watcher_timeline = null;
        }
    }

    @FXML
    private void start_change_size_view() {
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(true);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(false);
        go_to_switch_size.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEvent -> {
            loader = new FXMLLoader(getClass().getResource("size_view.fxml"));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            try {
                root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            ChooserScenesController ctrl = loader.getController();
            ctrl.initClock();
            ctrl.initViewSize(currentChoice, currentModeChoice, currentMoveChoice, current_bar_value, current_hz_value, current_hit_value);
            stage.show();
        });
    }

    @FXML
    private void start_change_mode_view(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(true);
        iv_border_6.setVisible(false);
        go_to_switch_mode.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEvent -> {
            loader = new FXMLLoader(getClass().getResource("mode_view.fxml"));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            try {
                root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            ChooserScenesController ctrl = loader.getController();
            ctrl.initClock();
            ctrl.initViewMode(currentChoice, currentModeChoice, currentMoveChoice, current_bar_value, current_hz_value, current_hit_value);
            stage.show();
        });
    }

    @FXML
    private void start_change_move_view(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(false);
        iv_border_6.setVisible(true);
        go_to_switch_move.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEvent -> {
            loader = new FXMLLoader(getClass().getResource("move_view.fxml"));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            try {
                root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            ChooserScenesController ctrl = loader.getController();
            ctrl.initClock();
            ctrl.initViewMove(currentChoice, currentModeChoice, currentMoveChoice, current_bar_value, current_hz_value, current_hit_value);
            stage.show();
        });
    }

    @FXML
    private void start_media_player_view(){
        iv_border_1.setVisible(false);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        iv_border_4.setVisible(false);
        iv_border_5.setVisible(true);
        iv_border_6.setVisible(false);
        go_to_media_player_view.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEvent -> {
            loader = new FXMLLoader(getClass().getResource("media_player_view.fxml"));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            try {
                root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            MediaPlayerController ctrl = loader.getController();
            ctrl.initClock();
            //ctrl.start_playing_video();
            //ctrl.initViewMode(currentChoice, currentModeChoice, currentMoveChoice, current_bar_value, current_hz_value, current_hit_value);
            stage.show();
        });
    }


}