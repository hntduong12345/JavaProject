/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.database;

import java.io.Serializable;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        try {
            Context ctx = new InitialContext();
            Context envCtx = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("DuongHNTSP23WS01");
            Connection con = ds.getConnection();
            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://LAPTOP-VCOKAR4C\\TEST:1433;databaseName=DuongHNTSP23WS01";
//            Connection con = DriverManager.getConnection(url, "sa", "12345");

            return con;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
