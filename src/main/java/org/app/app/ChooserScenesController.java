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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ChooserScenesController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;
    private Parent root;
    @FXML
    private ImageView accept_button;
    @FXML
    private TextField time_tv;
    @FXML
    private ImageView active_15_mm;
    @FXML
    private ImageView active_20_mm;
    @FXML
    private ImageView active_40_mm;
    @FXML
    private ImageView icon_15_mm;
    @FXML
    private ImageView text_15_mm;
    @FXML
    private ImageView icon_20_mm;
    @FXML
    private ImageView text_20_mm;
    @FXML
    private ImageView icon_40_mm;
    @FXML
    private ImageView text_40_mm;
    @FXML
    private ImageView mode_continuous_active;
    @FXML
    private ImageView mode_burst_active;
    @FXML
    private ImageView mode_dimmer_active;
    @FXML
    private ImageView mode_swing_active;
    @FXML
    private ImageView continuous_icon;
    @FXML
    private ImageView burst_icon;
    @FXML
    private ImageView dimmer_icon;
    @FXML
    private ImageView swing_icon;
    @FXML
    private TextField continuous_text;
    @FXML
    private TextField burst_text;
    @FXML
    private TextField dimmer_text;
    @FXML
    private TextField swing_text;
    @FXML
    private ImageView linear_movement;
    @FXML
    private ImageView spiral_movement;
    @FXML
    private ImageView linear_icon;
    @FXML
    private ImageView spiral_icon;
    @FXML
    private TextField linear_text;
    @FXML
    private TextField spiral_text;
    private SizeChoice currentChoice = null;
    private ModeChoice currentModeChoice = null;
    private MoveChoice currentMoveChoice = null;
    private Double current_bar_value = null;
    private Integer current_hz_value = null;
    private Integer current_hit_value = null;

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
            ctrl.changeViewStateOnReturn(current_bar_value, current_hz_value, current_hit_value, currentChoice, currentModeChoice, currentMoveChoice);
            ctrl.initClock();
            stage.show();
        });


    }

    public void initViewSize(SizeChoice currentChoice, ModeChoice currentModeChoice, MoveChoice currentMoveChoice,
                             Double current_bar_value, Integer current_hz_value, Integer current_hit_value){
        this.currentChoice = currentChoice;
        this.currentModeChoice = currentModeChoice;
        this.currentMoveChoice = currentMoveChoice;
        this.current_bar_value = current_bar_value;
        this.current_hz_value = current_hz_value;
        this.current_hit_value = current_hit_value;
        switch (currentChoice){
            case size_20mm:
                activate_20_mm();
                break;
            case size_40mm:
                activate_40_mm();
                break;
            default:
                activate_15_mm();
                break;
        }

    }

    public void initViewMode(SizeChoice currentChoice, ModeChoice currentModeChoice, MoveChoice currentMoveChoice,
                             Double current_bar_value, Integer current_hz_value, Integer current_hit_value){
        this.currentChoice = currentChoice;
        this.currentModeChoice = currentModeChoice;
        this.currentMoveChoice = currentMoveChoice;
        this.current_bar_value = current_bar_value;
        this.current_hz_value = current_hz_value;
        this.current_hit_value = current_hit_value;
        switch (currentModeChoice){
            case burst_mode:
                activate_mode_burst();
                break;
            case dimmer_mode:
                activate_mode_dimmer();
                break;
            case swing_mode:
                activate_mode_swing();
                break;
            default:
                activate_mode_continuous();
                break;
        }

    }

    public void initViewMove(SizeChoice currentChoice, ModeChoice currentModeChoice, MoveChoice currentMoveChoice,
                             Double current_bar_value, Integer current_hz_value, Integer current_hit_value){
        this.currentChoice = currentChoice;
        this.currentModeChoice = currentModeChoice;
        this.currentMoveChoice = currentMoveChoice;
        this.current_bar_value = current_bar_value;
        this.current_hz_value = current_hz_value;
        this.current_hit_value = current_hit_value;
        switch (currentMoveChoice){
            case spiral_movement:
                activate_spiral_movement();
                break;
            default:
                activate_linear_movement();
                break;
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
    public void activate_15_mm(){
        active_15_mm.setVisible(true);
        active_20_mm.setVisible(false);
        active_40_mm.setVisible(false);
        currentChoice = SizeChoice.size_15mm;
        try{
            icon_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/TRANSMITERblack.png"))));
            text_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/15 mm15mmblack.png"))));
            icon_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe2white.png"))));
            text_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/20 mm.png"))));
            icon_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe3white.png"))));
            text_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/40 mm.png"))));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_20_mm(){
        active_15_mm.setVisible(false);
        active_20_mm.setVisible(true);
        active_40_mm.setVisible(false);
        currentChoice = SizeChoice.size_20mm;
        try{
            icon_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/TRANSMITER.png"))));
            text_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/15 mm2.png"))));
            icon_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe2black.png"))));
            text_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/20 mmblack.png"))));
            icon_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe3white.png"))));
            text_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/40 mm.png"))));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_40_mm(){
        active_15_mm.setVisible(false);
        active_20_mm.setVisible(false);
        active_40_mm.setVisible(true);
        currentChoice = SizeChoice.size_40mm;
        try{
            icon_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/TRANSMITER.png"))));
            text_15_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/15 mm2.png"))));
            icon_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frameframe2white.png"))));
            text_20_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/20 mm.png"))));
            icon_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Frame3black.png"))));
            text_40_mm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/40 mmblack.png"))));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_mode_continuous(){
        mode_continuous_active.setVisible(true);
        mode_burst_active.setVisible(false);
        mode_dimmer_active.setVisible(false);
        mode_swing_active.setVisible(false);
        currentModeChoice = ModeChoice.continuous_mode;
        try{
            continuous_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/continuous_black.png"))));
            continuous_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
            burst_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/burst_white.png"))));
            burst_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            dimmer_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dimmer_white.png"))));
            dimmer_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            swing_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/swing_white.png"))));
            swing_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_mode_burst(){
        mode_continuous_active.setVisible(false);
        mode_burst_active.setVisible(true);
        mode_dimmer_active.setVisible(false);
        mode_swing_active.setVisible(false);
        currentModeChoice = ModeChoice.burst_mode;
        try{
            continuous_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/continous_white.png"))));
            continuous_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            burst_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/burst_black.png"))));
            burst_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
            dimmer_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dimmer_white.png"))));
            dimmer_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            swing_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/swing_white.png"))));
            swing_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_mode_dimmer(){
        mode_continuous_active.setVisible(false);
        mode_burst_active.setVisible(false);
        mode_dimmer_active.setVisible(true);
        mode_swing_active.setVisible(false);
        currentModeChoice = ModeChoice.dimmer_mode;
        try{
            continuous_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/continous_white.png"))));
            continuous_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            burst_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/burst_white.png"))));
            burst_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            dimmer_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dimmer_black.png"))));
            dimmer_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
            swing_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/swing_white.png"))));
            swing_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_mode_swing(){
        mode_continuous_active.setVisible(false);
        mode_burst_active.setVisible(false);
        mode_dimmer_active.setVisible(false);
        mode_swing_active.setVisible(true);
        currentModeChoice = ModeChoice.swing_mode;
        try{
            continuous_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/continous_white.png"))));
            continuous_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            burst_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/burst_white.png"))));
            burst_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            dimmer_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/dimmer_white.png"))));
            dimmer_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            swing_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/swing_black.png"))));
            swing_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_linear_movement(){
        linear_movement.setVisible(true);
        spiral_movement.setVisible(false);
        currentMoveChoice = MoveChoice.linear_movement;
        try{
            linear_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/linear_black.png"))));
            linear_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
            spiral_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/spiral_white.png"))));
            spiral_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void activate_spiral_movement(){
        linear_movement.setVisible(false);
        spiral_movement.setVisible(true);
        currentMoveChoice = MoveChoice.spiral_movement;
        try{
            linear_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/linear_white.png"))));
            linear_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #FFFFFF;");
            spiral_icon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/spiral_black.png"))));
            spiral_text.setStyle("-fx-background-color: #00000000; -fx-text-inner-color: #121420;");
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
