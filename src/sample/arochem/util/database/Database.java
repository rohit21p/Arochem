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
                System.out.println("con");
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

    public static void createTableCustomerSetup() {
        String query = "CREATE TABLE CustomerSetupTrial(firmname varchar(50) primary key," +
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

    public static void enterIntoDB(String query) {
        try {
            st.execute(query);
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
}
