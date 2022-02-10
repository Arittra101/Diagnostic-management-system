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

    public static Connection Connection() {

        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;databaseName=DG_center";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            if (con != null) {
                System.out.println("Connected");
                return con;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
