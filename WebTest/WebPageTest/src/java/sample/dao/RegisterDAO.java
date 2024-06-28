/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.utils.CreateConnection;

/**
 *
 * @author ASUS
 */
public class RegisterDAO {

    public boolean registAccount(String username, String password, String fullname, String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = CreateConnection.makeConnection();
            con.setAutoCommit(false);

            String sql = "INSERT INTO [user](username,password,fullname,email,roleId) VALUES(?,?,?,?,?);";

            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setString(4, email);
            stm.setString(5, "2");

            int result = stm.executeUpdate();
            con.commit();
            return result!=0;
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
