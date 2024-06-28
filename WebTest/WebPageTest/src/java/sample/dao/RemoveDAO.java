/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.utils.CreateConnection;

/**
 *
 * @author ASUS
 */
public class RemoveDAO {
    public static void remove(String username) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        System.out.println(username+" error!");
        
        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM [user] WHERE username=?";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                stm.execute();
                
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
