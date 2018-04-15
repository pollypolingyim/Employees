/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.EmployeeLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Employee;

/**
 *
 * @author kingselite
 */
public class EmployeeAddForm extends HttpServlet {

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
        if(request.getParameter("submit") != null) {
            addEmployee(request.getParameterMap());
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employee Add Form</title>");
            out.println("</head>");
            out.println("<body>");
            if(request.getParameter("submit") != null) {
                out.println("Employee Added!");
            }
            out.println("<form action=\"\" method=\"post\">");
            out.println("First name:<br>");
            out.println("<input type=\"text\" name=\"firstname\" required><br>");
            out.println("Last name:<br>");
            out.println("<input type=\"text\" name=\"lastname\" required><br><br>");
            out.println("<input type=\"date\" name=\"birthdate\" min=\"1900-01-01\" max=\"2007-12-30\" required><br><br>");
            out.println("<input type=\"radio\" name=\"gender\" value=\"M\" checked> Male<br>");
            out.println("<input type=\"radio\" name=\"gender\" value=\"F\"> Female<br>");
            out.println("<input type=\"date\" name=\"hiredate\" min=\"1900-01-01\" max=\"2007-12-30\" required><br><br>");
            out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("<pre>");
            out.println("Submitted keys and values:");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }
    
    private void addEmployee(Map<String, String[]> values) {
        EmployeeLogic logic = new EmployeeLogic();
        Employee employee = new Employee(
                0,
                Date.valueOf(values.get("birthdate")[0]),
                values.get("firstname")[0],
                values.get("lastname")[0],
                values.get("gender")[0],
                Date.valueOf(values.get("hiredate")[0]));

        logic.addEmployee(employee);
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
