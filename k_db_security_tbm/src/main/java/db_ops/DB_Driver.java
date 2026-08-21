/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_ops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Kasturi
 */
public class DB_Driver {

    public Statement st = null;
    public Connection conn = null;
    public Statement getDBStatement() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_security_tbm", "root", "root");
            st = conn.createStatement();

        } catch (Exception ex) {
            System.out.println("Exception at Class DB_Driver in method getDBStatement is : " + ex);
        }
        return st;
    }

}
