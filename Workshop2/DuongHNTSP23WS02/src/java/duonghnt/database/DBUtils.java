/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonghnt.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        try {
//            Context ctx = new InitialContext();
//            Context envCtx = (Context) ctx.lookup("java:comp/env");
//            DataSource ds = (DataSource) envCtx.lookup("DuongHNTSP23WS01");
//            Connection con = ds.getConnection();
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DuongHNTSP23WS01";
            Connection con = DriverManager.getConnection(url, "sa", "12345");

            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
