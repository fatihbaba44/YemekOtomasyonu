
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pc
 */
public class DBConnection {
     public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uygulama2", "root", "haticem");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
