package DAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


//test is at the bottom

public class db_interaction {

    static String url="jdbc:mysql://localhost:3306/poll";
    private static Connection _conn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            _conn = DriverManager.getConnection(url,"root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection _get_connection(){
        return _conn;
    }



    //This just a test
    public static void main(String[] args) {
        Connection _connection = db_interaction._get_connection();
        System.out.println("OKAY IT WORKS ,HAPPY NOW --> "+_connection.toString());
    }
}



