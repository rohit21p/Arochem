package sample.arochem.ui.productsetupform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.derby.client.am.SqlException;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.textfield.TextFields;
import sample.arochem.util.database.Database;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ProductSetupController extends ProductSetupLoader{

    ObservableList<String> ol = FXCollections.observableArrayList("Rohit","Namit","Raj kale","Rohan","Praveen");


    Connection con= null;
    Statement st= null;
    ResultSet rs=null;

    ObservableList<Product> list = FXCollections.observableArrayList();

    @FXML
    private JFXTextField itemname;

    @FXML
    private JFXTextArea sensorydesc;

    @FXML
    private CheckComboBox<String> applicationsector;

    @FXML
    private VBox tobeadded;

    @FXML
    private JFXTextField subname;

    @FXML
    private FlowPane hbox;

    @FXML
    private JFXTextField sellingprice;

    @FXML
    private JFXComboBox<String> olfactorygroupname;

    @FXML
    private JFXTextField remark;

    @FXML
    private JFXComboBox<String> searchItem;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, String> subnamecol;

    @FXML
    private TableColumn<Product, String> applicationsectorcol;

    @FXML
    private TableColumn<Product, String> datecol;

    @FXML
    private TableColumn<Product, String> itemcodecol;

    @FXML
    private TableColumn<Product, String> groupnamecol;

    @FXML
    private TableColumn<Product, String> itemnamecol;

    @FXML
    private TableColumn<Product, String> pricecol;

    @FXML
    private TableColumn<Product, String> sensorydesccol;


    ArrayList<String> subnameans = new ArrayList<String>();

    @FXML
    public void initialize() {
        initCol();
        initDropdowns();
        initApplicationSector();
        initSearchItem();
    }

    private void initSearchItem() {
        ObservableList ol2 = ol;
        ol2.clear();
        Database.getConnection();
        Database.getStatement();
        if(!Database.doesTableExist("ProductSetupTrial3")) {
            Database.createTableProductSetup();
        }
        if(!Database.doesTableExist("ApplicationSectorTrial2")) {
            Database.createTableApplicationSector();
        }
        ObservableList<String> ol = FXCollections.observableArrayList();
        String query = "SELECT DISTINCT itemname from ProductSetupTrial3";
        rs = Database.getdata(query);
        try {
            while(rs.next()) {
                ol2.add(rs.getString("itemname"));
            }

                searchItem.getItems().addAll(ol2);
            }catch(SQLException e) {
            System.out.println(e);
        }

        TextFields.bindAutoCompletion(searchItem.getEditor(), searchItem.getItems());
        }

    private void initApplicationSector() {
        applicationsector.getItems().addAll(ol);
        applicationsector.getItems().add(0,"ALL");
        applicationsector.getItems().add(1,"NONE");
        applicationsector.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            boolean changing = false;

            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                if (!changing && applicationsector.getCheckModel().isChecked(0)) {
                    // trigger no more calls to checkAll when the selected items are modified by checkAll
                    changing = true;
                    applicationsector.getCheckModel().check(1);
                    applicationsector.getCheckModel().clearCheck(1);
                    for(int i = 2;i<=6;i++)
                        applicationsector.getCheckModel().check(i);
                    changing = false;
                    applicationsector.getCheckModel().clearCheck(0);
                }
                if (!changing && applicationsector.getCheckModel().isChecked(1)) {
                    // trigger no more calls to checkAll when the selected items are modified by checkAll
                    changing = true;
                    applicationsector.getCheckModel().check(0);
                    applicationsector.getCheckModel().clearChecks();
                    changing = false;
                }
                for(int i=2;i<=6;i++) {
                    if (!changing && applicationsector.getCheckModel().isChecked(i)) {
                        // trigger no more calls to checkAll when the selected items are modified by checkAll
                        changing = true;
                        applicationsector.getCheckModel().check(1);
                        applicationsector.getCheckModel().clearCheck(1);
                        changing = false;
                    }
                }
            }
        });
    }

    private void initDropdowns() {
        olfactorygroupname.setItems(ol);
        TextFields.bindAutoCompletion(olfactorygroupname.getEditor(), olfactorygroupname.getItems());
    }


    private void initCol() {
        subnamecol.setCellValueFactory(new PropertyValueFactory<>("subname2"));
        itemcodecol.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        applicationsectorcol.setCellValueFactory(new PropertyValueFactory<>("applicationsector"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date2"));
        itemnamecol.setCellValueFactory(new PropertyValueFactory<>("itemname2"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        sensorydesccol.setCellValueFactory(new PropertyValueFactory<>("sensorydesc"));
        groupnamecol.setCellValueFactory(new PropertyValueFactory<>("groupnamecol"));
    }

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
        itemname.setText("");

    }

    @FXML
    void handlesaveaction(ActionEvent event) {
        String olfactorygroupnameans = null;
        if(olfactorygroupname.getSelectionModel().getSelectedItem()!=null){
            olfactorygroupnameans = olfactorygroupname.getSelectionModel().getSelectedItem().toString();
        }
        String remarkans = remark.getText();
        String sellingpriceans = sellingprice.getText();
        ObservableList<String> applicationsectorans = applicationsector.getCheckModel().getCheckedItems();
        String sensorydescans = sensorydesc.getText();
        String itemnameans = itemname.getText();
        Database.getConnection();
        Database.getStatement();
        LocalDate date = LocalDate.now();
        String dateans = String.valueOf(date);
        if(!Database.doesTableExist("ProductSetupTrial3")) {
            Database.createTableProductSetup();
        }
        if(!Database.doesTableExist("ApplicationSectorTrial3")) {
            Database.createTableApplicationSector();
        }

        String query = "SELECT DISTINCT itemcode from ProductSetupTrial3 where itemname = '"+itemnameans+"'";
        rs = Database.getdata(query);
        int size = 01;
        try {
            while(rs.next()) {
                size++;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Couldn't create duplicate data");
            System.out.println(e);
        }
        String itemcode = itemnameans + "0" + size;
        if(subnameans.size() == 0) {
            JOptionPane.showMessageDialog(null,"Please enter subname");
        }
        else {

            for(int i=0;i<subnameans.size();i++) {
                query = "INSERT INTO ProductSetupTrial3 Values ('"+itemcode+"','"+itemnameans+"','"+subnameans.get(i)+"','"+sensorydescans+"','"+sellingpriceans+"','"+olfactorygroupnameans+"','"+remarkans+"','"+dateans+"')";
                Database.enterIntoDB(query);
            }
            for(int i=0;i<applicationsectorans.size();i++) {
                query = "INSERT INTO ApplicationSectorTrial3 Values ('"+itemcode+"','"+itemnameans+"','"+applicationsectorans.get(i)+"')";
                Database.enterIntoDB(query);
            }
            JOptionPane.showMessageDialog(null,"Done");

        }

        initSearchItem();


    }
    private String getApplicatioinSector(String itemname) {
        con = Database.getConnection();
        ResultSet rs2=null;
        try {
            st = con.createStatement();
            rs2 = st.executeQuery("Select * from ApplicationSectorTrial3 where itemcode = '"+itemname+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String applicationsectorans="";
            try {
                while(rs2.next()) {
                applicationsectorans = applicationsectorans + "," + rs2.getString("applicationsector");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return applicationsectorans;
    }

    @FXML
    void handlesearchaction(ActionEvent event) {
        list.clear();
        ObservableList<Product> list = FXCollections.observableArrayList();
        if(!Database.doesTableExist("ProductSetupTrial3")) {
            Database.createTableProductSetup();
        }
        if(!Database.doesTableExist("ApplicationSectorTrial3")) {
            Database.createTableApplicationSector();
        }
        boolean isdata = false;
        Database.getConnection();
        st = Database.getStatement();
        String searchitemans = null;
        if(searchItem.getSelectionModel().getSelectedItem()!=null){
            searchitemans = searchItem.getSelectionModel().getSelectedItem().toString();
        }
        try {
            String query = "Select * from ProductSetupTrial3 where itemname = '"+searchitemans+"'";
            ResultSet rs = Database.getdata(query);
            while(rs.next()) {
                isdata = true;
                String itemname = rs.getString("itemname");
                String subnameans = rs.getString("subname");
                String itemcodeans = rs.getString("itemcode");
                String date = rs.getString("setupdate");
//                String groupname = rs.getString("groupname");
                String groupname = "not known";
                String price = rs.getString("sellingprice");
                String sensorydesc = rs.getString("sensorydesc");
                String applicationsectorans = getApplicatioinSector(itemcodeans);
                list.add(new Product(subnameans,itemcodeans,applicationsectorans,date,groupname,itemname,price,sensorydesc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!isdata) {
            JOptionPane.showMessageDialog(null,"No Such Item");

        }
        table.getItems().setAll(list);
        list.clear();

    }

    @FXML
    public void handlesubaction () {
        JFXButton tag1 = new JFXButton();
        subnameans.add(subname.getText());
        tag1.setText(subname.getText()+" | x");
        hbox.setPadding(new Insets(0,0,0,20));
        tag1.setStyle("-fx-padding: 6.5;");
        hbox.getChildren().add(tag1);
        subname.setText("");
        tag1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String isit = JOptionPane.showInputDialog("Do you want to delete this?\nReply with Y or N");
                if(isit.equalsIgnoreCase("y")) {
                    hbox.getChildren().remove(tag1);
                    subnameans.remove(tag1.getText());
                }
            }
        });

    }

    public static class Product {
        private final SimpleStringProperty subname2;
        private final SimpleStringProperty itemcode;
        private final SimpleStringProperty applicationsector;
        private final SimpleStringProperty date2;
        private final SimpleStringProperty groupname;
        private final SimpleStringProperty itemname2;
        private final SimpleStringProperty price;
        private final SimpleStringProperty sensorydesc;

        public Product(String subname,String itemcode, String applicationsector, String date, String groupname, String itemname, String price, String sensorydesc) {
            this.subname2 = new SimpleStringProperty(subname);
            this.itemcode = new SimpleStringProperty(itemcode);
            this.applicationsector = new SimpleStringProperty(applicationsector);
            this.date2 = new SimpleStringProperty(date);
            this.itemname2 = new SimpleStringProperty(itemname);
            this.groupname = new SimpleStringProperty(groupname);
            this.price = new SimpleStringProperty(price);
            this.sensorydesc = new SimpleStringProperty(sensorydesc);
        }

        public String getSubname2() {
            return subname2.getValue();
        }

        public String getItemcode() {
            return itemcode.getValue();
        }

        public String getApplicationsector() {
            return applicationsector.getValue();
        }

        public String getDate2() {
            return date2.getValue();
        }

        public String getItemname2() {
            return itemname2.getValue();
        }

        public String getGroupname() {
            return groupname.getValue();
        }

        public String getPrice() {
            return price.getValue();
        }

        public String getSensorydesc() {
            return sensorydesc.getValue();
        }

    }
}
