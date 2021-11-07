package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessDao {
    private Connection connection;

    public AccessDao() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_book", "root", "1234567890");
        }
        return connection;
    }

}
