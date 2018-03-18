//package sample.arochem.ui.citywisereport;
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXComboBox;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import sample.arochem.ui.customersetup.CustomerSetupController;
//import sample.arochem.util.database.DatabaseHandler;
//import java.net.URL;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;kj


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CrmController{

    @FXML
    void cnt(ActionEvent event) {

    }

    @FXML
    void crmi(ActionEvent event) {

    }

    @FXML
    void crmid(ActionEvent event) {

    }

    @FXML
    void crmsearch(ActionEvent event) {

    }

    @FXML
    void empn(ActionEvent event) {

    }

    @FXML
    void empname(ActionEvent event) {

    }

    @FXML
    void savebtn(ActionEvent event) {


//
//    DatabaseHandler databaseHandler;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        initCol();
//        loadData();
//        databaseHandler = DatabaseHandler.getInstance();
//    }
//
//    private void loadData() {
//        DatabaseHandler handler = DatabaseHandler.getInstance();
//        String qu = "SELECT * FROM CITY";
//        ResultSet rs = handler.execQuery(qu);
//        try {
//            while (rs.next()) {
//                String consignee = rs.getString("consigneecol");
//                String referenceno = rs.getString("referencecol");
//                String date = rs.getString("datecol");
//                String itemname = rs.getString("itemcol");
//                String subname = rs.getString("subnamecol");
//                String quantity = rs.getString("quantitycol");
//                String rate = rs.getString("ratecol");
//
//                list.add(new City(consignee, referenceno, date, itemname, subname, quantity, rate));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerSetupController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        tableview.getItems().setAll(list);
//
//    }
//
//    private void initCol() {
//        consigneecol.setCellFactory(new PropertyValueFactory<>("consignee"));
//        referencecol.setCellFactory(new PropertyValueFactory<>("referenceno"));
//        datecol.setCellFactory(new PropertyValueFactory<>("date"));
//        itemcol.setCellFactory(new PropertyValueFactory<>("itemname"));
//        subnamecol.setCellFactory(new PropertyValueFactory<>("subname"));
//        quantitycol.setCellFactory(new PropertyValueFactory<>("quantity"));
//        ratecol.setCellFactory(new PropertyValueFactory<>("rate"));
//    }
//
//    public static class City {
//        private final SimpleStringProperty consignee;
//        private final SimpleStringProperty referenceno;
//        private final SimpleStringProperty date;
//        private final SimpleStringProperty itemname;
//        private final SimpleStringProperty subname;
//        private final SimpleStringProperty quantity;
//        private final SimpleStringProperty rate;
//
//        public City(String consignee, String referenceno, String date, String itemname, String subname, String quantity, String rate) {
//            this.consignee = new SimpleStringProperty(consignee);
//            this.referenceno = new SimpleStringProperty(referenceno);
//            this.date = new SimpleStringProperty(date);
//            this.itemname = new SimpleStringProperty(itemname);
//            this.subname = new SimpleStringProperty(subname);
//            this.quantity = new SimpleStringProperty(quantity);
//            this.rate = new SimpleStringProperty(rate);
//        }
//
//
//        public String getConsignee() {
//            return consignee.get();
//        }
//
//        public String getReferenceno() {
//            return referenceno.get();
//        }
//
//        public String getDate() {
//            return date.get();
//        }
//
//        public String getItemname() {
//            return itemname.get();
//        }
//
//        public String getSubname() {
//            return subname.get();
//        }
//
//        public String getQuantity() {
//            return quantity.get();
//        }
//
//        public String getRate() {
//            return rate.get();
//        }
//
//    }
//
//
//    @FXML
//    void handlecloseaction(ActionEvent event) {
//        Stage tobeclose = (Stage)closebtn.getScene().getWindow();
//        tobeclose.close();
//    }
//
//    @FXML
//    void handleshowreportaction(ActionEvent event) {
//
//
//    }
//
//
//    @FXML
//    void loadcityinfo(ActionEvent event) {
//    String pincode = pincodecb.getAccessibleText();
//    String qu = "SELECT sname cname consignee FROM CITY WHERE pincode = '" + pincode + "'";
//    ResultSet rs = databaseHandler.execQuery(qu);
//
//    try{
//        while(rs.next())
//        {
//            String sname = rs.getString("state");
//            String cname = rs.getString("city");
//
//            statecb.setAccessibleText(sname);
//            citycb.setAccessibleText(cname);
//        }
//    }
//    catch (SQLException ex) {
//        Logger.getLogger(CityWiseController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    }
//}
//
//
