package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import transferobjects.Employee;

import transferobjects.Employee;
/**
 * This class implements the {@link EmployeeDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class EmployeeDAOImp implements EmployeeDAO {
    private static final String GET_ALL_EMPLOYEES = "SELECT emp_no, birth_date,first_name, last_name, gender, hire_date FROM Employees ORDER BY emp_no";
    private static final String INSERT_EMPLOYEES = "INSERT INTO Employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES(?,?,?,?,?, ?)";
    private static final String DELETE_EMPLOYEES_BY_ID = "DELETE FROM Employees WHERE emp_no = ?";
    private static final String UPDATE_EMPLOYEE_FIRST_NAME = "UPDATE Employees SET first_name = ? WHERE emp_no = ?";
    private static final String UPDATE_EMPLOYEE_LAST_NAME = "UPDATE Employees SET last_name = ? WHERE emp_no=?";
    private static final String GET_BY_CODE_EMPLOYEES = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM Employees WHERE emp_no = ?";
    private static final String GET_BY_NAME_EMPLOYEES ="SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM Employees WHERE frist_name=? AND last_name=?";
    
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = Collections.EMPTY_LIST;
        Employee employee;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_EMPLOYEES);
            rs = pstmt.executeQuery();
            employees = new ArrayList<>();
            while( rs.next()){
                employee = new Employee();
               // employee.setEmp_no( Integer.parseInt(rs.getString("emp_no")));
                employee.setFirst_name( rs.getString("first_name"));
                employee.setLast_name(rs.getString("last_name"));
                employee.setGender(rs.getString("gender"));
                employee.setHire_date (Date.valueOf(rs.getString("hire_date")));
                employees.add(employee);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_EMPLOYEES);){
            pstmt.setString(1, employee.getEmp_no()+"");
            pstmt.setString(2, employee.getFirst_name());
            pstmt.setString(3, employee.getLast_name());
            pstmt.setString(4, employee.getGender()+"");
            pstmt.setString(5, employee.getHire_date()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateEmployeeFirstName(Employee employee, String newFirstName){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_EMPLOYEE_FIRST_NAME);){
            pstmt.setString(1, newFirstName);
            pstmt.setString(2, employee.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
    @Override
    public void updateEmployeeLastName(Employee employee, String newLastName){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_EMPLOYEE_LAST_NAME);){
            pstmt.setString(1, newLastName);
            pstmt.setString(2, employee.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
    /**
     * This method is used to delete employees by employee number.
     * @param dept_no of type integer
     */
    @Override
    public void deleteEmployeeByID(int emp_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_EMPLOYEES_BY_ID);){
            pstmt.setString(1, emp_no+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }         
    }
    
   
    
    @Override
    public ResultSet findEmployeeByID (int emp_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_CODE_EMPLOYEES);){
            pstmt.setString(1, emp_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    @Override
    public ResultSet findEmployeeByName(String first_name, String last_name){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_NAME_EMPLOYEES);){
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }


}
