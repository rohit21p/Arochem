package sample.arochem.util.database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Database {

    private static Connection con= null;
    private static Statement st= null;
    private static ResultSet rs= null;

    public static Connection getConnection() {
        if(con == null) {
            System.out.println("hela");
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                con = DriverManager.getConnection("jdbc:derby:database;create=true");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public static Statement getStatement(Connection con) {
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
            rs = check.getTables(null, null, table, null);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createTableCustomerSetup() {
        String query = "CREATE TABLE CustomerSetup2(firmname varchar(20)," +
                " gstno varchar(20), courierpref varchar(20)," +
                " phoneno2 varchar(20), address varchar(20)," +
                " fax varchar(20), pincode varchar(20)," +
                " contactperson varchar(20), crm varchar(20)," +
                " cellno varchar(20), phoneno1 varchar(20)," +
                " stdcode varchar(20), email varchar(20), web varchar(20)," +
                " state varchar(20), city varchar(20))";
        try {
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
