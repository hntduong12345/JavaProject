/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonghnt.registration;

import duonghnt.database.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class RegistrationDAO implements Serializable{
    private List<RegistrationDTO> listAccount;

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }
    
    public boolean checkLogin(String username, String password) 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBUtils.makeConnection();
            
            if(con!= null){
                String sql = "SELECT username, password FROM Registration WHERE username=? AND password=?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if(rs.next()){
                    return true;
                }
            }
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
//    public void regist(String username, String password, String fullname)
//            throws SQLException, NamingException{
//        Connection con = null;
//        PreparedStatement stm = null;
//        
//        try{
//            con = DBUtils.makeConnection();
//            con.setAutoCommit(false);
//            if(con!=null){
//                String sql = "INSERT INTO Registration(username, password, lastname, isAdmin) VALUES(?,?,?,?);";
//                
//                stm = con.prepareStatement(sql);
//                stm.setString(1, username);
//                stm.setString(2, password);
//                stm.setString(3, fullname);
//                stm.setBoolean(4, false);
//                
//                stm.execute();
//                con.commit();
//            }
//        }catch(SQLException e){
//            if(con!=null){
//                try {
//                    con.rollback();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        finally{
//            if(con!=null){
//                con.close();
//            }
//            if(stm!=null){
//                stm.close();
//            }
//        }
//    }
    
    public List<RegistrationDTO> searchByLastName(String searchValue) 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBUtils.makeConnection();
            
            if(con!=null){
                String sql = "SELECT * FROM Registration WHERE lastname like ?";
                searchValue = "%"+searchValue+"%";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue);
                
                rs = stm.executeQuery();
                
                while(rs.next()){
                     RegistrationDTO dto = new RegistrationDTO(rs.getString("username"),
                             rs.getString("password"), rs.getString("lastname"), rs.getBoolean("isAdmin"));
                    
                     if(this.listAccount==null){
                         this.listAccount = new ArrayList<RegistrationDTO>();
                     }
                     
                    this.listAccount.add(dto);
                }
                
                return this.listAccount;
            }
            return null;
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
    
    public boolean delete(String dUsername) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBUtils.makeConnection();
            
            if(con!=null){
                String sql = "DELETE FROM Registration WHERE username=?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, dUsername);
                
                int row = stm.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        }
        finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean update(String password, String lastname, boolean role, String username) 
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBUtils.makeConnection();
            
            if(con!=null){
                StringBuilder sql = new StringBuilder("UPDATE Registration");
                sql.append(" SET password=?, lastname=?, isAdmin=?");
                sql.append(" WHERE username=?");
                
                stm = con.prepareStatement(sql.toString());
                stm.setString(1, password);
                stm.setString(2, lastname);
                stm.setBoolean(3, role);
                stm.setString(4, username);
                
                int row = stm.executeUpdate();
                if(row>0){
                    return true;
                }
            }
        }
        finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
}
