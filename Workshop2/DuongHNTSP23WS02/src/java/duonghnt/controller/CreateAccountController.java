/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonghnt.controller;

import duonghnt.errors.ErrorDTO;
import duonghnt.registration.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class CreateAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String ERRORDISPLAY = "createNewAccount.jsp";
    private String LOGINPAGE = "login.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtFullname");
            
            boolean errors =  false;
            ErrorDTO errObj = new ErrorDTO();
            if(username.length()<6 || username.length()>20){
                errors = true;
                errObj.setUsernameLengthErr("Username phai tu 6 den 20 ky tu");
            }
            if(password.length()<5 || password.length()>20){
                errors = true;
                errObj.setPasswordLengthErr("Password phai tu 5 den 20 ky tu");
            }else if(!confirm.equals(password)){
                errors = true;
                errObj.setConfirmErr("Password khong giong confirm");
            }
            if(fullname.length()<2 || fullname.length()>50){
                errors = true;
                errObj.setFullnameLengthErr("Fullname phai tu 2 den 50 ky tu");
            }
            
            request.setAttribute("ERRORS", errObj);
            String url = ERRORDISPLAY;
            System.out.println("CHECK!");
            if(!errors){
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.createAccount(username, password, fullname);
                
                if(result){
                    url = LOGINPAGE;
                }else{
                    errObj.setAccountExistedErr(username+" da ton tai");
                    request.setAttribute("ERRORS", errObj);
                }
            }
            
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch(SQLException|NamingException e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
