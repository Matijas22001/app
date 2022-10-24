package org.app.app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    @FXML private TextField bar_tv;
    @FXML private TextField hz_tv;
    @FXML private TextField hit_tv;
    @FXML private TextField sum_hit_tv;
    @FXML
    private TextField time_tv;
    private Timeline watcher_timeline;

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
    private void add_bar_value(){
        iv_border_1.setVisible(true);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        double barValue = Double.parseDouble(bar_tv.getText());
        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        if(barValue<6){
            bar_tv.setText(String.valueOf(df.format(barValue+0.1)));
        }
    }

    @FXML
    private void stopWatcher(){
        if(watcher_timeline != null){
            watcher_timeline.stop();
            watcher_timeline = null;
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
                double barValue = Double.parseDouble(bar_tv.getText());
                DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
                if(barValue<6){
                    bar_tv.setText(String.valueOf(df.format(barValue+0.1)));
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
        int hzValue = Integer.parseInt(hz_tv.getText());
        if(hzValue<20){
            hz_tv.setText(String.valueOf(hzValue+1));
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
                int hzValue = Integer.parseInt(hz_tv.getText());
                if(hzValue<20){
                    hz_tv.setText(String.valueOf(hzValue+1));
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
        int hitValue = Integer.parseInt(hit_tv.getText());
        if(hitValue<3000){
            hit_tv.setText(String.valueOf(hitValue+100));
            sum_hit_tv.setText(String.valueOf(hitValue+100));
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
                int hitValue = Integer.parseInt(hit_tv.getText());
                if(hitValue<3000){
                    hit_tv.setText(String.valueOf(hitValue+100));
                    sum_hit_tv.setText(String.valueOf(hitValue+100));
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
        double barValue = Double.parseDouble(bar_tv.getText());
        DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
        if(barValue>0){
            bar_tv.setText(String.valueOf(df.format(barValue-0.1)));
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
                double barValue = Double.parseDouble(bar_tv.getText());
                DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
                if(barValue>0){
                    bar_tv.setText(String.valueOf(df.format(barValue-0.1)));
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
        int hzValue = Integer.parseInt(hz_tv.getText());
        if(hzValue>0){
            hz_tv.setText(String.valueOf(hzValue-1));
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
                int hzValue = Integer.parseInt(hz_tv.getText());
                if(hzValue>0){
                    hz_tv.setText(String.valueOf(hzValue-1));
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
        int hitValue = Integer.parseInt(hit_tv.getText());
        if(hitValue>0){
            hit_tv.setText(String.valueOf(hitValue-100));
            sum_hit_tv.setText(String.valueOf(hitValue-100));
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
                int hitValue = Integer.parseInt(hit_tv.getText());
                if(hitValue>0){
                    hit_tv.setText(String.valueOf(hitValue-100));
                    sum_hit_tv.setText(String.valueOf(hitValue-100));
                }
            })
            );
            watcher_timeline.setCycleCount(Timeline.INDEFINITE);
            watcher_timeline.play();
        }
    }
}