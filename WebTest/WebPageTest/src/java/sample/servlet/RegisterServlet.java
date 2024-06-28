/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.RegisterDAO;
import sample.dao.SearchDAO;
import sample.model.ErrorModel;
import sample.utils.Tools;

/**
 *
 * @author ASUS
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOGINPAGE = "login.jsp";
    private static final String REGISTERPAGE = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean check = false;
        String url = "";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String fullname = request.getParameter("txtFullname");
            String email = request.getParameter("txtEmail");
            String repeatPassword = request.getParameter("txtRepeatPass");

            ErrorModel error = new ErrorModel();
            SearchDAO search = new SearchDAO();

            if (search.search(username)) { //Check username existance
                error.setDupplicatedUsernameError("This Username has already existed!");
                check = true;
            } else {
                if (username.length() < 5 || username.length() > 20) {
                    error.setUsernameLengthError("Invalid username.");
                    check = true;
                }
                if (password.isEmpty()) {           //
                    error.setPasswordFormatError("Password cannot empty.");
                    check = true;
                } else {
                    if (!Tools.checkPasswordFormat(password)) {
                        error.setPasswordFormatError("Invalid Password.");
                        check = true;
                    } else if (!repeatPassword.equals(password)) { //Check is repeated password matched
                        error.setConfirmError("Repeated Password is not matched!");
                        check = true;
                    }
                }

                if (fullname.isEmpty()) {
                    error.setFullNameLengthError("Full Name connot be empty.");
                    check = true;
                }
                if (email.isEmpty()) {
                    error.setEmailError("Email cannot be empty.");
                    check = true;
                } else if (!Tools.checkEmailFormat(email)) {
                    error.setEmailError("Invalid Email.");
                    check = true;
                }

            }

            if (!check) {
                url = LOGINPAGE;
            } else {
                url = REGISTERPAGE;
                request.setAttribute("ERROR", error);
            }

            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            out.close();
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
