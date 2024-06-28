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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.model.UserModel;
import sample.utils.CreateConnection;

/**
 *
 * @author ASUS
 */
public class SearchDAO {

    public boolean search(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT username FROM [user] WHERE username=?";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
            return false;
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

    public List<UserModel> findAll() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM [user]";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                List<UserModel> userList = new ArrayList<UserModel>();
                
                
                while(rs.next()){
                    UserModel user = new UserModel();
                    user.setUsername(rs.getString("username"));
                    user.setFullname(rs.getString("fullname"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    
                    userList.add(user);
                }
                
                return userList;
            }
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
        return null;
    }
    
    public UserModel findOne(String username)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = CreateConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT username FROM [user] WHERE username=?";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                rs = stm.executeQuery();
                
                UserModel user = new UserModel();
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                
                if (rs.next()) {
                    return user;
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
