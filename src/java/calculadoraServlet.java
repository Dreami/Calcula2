/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maple
 */
@WebServlet(urlPatterns = {"/calculadoraServlet"})
public class calculadoraServlet extends HttpServlet {

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
            int n1 = 0, n2 = 0, result = 0;
            String operation = request.getParameter("operacion");
            if(!request.getParameter("n1").equals("") && !request.getParameter("n2").equals("")) {
                try {
                    n1 = Integer.parseInt(request.getParameter("n1"));
                    n2 = Integer.parseInt(request.getParameter("n2"));
                } catch (Exception e) { 
                    try (PrintWriter out = response.getWriter()) {
                        printServletMessage("Limitese a ingresar solamente numeros enteros.", response);
                    }
                }
                
                switch (operation) {
                    case "sumado" :
                        result = n1 + n2;
                        break;
                    case "restado" :
                        result = n1 - n2;
                        break;
                    case "multiplicado" :
                        result = n1 * n2;
                        break;
                    case "dividido" :
                        result = n1 / n2;
                        break;
                    default: 
                        result = 0;
                        break;
                }
                printServletMessage("El resultado de " + n1 + " " + operation + " a " + n2 + " = " + result, response);
            } else {
                printServletMessage("Por favor ingrese numeros.", response);
            }
    }
    
    private void printServletMessage(String msg, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>"); 
                    out.println("<head>");
                    out.println("<title>Servlet calculadoraServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + msg + "</h1>");
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
