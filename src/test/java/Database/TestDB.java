package Database;

import org.testng.annotations.Test;

import java.sql.*;

public class TestDB {
    static String uName;
    static String  uPass;
    @Test
    public void TestNewDB() {
        ResultSet rs = null;
        Statement statement = null;
        Connection conn = null;


        try {
            String url = "jdbc:sqlite:C:/Program Files/sqllite/test.db";
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                statement = conn.createStatement();
                String query = "select * from USER";
                rs = statement.executeQuery((query));
                while (rs.next()) {
                   // System.out.println(rs.getString(1));
                    uName =   rs.getString("USERNAME");
                    uPass =  rs.getString("PASSWORD");

                    System.out.println(rs.getInt("ID") +  "\t" +
                            rs.getString("USERNAME") + "\t" +
                            rs.getInt("PASSWORD"));
                }
            }
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static String getuName(){
        return uName;
    }
    public static String getuPass(){
        return uPass;
    }
}
