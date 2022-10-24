package org.app.app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
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
    @FXML private AnchorPane bar_scroll_ap;
    @FXML private AnchorPane hz_scroll_ap;
    @FXML private AnchorPane hit_scroll_ap;
    @FXML private ImageView iv_border_1;
    @FXML private ImageView iv_border_2;
    @FXML private ImageView iv_border_3;
    @FXML private TextField bar_tv;
    @FXML private TextField hz_tv;
    @FXML private TextField hit_tv;
    @FXML private TextField sum_hit_tv;
    @FXML
    private TextField time_tv;

    private boolean isIncrementingBarRunning = false;
    private boolean isDecrementingBarRunning = false;

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
    private void set_increment_status_true(){
        isIncrementingBarRunning = true;
    }

    @FXML
    private void set_decrement_status_true(){
        isDecrementingBarRunning = true;
    }

    @FXML
    private void set_increment_status_false(){
        isIncrementingBarRunning = false;
    }

    @FXML
    private void set_decrement_status_false(){
        isDecrementingBarRunning = false;
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
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(true);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(false);
            double barValue = Double.parseDouble(bar_tv.getText());
            DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
            if(barValue<6){
                bar_tv.setText(String.valueOf(df.format(barValue+0.1)));
            }
        //}
    }

    @FXML
    private void add_bar_value_sequence() throws InterruptedException {
        while(isIncrementingBarRunning){
            iv_border_1.setVisible(true);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(false);
            double barValue = Double.parseDouble(bar_tv.getText());
            DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
            if(barValue<6){
                bar_tv.setText(String.valueOf(df.format(barValue+0.1)));
            }
            Thread.sleep(1000);
        }
    }

    @FXML
    private void sub_bar_value_sequence() throws InterruptedException {
        while(isDecrementingBarRunning){
            iv_border_1.setVisible(true);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(false);
            double barValue = Double.parseDouble(bar_tv.getText());
            DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
            if(barValue>0){
                bar_tv.setText(String.valueOf(df.format(barValue-0.1)));
            }
            Thread.sleep(1000);
        }
    }

    @FXML
    private void add_hz_value(){
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(false);
            iv_border_2.setVisible(true);
            iv_border_3.setVisible(false);
            int hzValue = Integer.parseInt(hz_tv.getText());
            if(hzValue<20){
                hz_tv.setText(String.valueOf(hzValue+1));
            }
        //}
    }

    @FXML
    private void add_hit_value(){
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(false);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(true);
            int hitValue = Integer.parseInt(hit_tv.getText());
            if(hitValue<3000){
                hit_tv.setText(String.valueOf(hitValue+100));
                sum_hit_tv.setText(String.valueOf(hitValue+100));
            }
        //}
    }

    @FXML
    private void sub_bar_value(){
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(true);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(false);
            double barValue = Double.parseDouble(bar_tv.getText());
            DecimalFormat df = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.US));
            if(barValue>0){
                bar_tv.setText(String.valueOf(df.format(barValue-0.1)));
            }
        //}
    }

    @FXML
    private void sub_hz_value(){
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(false);
            iv_border_2.setVisible(true);
            iv_border_3.setVisible(false);
            int hzValue = Integer.parseInt(hz_tv.getText());
            if(hzValue>0){
                hz_tv.setText(String.valueOf(hzValue-1));
            }
        //}
    }

    @FXML
    private void sub_hit_value(){
        //if(wasMoveLast){
        //    wasMoveLast = false;
        //}else{
            iv_border_1.setVisible(false);
            iv_border_2.setVisible(false);
            iv_border_3.setVisible(true);
            int hitValue = Integer.parseInt(hit_tv.getText());
            if(hitValue>0){
                hit_tv.setText(String.valueOf(hitValue-100));
                sum_hit_tv.setText(String.valueOf(hitValue-100));
            }
        //}
    }
}