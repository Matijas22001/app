package org.app.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("#.#");
        if(barValue<6){
            bar_tv.setText(String.valueOf(df.format(barValue+0.1)));
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
    private void sub_bar_value(){
        iv_border_1.setVisible(true);
        iv_border_2.setVisible(false);
        iv_border_3.setVisible(false);
        double barValue = Double.parseDouble(bar_tv.getText());
        DecimalFormat df = new DecimalFormat("#.#");
        if(barValue>0){
            bar_tv.setText(String.valueOf(df.format(barValue-0.1)));
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
}