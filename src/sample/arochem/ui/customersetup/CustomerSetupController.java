package sample.arochem.ui.customersetup;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.util.database.Database;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;

public class CustomerSetupController {

    ObservableList<String> ol = FXCollections.observableArrayList("Rohit","Namit","Raj kale","Rohan","Praveen");

    Connection con= null;
    Statement st= null;
    ResultSet rs=null;

    @FXML
    private JFXTextField gstno;

    @FXML
    private JFXTextField firmname;

    @FXML
    private JFXComboBox courierpref;

    @FXML
    private JFXTextField phoneno2;

    @FXML
    private JFXTextField address1;

    @FXML
    private JFXTextField address2;

    @FXML
    private JFXTextField pincode;

    @FXML
    private JFXTextField contactperson;

    @FXML
    private JFXTextField crm;

    @FXML
    private JFXTextField cellno;

    @FXML
    private JFXTextField phoneno1;

    @FXML
    private JFXComboBox state;

    @FXML
    private JFXComboBox city;

    @FXML
    private JFXTextField fax;

    @FXML
    private JFXTextField stdcode;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField web;

    @FXML
    private CheckComboBox<String> application;


    @FXML
    void handlecancelaction(ActionEvent event) {
        Stage tobeclose= (Stage)firmname.getScene().getWindow();
        tobeclose.close();
    }

    @FXML
    public void initialize () {

        initApplications();
        initDropdowns();
    }

    private void initDropdowns() {
        courierpref.setItems(ol);
        TextFields.bindAutoCompletion(courierpref.getEditor(), courierpref.getItems());
    }
    private void initApplications() {
        application.getItems().addAll(ol);
        application.getItems().add(0,"ALL");
        application.getItems().add(1,"NONE");
        application.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            boolean changing = false;

            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                if (!changing && application.getCheckModel().isChecked(0)) {
                    // trigger no more calls to checkAll when the selected items are modified by checkAll
                    changing = true;
                    application.getCheckModel().check(1);
                    application.getCheckModel().clearCheck(1);
                    for(int i = 2;i<=6;i++)
                        application.getCheckModel().check(i);
                    changing = false;
                    application.getCheckModel().clearCheck(0);
                }
                if (!changing && application.getCheckModel().isChecked(1)) {
                    // trigger no more calls to checkAll when the selected items are modified by checkAll
                    changing = true;
                    application.getCheckModel().check(0);
                    application.getCheckModel().clearChecks();
                    changing = false;
                }
                for(int i=2;i<=6;i++) {
                    if (!changing && application.getCheckModel().isChecked(i)) {
                        // trigger no more calls to checkAll when the selected items are modified by checkAll
                        changing = true;
                        application.getCheckModel().check(1);
                        application.getCheckModel().clearCheck(1);
                        changing = false;
                    }
                }
            }
        });
    }

    @FXML
    void handlepincodeaction(ActionEvent event) {
        String pincodeans = pincode.getText();
    }

    @FXML
    void handlesaveaction(ActionEvent event) {

        //get data from scene
        String firmnameans = firmname.getText();
        String webans = web.getText();
        String emailans = email.getText();
        String stdcodeans = stdcode.getText();
        String phoneno1ans = phoneno1.getText();
        String cellnoans = cellno.getText();
        String crmans = crm.getText();
        String contactpersonans = contactperson.getText();
        String addressans = address1.getText();
        addressans = addressans + " " + address2.getText();
        String pincodeans = pincode.getText();
        String phoneno2ans = phoneno2.getText();
        String faxans = fax.getText();
        String gstnoans = gstno.getText();
        String cityans = null, stateans = null, courierprefans=null;
        if(courierpref.getSelectionModel().getSelectedItem()!=null){
            courierprefans = courierpref.getSelectionModel().getSelectedItem().toString();
        }
        if(state.getSelectionModel().getSelectedItem()!=null){
            stateans = state.getSelectionModel().getSelectedItem().toString();
        }
        if(city.getSelectionModel().getSelectedItem()!=null){
            cityans = city.getSelectionModel().getSelectedItem().toString();
        }
        ObservableList<String> applicationans = application.getCheckModel().getCheckedItems();

        //enter data into database
        con = Database.getConnection();
        st = Database.getStatement();
        if(!Database.doesTableExist("CustomerSetupTrial"))
            Database.createTableCustomerSetup();
        if(!Database.doesTableExist("ApplicationsTrial"))
            Database.createTableApplications();

        String query = "INSERT INTO CustomerSetupTrial Values ('"+firmnameans+"', '"+gstnoans+"', '"+courierprefans+ "', " +
                        "'"+phoneno1ans+"', '"+pincodeans+"','"+addressans+"', '"+faxans+"', '"+webans+"', " +
                        " '"+contactpersonans+"', '"+crmans+"', '"+cellnoans+"', '"+phoneno2ans+"', " +
                        " '"+stateans+"', '"+cityans+"','"+stdcodeans+"','"+emailans+"')";
        Database.enterIntoDB(query);

        //print data from database
        for(int i =0; i <applicationans.size(); i++) {
            query = "INSERT INTO ApplicationsTrial values ('"+firmnameans+"', '"+applicationans.get(i)+"')";
            Database.enterIntoDB(query);
        }


        JOptionPane.showMessageDialog(null,"Success");


    }

}

