package sample.arochem.util.database;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Database {

    private static Connection con= null;
    private static Statement st= null;
    private static ResultSet rs= null;

    public static Connection getConnection() {
        if(con == null) {
            System.out.println("connecting");
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                con = DriverManager.getConnection("jdbc:derby:database;create=true");
                System.out.println("Driver Loaded");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public static Statement getStatement() {
            if(con==null) {
                con = getConnection();
            }
            if(st == null) {
                try {
                    st = con.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//        }

        return st;
    }

    public static boolean doesTableExist(String table) {
        try {
            DatabaseMetaData check = null;
            check = con.getMetaData();
            rs = check.getTables(null, null, table.toUpperCase(), null);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createTableCourierSetup() {
        String query = "CREATE TABLE CourierSetupTrial2(name varchar(255),pincode varchar(255), city VARCHAR(255),state varchar(255), contact VARCHAR(255), address varchar(255), docket varchar(255))";
        try {
            st.execute(query);
            System.out.println("creating table Courier setup");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableCrmSetup() {
        String query = "CREATE TABLE CrmSetupTrial(empname varchar(255), empcontact varchar(255), crmid varchar(255) primary key)";
        try {
            st.execute(query);
            System.out.println("creating table CRM setup");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTableCustomerSetup() {
        String query = "CREATE TABLE CustomerSetupTrial(firmname varchar(50)," +
                " gstno varchar(50), courierpref varchar(50)," +
                " phoneno1 varchar(50), pincode varchar(50)," +
                " address varchar(50), fax varchar(50)," +
                " web varchar(50), contactperson varchar(50)," +
                " crm varchar(50), cellno varchar(50)," +
                " phoneno2 varchar(50), state varchar(50), city varchar(50)," +
                " stdcode varchar(50), email varchar(50))";
        try {
            st.execute(query);
            System.out.println("creating table customer setup");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableProductSetup() {
        String query = "CREATE TABLE ProductSetupTrial3(itemcode varchar(255), itemname varchar(50)," +
                " subname varchar(50), sensorydesc varchar(32672)," +
                " sellingprice varchar(50), olfactorygroupname varchar(50)," +
                " remark varchar(50), setupdate DATE)";
        try {
            st.execute(query);
            System.out.println("creating table Product setup");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableApplicationSector() {
        String query = "CREATE TABLE ApplicationSectorTrial3(itemcode varchar(255), itemname varchar(50)," +
                " ApplicationSector varchar(50))";
        try {
            st.execute(query);
            System.out.println("creating table Application Sector");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void enterIntoDB(String query) {
        try {
            st.execute(query);
            JOptionPane.showMessageDialog(null,"Data Entered Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableApplications() {
        String query = "CREATE TABLE ApplicationsTrial(firmname varchar(50), application varchar(50))";

        System.out.println("creating table application");
        try {
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getdata(String query) {
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void createTableSampleIssue() {
        String query = "CREATE TABLE SampleIssueTrial(refno varchar(255), refdate varchar(255), consignee varchar(255), city varchar(255), couriername varchar(255), docketno varchar(255))";

        System.out.println("creating table Sample Issue");
        try {
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
