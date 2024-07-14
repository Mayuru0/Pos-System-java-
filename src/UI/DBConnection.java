package UI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Copy.Registation1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author devzo
 */
public class DBConnection {
    
    
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/markcomputerdb", "root", "");
            System.out.println("DB Connected Success");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            //System.out.println("Erro in DB Connection");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Registation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Erro in DB Connection");
        }
        return null;
    }
}