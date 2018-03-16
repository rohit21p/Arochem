package sample.arochem.ui.productsetupform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

import javax.swing.*;

public class ProductSetupController extends ProductSetupLoader{

    @FXML
    private JFXTextField itemname;

    @FXML
    private JFXComboBox<?> searchbyitemname;

    @FXML
    private JFXTextArea sensorydesc;

    @FXML
    private CheckComboBox<?> applicationsector;

    @FXML
    private VBox tobeadded;

    @FXML
    private JFXTextField subname;

    @FXML
    private FlowPane hbox;

    @FXML
    private JFXTextField sellingprice;

    @FXML
    private JFXComboBox<?> olfactorygroupname;

    @FXML
    private JFXTextField remark;

    @FXML
    private JFXComboBox<?> searchItem;

    JFXButton tag1;


    @FXML
    void handleresetaction(ActionEvent event) {
        searchItem.getSelectionModel().clearSelection();
        remark.setText("");
        olfactorygroupname.getSelectionModel().clearSelection();
        sellingprice.setText("");
        hbox.getChildren().clear();
        subname.setText("");
        applicationsector.getCheckModel().clearChecks();
        sensorydesc.setText("");
        searchbyitemname.getSelectionModel().clearSelection();
        itemname.setText("");

    }

    @FXML
    void handlesaveaction(ActionEvent event) {

    }

    @FXML
    public void handlesubaction () {

        tag1 = new JFXButton();
        hbox.setPadding(new Insets(0,0,0,20));
        hbox.getChildren().add(tag1);
        tag1.setText(subname.getText());
        subname.setText("");
        tag1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String isit = JOptionPane.showInputDialog("Do you want to delete this?\nReply with Y or N");
                if(isit.equalsIgnoreCase("y")) {
                    hbox.getChildren().remove(tag1);
                }
            }
        });

    }
}
