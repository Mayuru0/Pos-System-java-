package Testme;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class DataBaseConnection {
    
    public Connection getConnection() throws SQLException{
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb", "root", "");
            System.out.println("DB Connected Success");
        } catch (Exception e) {
            System.out.println("Erro in DB Connection");
            e.printStackTrace();
        }
        return con;
    }

    
}
