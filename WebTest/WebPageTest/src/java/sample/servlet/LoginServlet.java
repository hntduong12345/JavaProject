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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.LoginDAO;
import sample.model.ErrorModel;
import sample.model.UserModel;

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {

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
    private static final String ADMINPAGE = "admin.jsp";
    private static final String WELCOMEPAGE = "welcome.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            LoginDAO lg = new LoginDAO();
            String result = lg.checkLogin(username, password);
            
            //Check authorization.
            if (result != null) {
                if (result.equals("admin")) {
                    url = ADMINPAGE;
                } else {
                    url = WELCOMEPAGE;
                }
                //Create cookie.
                Cookie cookie = new Cookie(username, password);
                cookie.setMaxAge(60*5);
                response.addCookie(cookie);
                response.sendRedirect(url);
            } else {
                url = LOGINPAGE;
                ErrorModel error = new ErrorModel();
                error.setAuthorizationError("Invalid Username or Password!");
                request.setAttribute("ERROR", error);
                request.getRequestDispatcher(url).forward(request, response);
            }

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
