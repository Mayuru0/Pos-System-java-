package Testme;


import UI.DBConnection;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class testme {
    public static void main(String[] args) throws SQLException{
        DBConnection db = new DBConnection();
        db.getConnection();
    }
    
}
