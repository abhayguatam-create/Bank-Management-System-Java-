package Bank_Management_System;
import java.sql.*;
public class databaseConnection {
    Connection connection;
    Statement statement;
databaseConnection(){
    try{
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","");
        statement=connection.createStatement();
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

}
