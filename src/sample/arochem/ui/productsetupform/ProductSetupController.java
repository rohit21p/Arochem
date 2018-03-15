package sample.arochem.ui.productsetupform;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductSetupController {

    @FXML
    private VBox tobeadded;

    @FXML
    public void handlesubaction () {

        JFXTextField subname2 = new JFXTextField();
        HBox hbox = new HBox();
        tobeadded.getChildren().add(1, hbox);
        hbox.getChildren().add(0,subname2);
        subname2.setPadding(new Insets(0,20,20,20));
        subname2.setLabelFloat(true);
        subname2.setPrefWidth(5000);
        subname2.setPromptText("Subname");

    }
}
