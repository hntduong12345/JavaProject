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
public class UpdateDAO {
    public static void update(String username, String password, String fullname, String email, String lastUsername)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        

        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                StringBuilder sql = new StringBuilder("UPDATE [user] ");
                    sql.append("SET username=?, password=?, fullname=?, email=? ");
                    sql.append("WHERE username=?");

                stm = con.prepareStatement(sql.toString());
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                stm.setString(4, email);
                stm.setString(5, lastUsername);
                
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
