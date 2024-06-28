/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonghnt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ASUS
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String LOGINPAGE = "login.html";
    private final String LOGINCONTROLLER = "LoginController";
    private final String SEARCHCONTROLLER = "SearchController";
    private final String DELETECONTROLLER = "DeleteController";
    private final String UPDATECONTROLLER = "UpdateController";
    private final String ADDTOCARTCONTROLLER = "AddItemsController";
    private final String VIEWCARTPAGE = "viewCart.jsp";
    private final String REMOVEFROMCART = "RemoveItemController";
    private final String CREATEACCOUNTCONTROLLER = "CreateAccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String action = request.getParameter("btAction");
            String url = LOGINPAGE;
            
            if(action.equals("Login")){
                url = LOGINCONTROLLER;
            }
            if(action.equals("Search")){
                url = SEARCHCONTROLLER;
            }
            if(action.equals("Delete")){
                url = DELETECONTROLLER;
            }
            if(action.equals("Update")){
                url = UPDATECONTROLLER;
            }
            if(action.equals("Add To Cart")){
                url = ADDTOCARTCONTROLLER;
            }
            if(action.equals("View Cart")){
                url = VIEWCARTPAGE;
            }
            if(action.equals("Remove Items")){
                url = REMOVEFROMCART;
            }
            if(action.equals("Create")){
                url = CREATEACCOUNTCONTROLLER;
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        finally{
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
