/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.shopping;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.spring23.utils.DBUtils;

/**
 *
 * @author hd
 */
public class DAO implements Serializable{
//    your code here
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
    
    public List<Product> searchAll() throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBUtils.getConnection();
            
            if(con!=null){
                String sql = "SELECT * FROM tblProducts";
                
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    Product product = new Product(rs.getString("productID"), rs.getString("productName"),
                            rs.getString("description"), rs.getFloat("price"), rs.getBoolean("status"));
                    
                    if(this.products==null){
                        this.products = new ArrayList<Product>();
                    }
                    if(product.isStatus()){
                        this.products.add(product);
                    }
                }
                return this.products;
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
        return null;
    }
    
}