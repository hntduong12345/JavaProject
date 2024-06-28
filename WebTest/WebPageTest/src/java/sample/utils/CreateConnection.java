/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

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
public class CreateConnection implements Serializable{
    public static Connection makeConnection(){
        try {
            //Static Database Connection.
            /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LAPTOP-VCOKAR4C\\TEST:1433;databaseName=TestJavaWebCode";
            Connection con = DriverManager.getConnection(url, "sa", "12345");
            return con;*/
            
            //Dynamic Database Connection.
            Context ctx = new InitialContext();
            Context envCtx = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("DBCon");
            Connection con = ds.getConnection();
            
            return con;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
