/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class SessionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SessionServlet at " + request.getContextPath() + "</h1>");
            
            HttpSession session = request.getSession();
            String heading;
            Integer accessCount = (Integer) session.getAttribute("accessCount");
            if(accessCount == null){
                accessCount = new Integer(0);
                heading = "Welcome Session Tracking";
            }
            else{
                heading = "Comeback";
                accessCount = new Integer(accessCount.intValue()+1);
            }
            
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            out.println("<h2>" + heading + "</h2>");      
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Info Type</th>");
            out.println("<th>" + session.getId() + "</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>Create time:</td>");
            out.println("<td>" + new Date(session.getCreationTime()) + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Last time access:</td>");
            out.println("<td>" + new Date(session.getLastAccessedTime()) + "</td>");
            out.println("</tr>");
            out.println("<td>Access count:</td>");
            out.println("<td>" + accessCount + "</td>");
            out.println("</tr>");
            out.println("<td>Session time out:</td>");
            out.println("<td>" + session.getMaxInactiveInterval() + "</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
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
