package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    Connection conn;

    public void initialize()
    {
        try
        {
            Class.forName("java.sql.Driver");
            conn = DriverManager.getConnection("jdbc:sqlite:D:/Programowanie/DatabaseManager/db/mydb.db");
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @FXML
    TextArea textSpace;

    @FXML
    Button runButton;

    @FXML
    private void runButtonClicked() {
        String query;
        query = textSpace.getText();

        Statement statement = null;

        try
        {
            statement = conn.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(query);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
