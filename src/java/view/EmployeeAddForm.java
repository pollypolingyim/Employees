/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.DepartmentEmployeeLogic;
import business.DepartmentLogic;
import business.DepartmentManagerLogic;
import business.EmployeeLogic;
import business.SalaryLogic;
import business.TitleLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Department;
import transferobjects.DepartmentEmployee;
import transferobjects.DepartmentManager;
import transferobjects.Employee;
import transferobjects.Salary;
import transferobjects.Title;

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
        DepartmentLogic deptLogic = new DepartmentLogic();
        List<Department> deptList = deptLogic.getAllDepartments();
        TitleLogic titleLogic = new TitleLogic();
        List<Title> titleList = titleLogic.getAllDistinctTitles();
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
            out.println("<h2>Employee Information</h2>");
            out.println("<form action=\"\" method=\"post\">");
            out.println("First name*:<br>");
            out.println("<input type=\"text\" name=\""+Employee.COL_FIRST_NAME+"\" required><br>");
            out.println("Last name*:<br>");
            out.println("<input type=\"text\" name=\""+Employee.COL_LAST_NAME+"\" required><br><br>");
            out.println("Birthdate*:<br>");
            out.println("<input type=\"date\" name=\""+Employee.COL_BIRTH_DATE+"\" min=\"1900-01-01\" max=\"2007-12-30\" required><br><br>");
            out.println("Gender*:<br>");
            out.println("<input type=\"radio\" name=\""+Employee.COL_GENDER+"\" value=\"M\" checked> Male<br>");
            out.println("<input type=\"radio\" name=\""+Employee.COL_GENDER+"\" value=\"F\"> Female<br><br>");
            out.println("Hire Date*:<br>");
            out.println("<input type=\"date\" name=\""+Employee.COL_HIRE_DATE+"\" min=\"1900-01-01\" max=\"2007-12-30\" required><br><br>");
            out.println("<h4>Department</h4>");
            out.println("For Which Department*:<br>");
            out.println("<select name=\""+DepartmentEmployee.COL_DEPT_NO+"\">");
            deptList.forEach((dept)-> out.println("<option value=\""+dept.getDept_no()+"\">"+dept.getDept_name()+"</option>"));
            out.println("</select><br><br>");
            out.println("From Date*:<br>");
            out.println("<input type=\"date\" name=\""+DepartmentEmployee.COL_FROM_DATE+"\" ><br><br>");
            out.println("To Date:<br>");
            out.println("<input type=\"date\" name=\""+DepartmentEmployee.COL_TO_DATE+"\"><br><br>");
            out.println("<h4>Title</h4>");
            out.println("What Title*:<br>");
            out.println("<select name=\""+Title.COL_TITLE+"\">");
            titleList.forEach((title)-> out.println("<option value=\""+title.getTitle()+"\">"+title.getTitle()+"</option>"));
            out.println("</select><br><br>");
            out.println("From Date*:<br>");
            out.println("<input type=\"date\" name=\""+Title.COL_FROM_DATE+"\" ><br><br>");
            out.println("To Date:<br>");
            out.println("<input type=\"date\" name=\""+Title.COL_TO_DATE+"\"><br><br>");
            out.println("<h4>Salary</h4>");
            out.println("Making how much($)*: <br>");
            out.println("<input type=\"text\" name=\""+Salary.COL_SALARY+"\" required><br><br>");
            out.println("From Date*:<br>");
            out.println("<input type=\"date\" name=\""+Salary.COL_FROM_DATE+"\" required><br><br>");
            out.println("To Date*:<br>");
            out.println("<input type=\"date\" name=\""+Salary.COL_TO_DATE+"\" required><br><br>");
            out.println("<h4>Department Manager</h4>");
            out.println("<input type=\"checkbox\" name=\"DepartmentManager\" value=\"checked\">Department Manager?</input><br><br>");
            out.println("Manager for what Department:<br>");
            out.println("<select name=\""+DepartmentManager.COL_DEPT_NO+"\">");
            deptList.forEach((dept)-> out.println("<option value=\""+dept.getDept_no()+"\">"+dept.getDept_name()+"</option>"));
            out.println("</select><br><br>");
            out.println("From Date:<br>");
            out.println("<input type=\"date\" name=\""+DepartmentManager.COL_FROM_DATE+"\" ><br><br>");
            out.println("To Date:<br>");
            out.println("<input type=\"date\" name=\""+DepartmentManager.COL_TO_DATE+"\"><br><br>");
            out.println("*required<br><br>");
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
        EmployeeLogic empLogic = new EmployeeLogic();
        SalaryLogic salLogic = new SalaryLogic();
        TitleLogic titleLogic = new TitleLogic();
        DepartmentManagerLogic deptManLogic = new DepartmentManagerLogic();
        DepartmentEmployeeLogic empDeptLogic = new DepartmentEmployeeLogic();
        
        Employee employee = new Employee(
                Date.valueOf(values.get(Employee.COL_BIRTH_DATE)[0]),
                values.get(Employee.COL_FIRST_NAME)[0],
                values.get(Employee.COL_LAST_NAME)[0],
                values.get(Employee.COL_GENDER)[0],
                Date.valueOf(values.get(Employee.COL_HIRE_DATE)[0]));
        empLogic.addEmployee(employee);
        DepartmentEmployee deptEmp = new DepartmentEmployee(
                values.get(DepartmentEmployee.COL_DEPT_NO)[0],
                employee.getEmp_no(),
                Date.valueOf(values.get(DepartmentEmployee.COL_FROM_DATE)[0]),
                Date.valueOf(values.get(DepartmentEmployee.COL_TO_DATE)[0]));
        empDeptLogic.addDepartmentEmployee(deptEmp);
        Title title = new Title(
                employee.getEmp_no(),
                values.get(Title.COL_TITLE)[0],
                Date.valueOf(values.get(Salary.COL_FROM_DATE)[1]),
                Date.valueOf(values.get(Salary.COL_TO_DATE)[1]));
        titleLogic.addTitle(title);
        Salary salary = new Salary(
                Integer.parseInt(values.get(Salary.COL_SALARY)[0]),
                employee.getEmp_no(),
                Date.valueOf(values.get(Salary.COL_FROM_DATE)[2]),
                Date.valueOf(values.get(Salary.COL_TO_DATE)[2]));
        salLogic.addSalary(salary);
        if(values.get("DepartmentManager") != null)
        {
            DepartmentManager deptMan = new DepartmentManager(
                    employee.getEmp_no(),
                    values.get(DepartmentManager.COL_DEPT_NO)[1],
                    Date.valueOf(values.get(Salary.COL_FROM_DATE)[3]),
                    Date.valueOf(values.get(Salary.COL_TO_DATE)[3]));
            deptManLogic.addDepartmentManager(deptMan);
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
