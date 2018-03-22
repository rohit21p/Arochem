package sample.arochem.ui.couriersetup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.ui.productsetupform.ProductSetupController;
import sample.arochem.util.database.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourierSetupController {

    ObservableList<String> ol = FXCollections.observableArrayList("Rohit","Namit","Raj kale","Rohan","Praveen");
    ObservableList<Courier> list = FXCollections.observableArrayList();

    Connection con = null;
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField contact;

    @FXML
    private JFXTextField Address;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXComboBox<String> pincode;

    @FXML
    private JFXComboBox<String> city;

    @FXML
    private JFXComboBox<String> state;

    @FXML
    private JFXComboBox<String> categorycb;

    @FXML
    private JFXTextField searchcb;

    @FXML
    private JFXButton searchbtn;

    @FXML
    private JFXButton closebtn;

    @FXML
    private TableView<Courier> tableview;

    @FXML
    private TableColumn<Courier, String> namecol;

    @FXML
    private TableColumn<Courier, String> citycol;

    @FXML
    private TableColumn<Courier, String> contactcol;

    @FXML
    private TableColumn<Courier, String> addresscol;

    @FXML
    private TableColumn<Courier, String> docketcol;

    @FXML
    private void initialize() {
        initCol();
        initsearchcate();
        initdropdowns();
    }

    private void initsearchcate() {
        ObservableList ol2 = ol;
        ol2.clear();
        categorycb.getItems().clear();
        Database.getConnection();
        Database.getStatement();
//        if(!Database.doesTableExist("CourierSetupTrial2")) {
//            Database.createTableCourierSetup();
//        }
        String query = "SELECT DISTINCT itemname from ProductSetupTrial3";
        rs = Database.getdata(query);
        try {
            while(rs.next()) {
                ol2.add(rs.getString("itemname"));
            }

            categorycb.getItems().addAll(ol2);
        }catch(SQLException e) {
            System.out.println(e);
        }

        TextFields.bindAutoCompletion(categorycb.getEditor(), categorycb.getItems());
    }

    private void initCol() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        citycol.setCellValueFactory(new PropertyValueFactory<>("city"));
        contactcol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
        docketcol.setCellValueFactory(new PropertyValueFactory<>("docket"));
    }

    private void initdropdowns() {
        pincode.setItems(ol);
        TextFields.bindAutoCompletion(pincode.getEditor(), pincode.getItems());
        state.setItems(ol);
        TextFields.bindAutoCompletion(state.getEditor(), state.getItems());
        city.setItems(ol);
        TextFields.bindAutoCompletion(city.getEditor(), city.getItems());
        ObservableList<String> ol2 = FXCollections.observableArrayList("name","city","contact","address","docket");
        categorycb.setItems(ol2);
        TextFields.bindAutoCompletion(categorycb.getEditor(), categorycb.getItems());
    }

    @FXML
    void handlecloseaction(ActionEvent event) {
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handlesearchaction(ActionEvent event) {

        list.clear();
        ObservableList<Courier> list = FXCollections.observableArrayList();
        if(!Database.doesTableExist("CourierSetupTrial2")) {
            Database.createTableCourierSetup();
        }
        boolean isdata = false;
        Database.getConnection();
        st = Database.getStatement();
        String categoryans = null;
        categoryans = categorycb.getSelectionModel().getSelectedItem();
        String searchans = searchcb.getText();
        if(categoryans!=null) {
            try {
                String query = "Select * from CourierSetupTrial2 where "+categoryans+" like '%"+searchans+"%'";
                ResultSet rs = Database.getdata(query);
                while(rs.next()) {
                    isdata = true;
                    String nameans = rs.getString("name");
                    String cityans = rs.getString("city");
                    String contactans = rs.getString("contact");
                    String addressans = rs.getString("address");
//                String groupname = rs.getString("groupname");
                    String docketans = "not known";
                    list.add(new Courier(nameans, cityans, contactans, addressans, docketans));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(!isdata) {
                JOptionPane.showMessageDialog(null,"No Such Item");

            }
            tableview.getItems().setAll(list);
        }
        else {
            JOptionPane.showMessageDialog(null,"Choose Category");
        }

        list.clear();

    }

    @FXML
    void handlesearchdropaction(ActionEvent event) {
        String category = categorycb.getSelectionModel().getSelectedItem();
        searchcb.setText("Enter "+category);
    }

    @FXML
    void handlesubmitaction(ActionEvent event) {
        String nameans = name.getText();
        String contactans = contact.getText();
        String addressans = Address.getText();
        String pincodeans = pincode.getSelectionModel().getSelectedItem();
        String cityans = city.getSelectionModel().getSelectedItem();
        String stateans = state.getSelectionModel().getSelectedItem();
        String docketans = "";

        if(!Database.doesTableExist("CourierSetupTrial2")) {
            Database.createTableCourierSetup();
        }

        String query = "Insert into CourierSetupTrial2 values('"+nameans+"','"+pincodeans+"','"+cityans+"','"+stateans+"','"+contactans+"','"+addressans+"','"+docketans+"')";

        Database.enterIntoDB(query);

        JOptionPane.showMessageDialog(null,"Done");
    }


    public static class Courier {
        private final SimpleStringProperty name;
        private final SimpleStringProperty city;
        private final SimpleStringProperty contact;
        private final SimpleStringProperty address;
        private final SimpleStringProperty docket;

        Courier(String name, String city, String contact, String address, String docket) {
            this.name = new SimpleStringProperty(name);
            this.address = new SimpleStringProperty(address);
            this.contact  = new SimpleStringProperty(contact);
            this.docket = new SimpleStringProperty(docket);
            this.city = new SimpleStringProperty(city);
        }

        public String getName() {
            return name.getValue();
        }

        public String getCity() {
            return city.getValue();
        }

        public String getContact() {
            return contact.getValue();
        }

        public String getAddress() {
            return address.getValue();
        }

        public String getDocket() {
            return docket.getValue();
        }
    }
}
