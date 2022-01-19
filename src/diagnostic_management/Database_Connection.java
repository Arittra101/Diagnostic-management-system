/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SC
 */
public class Database_Connection {

    public static Connection con;
    public static void  Connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;" + "databaseName=DG_center;";
//            String dbURL =  "jdbc:sqlserver://localhost::1433";
//            String dbuser = "sa";
//            String dbPass = "p@ssword13";
            con = DriverManager.getConnection(connectionUrl);

            System.out.println("Connected");

//             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
