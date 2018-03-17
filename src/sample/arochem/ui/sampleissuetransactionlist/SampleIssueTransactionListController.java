package sample.arochem.ui.sampleissuetransactionlist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.util.database.DatabaseHandler;

import javax.swing.*;

public class SampleIssueTransactionListController {

    ObservableList<String> ol = FXCollections.observableArrayList("City", "Courier Name", "Ref No");

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
    private TableView<Sample> tableview;

    @FXML
    private TableColumn<?, ?> refNo;

    @FXML
    private TableColumn<?, ?> refDate;

    @FXML
    private TableColumn<?, ?> consignee;

    @FXML
    private TableColumn<?, ?> city;

    @FXML
    private TableColumn<?, ?> courierName;

    @FXML
    private TableColumn<?, ?> docketNo;

    @FXML
    void handlecloseaction(ActionEvent event) {
        Stage tobeclose = (Stage) add.getScene().getWindow();
        tobeclose.close();
    }

    @FXML
    void addConsignment(ActionEvent event) {

    }

    private void initDropdowns() {
        searchBy.setItems(ol);
        TextFields.bindAutoCompletion(searchBy.getEditor(), searchBy.getItems());
    }

    DatabaseHandler databaseHandler;

    @FXML
    private void initialize() {
        databaseHandler = new DatabaseHandler();
        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        initDropdowns();
    }

    @FXML
    void handleEditOption(ActionEvent event) {
        Sample selectedForDeletion = tableview.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            JOptionPane.showMessageDialog(null,"");
            return;

        }


    }

    public static class Sample {

        private final SimpleStringProperty refNo;
        private final SimpleStringProperty refDate;
        private final SimpleStringProperty consignee;
        private final SimpleStringProperty city;
        private final SimpleStringProperty courierName;
        private final SimpleStringProperty docketNo;

        public Sample(String refNo, String refDate, String consignee, String city, String courierName, String docketNo) {
            this.refNo = new SimpleStringProperty(refNo);
            this.refDate = new SimpleStringProperty(refDate);
            this.consignee = new SimpleStringProperty(consignee);
            this.city = new SimpleStringProperty(city);
            this.courierName = new SimpleStringProperty(courierName);
            this.docketNo = new SimpleStringProperty(docketNo);
        }

        public String getRefNo() {
            return refNo.get();
        }

        public String getRefDate() {
            return refDate.get();
        }

        public String getConsignee() {
            return consignee.get();
        }

        public String getCity() {
            return city.get();
        }

        public String getCourierName() {
            return courierName.get();
        }

        public String getDocketNo() {
            return docketNo.get();
        }

    }
}