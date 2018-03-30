package sample.arochem.ui.sampleissue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.util.database.Database;

import javax.swing.*;
import java.time.LocalDate;

public class SampleIssueController {

    ObservableList<String> ol = FXCollections.observableArrayList("Rohit","Namit","Raj kale","Rohan","Praveen");

    @FXML
    private JFXTextField Consignee;

    @FXML
    private JFXTextField Address;

    @FXML
    private JFXTextField State;

    @FXML
    private JFXTextField CRM;

    @FXML
    private JFXComboBox<String> CourierName;

    @FXML
    private JFXTextField RefNo;

    @FXML
    private JFXTextField Rate;

    @FXML
    private JFXTextField TelephoneNo;

    @FXML
    private JFXTextField City;

    @FXML
    private JFXDatePicker todaysdate;

    @FXML
    private JFXDatePicker nextdate;

    @FXML
    private JFXButton Save;

    @FXML
    private JFXButton Remove;

    @FXML
    private JFXButton Close;

    @FXML
    void initialize() {
        Database.getConnection();
        Database.getStatement();
        LocalDate date = LocalDate.now();
        todaysdate.setValue(date);
        nextdate.setValue(date.plusDays(7));
        initDropdowns();
    }

    @FXML
    void handlecancelaction(ActionEvent event) {
        Stage stage = (Stage)RefNo.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleprintaction(ActionEvent event) {

    }


    private void initDropdowns() {
        CourierName.setItems(ol);
        TextFields.bindAutoCompletion(CourierName.getEditor(), CourierName.getItems());
    }

    @FXML
    void handlesaveaction(ActionEvent event) {
        Database.getConnection();
        Database.getStatement();

        LocalDate date = todaysdate.getValue();
        String dateans = String.valueOf(date);
        String couriernameans = "";
        if(CourierName.getSelectionModel().getSelectedItem()!=null)
            couriernameans = CourierName.getSelectionModel().getSelectedItem().toString();
        String docketnoans = "";

        if(!Database.doesTableExist("SampleIssueTrial"))
            Database.createTableSampleIssue();

        String query = "INSERT INTO SampleIssueTrial values('"+RefNo.getText()+"','"+dateans+"','"+Consignee.getText()+"','"+City.getText()+"','"+couriernameans+"','"+docketnoans+"')";
        Database.enterIntoDB(query);
    }

}
