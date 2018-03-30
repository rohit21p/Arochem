package sample.arochem.ui.sampleissuetransactionlist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.ui.couriersetup.CourierSetupController;
import sample.arochem.util.database.Database;
import sample.arochem.util.database.DatabaseHandler;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleIssueTransactionListController {

    ObservableList<String> ol = FXCollections.observableArrayList("refno", "refdate", "consignee", "city", "couriername", "docketno");
    ObservableList<Sample> list = FXCollections.observableArrayList();

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
    private TableColumn<Sample, String> refNo;

    @FXML
    private TableColumn<Sample, String> refDate;

    @FXML
    private TableColumn<Sample, String> consignee;

    @FXML
    private TableColumn<Sample, String> city;

    @FXML
    private TableColumn<Sample, String> courierName;

    @FXML
    private TableColumn<Sample, String> docketNo;

    @FXML
    private JFXTextField search;

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

    @FXML
    private void initialize() {
        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        initDropdowns();
        initCol();
    }

    private void initCol() {
        refNo.setCellValueFactory(new PropertyValueFactory<>("refNo"));
        refDate.setCellValueFactory(new PropertyValueFactory<>("refDate"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        consignee.setCellValueFactory(new PropertyValueFactory<>("consignee"));
        docketNo.setCellValueFactory(new PropertyValueFactory<>("docketNo"));
        courierName.setCellValueFactory(new PropertyValueFactory<>("courierName"));
    }

    @FXML
    void handleEditOption(ActionEvent event) {
        Sample selectedForDeletion = tableview.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            JOptionPane.showMessageDialog(null,"Please Select a entry");
            return;

        }
    }

    @FXML
    void handlesearchaction(ActionEvent event) {
        list.clear();
        tableview.getItems().clear();
        Database.getConnection();
        Database.getStatement();

        if(!Database.doesTableExist("SampleIssueTrial"))
            Database.createTableSampleIssue();

        String query = "SELECT * from SampleIssueTrial where upper("+searchBy.getSelectionModel().getSelectedItem()+") = '"+search.getText().toUpperCase()+"'";

        ResultSet rs = Database.getdata(query);

        Boolean isdata = false;

        try {
            while(rs.next()) {
                    isdata = true;
                    String refnoans = rs.getString("refno");
                    String refdate = rs.getString("refdate");
                    String city = rs.getString("city");
                    String consignee = rs.getString("consignee");
                    String docketno = rs.getString("docketno");
                    String courier = rs.getString("couriername");
                    list.add(new Sample(refnoans, refdate, consignee, city, courier, docketno));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        if(!isdata) {
            JOptionPane.showMessageDialog(null,"No Such Data");
        }

        tableview.getItems().setAll(list);
    }

    @FXML
    void handlesearchbyaction(ActionEvent event) {
        String ans = searchBy.getSelectionModel().getSelectedItem();
        search.setPromptText("Enter "+ans);

        if(ans.equalsIgnoreCase("refdate"))
            search.setPromptText("YYYY-MM-DD");
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
            return refNo.getValue();
        }

        public String getRefDate() {
            return refDate.getValue();
        }

        public String getConsignee() {
            return consignee.getValue();
        }

        public String getCity() {
            return city.getValue();
        }

        public String getCourierName() {
            return courierName.getValue();
        }

        public String getDocketNo() {
            return docketNo.getValue();
        }
    }
}