package sample.arochem.ui.customersetup;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import sample.arochem.util.database.Database;

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
    private JFXTextField pincode;

    @FXML
    private JFXTextArea address;

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
    void handlecancelaction(ActionEvent event) {
      //  courierpref.setItems(ol);
       // TextFields.bindAutoCompletion(courierpref.getEditor(), courierpref.getItems());
    }

    @FXML
    void handlesaveaction(ActionEvent event) {

        String firmnameans = firmname.getText();
        String webans = web.getText();
        String emailans = email.getText();
        String stdcodeans = stdcode.getText();
        String phoneno1eans = phoneno1.getText();
        String cellnoans = cellno.getText();
        String crmans = crm.getText();
        String contactpersonans = contactperson.getText();
        String addressans = address.getText();
        String pincodeans = pincode.getText();
        String phoneno2ans = phoneno2.getText();
        String faxans = fax.getText();
        String gstnoans = gstno.getText();
//        String courierprefans = courierpref.getSelectionModel().getSelectedItem().toString();
//        String stateans = state.getSelectionModel().getSelectedItem().toString();
//        String cityans = city.getSelectionModel().getSelectedItem().toString();


        con = Database.getConnection();
        st = Database.getStatement(con);

        if(Database.doesTableExist("CustomerSetup2"))
            Database.createTableCustomerSetup();

//        String query = "INSERT INTO Trial Values ('"+firmnameans+"', '"+gstnoans+"', '"+courierprefans+ "', " +
//                        "'"+phoneno2ans+"', '"+addressans+"', '"+faxans+"', '"+pincodeans+"'," +
//                        " '"+contactpersonans+"', '"+crmans+"', '"+cellnoans+"', '"+phoneno1eans+"', '"+stdcodeans+"'," +
//                        " '"+emailans+"', '"+webans+"', '"+stateans+"', '"+cityans+"')";;
//
//
//
//        rs = Database.getResult(query);

    }

}

