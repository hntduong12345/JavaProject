/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.io.Serializable;
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
public class LoginDAO implements Serializable{

    public String checkLogin(String username, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                StringBuilder sql = new StringBuilder("SELECT u.username, u.password, r.type FROM [user] u");
                sql.append(" INNER JOIN [role] r on u.roleId = r.id");
                sql.append(" WHERE username=? AND password=?");
                String query = sql.toString();

                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setString(2, password);

                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getString("type");
                }
            }
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
