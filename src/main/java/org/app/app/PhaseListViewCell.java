package org.app.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PhaseListViewCell extends ListCell<PhaseItem> {
    {
        setStyle("-fx-padding: 0px");
    }
    @FXML
    private TextField index;
    @FXML
    private TextField phase_value;
    @FXML
    private TextField barHzValue;
    @FXML
    private TextField hitValue;

    @FXML
    private AnchorPane anchorPane;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(PhaseItem phaseItem, boolean empty) {
        super.updateItem(phaseItem, empty);

        if(empty || phaseItem == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("list_item.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            this.phase_value.setText(String.valueOf(phaseItem.getId()));
            this.barHzValue.setText(phaseItem.getBar_value()+ " Bar " +"| "+ phaseItem.getHz_value()+ "Hz");
            this.hitValue.setText(String.valueOf(phaseItem.getHit_value()));
            setText(null);
            setGraphic(anchorPane);
        }

    }
}
