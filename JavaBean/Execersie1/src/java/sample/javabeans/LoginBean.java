/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.javabeans;

import java.io.Serializable;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.registration.RegistrationDAO;

/**
 *
 * @author ASUS
 */
public class LoginBean implements Serializable{
    private String username;
    private String password;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean checkLogin(){
        try{
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.checkLogin(username, password);
        return result;
        }
        catch(SQLException | NamingException e){
            e.printStackTrace();
        }
        return false;
    }
}
