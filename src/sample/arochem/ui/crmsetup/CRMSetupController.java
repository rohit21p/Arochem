package sample.arochem.ui.crmsetup;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.arochem.util.database.Database;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRMSetupController {

    @FXML
    private void initialize() {
        Database.getConnection();
        Database.getStatement();
    }

    @FXML
    private JFXTextField empname;

    @FXML
    private JFXTextField empcontact;

    @FXML
    private JFXTextField crmid;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField contact;

    @FXML
    void getcrmid(ActionEvent event) {
        Database.getConnection();
        Database.getStatement();

        if(!Database.doesTableExist("CrmSetupTrial")) {
            Database.createTableCrmSetup();
        }

        String empnameans = empname.getText();
        String empcontactans = "";
        empcontactans = empcontact.getText();

        empcontactans = empcontactans.trim();
        empnameans = empnameans.trim();

        String query = null;

        if(!empnameans.equalsIgnoreCase("")||!empcontactans.equalsIgnoreCase("")) {
            if(empnameans.equalsIgnoreCase("")) {
                empcontactans = empcontactans.toUpperCase();
                query = "Select * from CrmSetupTrial where upper(empcontact) = '"+empcontactans+"'";
            }
            else {
                empnameans = empnameans.toUpperCase();
                query = "Select * from CrmSetupTrial where upper(empname) = '"+empnameans+"'";
            }
            ResultSet rs = Database.getdata(query);
            try {
                if(rs.next()) {
                    empcontact.setText(rs.getString("empcontact"));
                    empname.setText(rs.getString("empname"));
                    crmid.setText(rs.getString("crmid"));
                }
                else {
                    String ans = JOptionPane.showInputDialog("There is no such employee, Press Y to register");

                    if(ans.equalsIgnoreCase("y")){
                        if(empnameans.equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(null, "Enter name");
                        }
                        else {
                            if (ans.equalsIgnoreCase("y")) {
                                int size = 01;
                                query = "SELECT crmid from CrmSetupTrial";
                                rs = Database.getdata(query);
                                try {
                                    while (rs.next()) {
                                        size++;
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                String crmidans = "ArochemID" + size;
                                query = "Insert into CrmSetupTrial values('"+empnameans+"','"+empcontactans+"','"+crmidans+"')";
                                Database.enterIntoDB(query);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Please Enter either name or contact");
    }

    @FXML
    void getempname(ActionEvent event) {
        Database.getConnection();
        Database.getStatement();

        if(!Database.doesTableExist("CrmSetupTrial")) {
            Database.createTableCrmSetup();
        }

        String empnameans = id.getText();
        String empcontactans = "";
        empcontactans = contact.getText();

        empcontactans = empcontactans.trim();
        empnameans = empnameans.trim();

        String query = null;

        if(!empnameans.equalsIgnoreCase("")||!empcontactans.equalsIgnoreCase("")) {
            if(empnameans.equalsIgnoreCase("")) {
                empcontactans = empcontactans.toUpperCase();
                query = "Select * from CrmSetupTrial where upper(empcontact) = '"+empcontactans+"'";
            }
            else {
                empnameans = empnameans.toUpperCase();
                query = "Select * from CrmSetupTrial where upper(crmid) = '"+empnameans+"'";
            }
            ResultSet rs = Database.getdata(query);
            try {
                if(rs.next()) {
                    contact.setText(rs.getString("empcontact"));
                    name.setText(rs.getString("empname"));
                    id.setText(rs.getString("crmid"));
                }
                else {
                    JOptionPane.showMessageDialog(null,"There is no such CRMID");

//                    if(ans.equalsIgnoreCase("y")){
//                        if(name.getText().equalsIgnoreCase("")) {
//                            JOptionPane.showMessageDialog(null, "Enter name");
//                        }
//                        else {
//                            if (ans.equalsIgnoreCase("y")) {
//                                int size = 01;
//                                query = "SELECT crmid from CrmSetupTrial";
//                                rs = Database.getdata(query);
//                                try {
//                                    while (rs.next()) {
//                                        size++;
//                                    }
//                                } catch (SQLException e) {
//                                    System.out.println(e);
//                                }
//                                String crmidans = "ArochemID" + size;
//                                query = "Insert into CrmSetupTrial values('"+empnameans+"','"+empcontactans+"','"+crmidans+"')";
//                                Database.enterIntoDB(query);
//                            }
//                        }
//                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Please Enter either CRMID or contact");
    }

    @FXML
    void savebycrmid(ActionEvent event) {
        String ans = JOptionPane.showInputDialog("It will change the Name or Contact leaving crm id same. Press Y to update");
        if(ans.equalsIgnoreCase("y")&&!name.getText().equalsIgnoreCase("")){
            String empnameans = name.getText();
            String empcontactans = contact.getText();
            String trial = "SELECT * from CrmSetupTrial where crmid = '"+id.getText()+"'";
            ResultSet rs = Database.getdata(trial);
            try {
                if(rs.next()) {
                    String query = "UPDATE CrmSetupTrial set empname = '"+empnameans+"', empcontact = '"+empcontactans+"' where crmid = '"+id.getText()+"'";
                    Database.enterIntoDB(query);

                }
                else {
                    JOptionPane.showMessageDialog(null,"No such CRM id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(name.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Enter name");
        }

    }

    @FXML
    void savebyempname(ActionEvent event) {

        String ans = JOptionPane.showInputDialog("It will change the Name or Contact leaving crm id same. Press Y to update");
        if(ans.equalsIgnoreCase("y")&&!empname.getText().equalsIgnoreCase("")){
            String empnameans = empname.getText();
            String empcontactans = empcontact.getText();
            String trial = "SELECT * from CrmSetupTrial where crmid = '"+crmid.getText()+"'";
            ResultSet rs = Database.getdata(trial);
            try {
                if(rs.next()) {
                    String query = "UPDATE CrmSetupTrial set empname = '"+empnameans+"', empcontact = '"+empcontactans+"' where crmid = '"+crmid.getText()+"'";
                    Database.enterIntoDB(query);

                }
                else {
                    JOptionPane.showMessageDialog(null,"No such CRM id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(empname.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Enter name");
        }

    }

}
