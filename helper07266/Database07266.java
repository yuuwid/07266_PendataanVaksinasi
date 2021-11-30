package helper07266;

import javax.swing.*;
import java.sql.*;

public class Database07266 {

    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://" + config.DB_HOST + "/" + config.DB_NAME;
            String user = config.DB_USER;
            String pass = config.DB_PASS;

            Class.forName(config.DB_DRIVER);

            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }
}
