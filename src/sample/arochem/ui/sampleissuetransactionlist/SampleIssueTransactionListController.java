package sample.arochem.ui.sampleissuetransactionlist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

public class SampleIssueTransactionListController {

    ObservableList<String>  ol = FXCollections.observableArrayList("City","Courier Name","Ref No");

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton edit;

    @FXML
    private JFXButton refresh;

    @FXML
    private JFXButton print;

    @FXML
    private JFXComboBox<String> searchBy;

    @FXML
    private Button close;

    @FXML
    private TableView tableview;

    @FXML
    void handlecloseaction(ActionEvent event) {
        Stage tobeclose= (Stage)add.getScene().getWindow();
        tobeclose.close();
    }

    @FXML
    void addConsignment(ActionEvent event) {

    }

    private void initDropdowns() {
        searchBy.setItems(ol);
        TextFields.bindAutoCompletion(searchBy.getEditor(), searchBy.getItems());
    }

    @FXML
    private void initialize() {
        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        initDropdowns();
    }

}
