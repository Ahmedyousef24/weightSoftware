package sample.Controller;


import java.io.FileReader;
import java.sql.*;
import java.util.Properties;


public class DBConnect {
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;

    public DBConnect() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("db.properties");
            Properties properties = new Properties();
            properties.load(fileReader);

            connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
            statement = connection.createStatement();

        } catch (Exception ex) {
            System.out.println("Db Error" + ex);
        }
    }

    public void getData() {
        try {
            String query = "Select * From weighIn";
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                int id = resultset.getInt("id");
                System.out.println(id);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
