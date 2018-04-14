package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import transferobjects.DepartmentEmployee;


/**
 * This class implements the {@link DepartmentEmployeeEmployeeDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class DepartmentEmployeeDAOImp implements DepartmentEmployeeDAO {
   private static final String GET_ALL_DEPARTMENT_EMPLOYEE = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp ORDER BY dept_no, emp_no";
    private static final String INSERT_DEPARTMENT_EMPLOYEE = "INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date) VALUES(?, ?,?,?)";
    private static final String DELETE_DEPARTMENT_EMPLOYEE = "DELETE FROM dept_emp WHERE dept_no = ? AND emp_no=?";
    private static final String UPDATE_DEPARTMENT_EMPLOYEE_FROM_DATE = "UPDATE dept_emp SET from_date = ?  WHERE dept_no = ? AND emp_no=?";
    private static final String UPDATE_DEPARTMENT_EMPLOYEE_TO_DATE ="UPDATE dept_emp SET to_date=? WHERE dept_no=? AND emp_no=?";
    private static final String GET_BY_DEPARTMENT_ID_DEPARTMENT_EMPLOYEE = "SELECT dept_no, dept_name, from_date, to_date FROM dept_emp WHERE dept_no = ?";
    private static final String GET_BY_EMP_ID_DEPARTMENT_EMPLOYEE="SELECT dept_no, dept_name, from_date, to_date FROM dept_emp WHERE emp_no=?";
    
    @Override
    public List<DepartmentEmployee> getAllDepartmentEmployees() {
        List<DepartmentEmployee> departmentEmployees = Collections.EMPTY_LIST;
        DepartmentEmployee departmentEmployee;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_EMPLOYEE);
            rs = pstmt.executeQuery();
            departmentEmployees= new ArrayList<>();
            while( rs.next()){
                departmentEmployee = new DepartmentEmployee();
                departmentEmployee.setDept_no( rs.getString("dept_no"));
                departmentEmployee.setEmp_no( rs.getInt("emp_no"));
                departmentEmployee.setFrom_date(rs.getDate("from_date"));
                departmentEmployee.setTo_date(rs.getDate("to_date"));
                
                departmentEmployees.add(departmentEmployee);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
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
        return departmentEmployees;
    }

   @Override
    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_DEPARTMENT_EMPLOYEE);){
            pstmt.setString(1, departmentEmployee.getEmp_no()+"");
            pstmt.setString(2, departmentEmployee.getDept_no()+"");
            pstmt.setString(3, departmentEmployee.getFrom_date()+"");
            pstmt.setString(4, departmentEmployee.getTo_date()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateDepartmentEmployeeFromDate(DepartmentEmployee departmentEmployee, Date newFromDate){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_DEPARTMENT_EMPLOYEE_FROM_DATE);){
            pstmt.setString(1, newFromDate+"");
            pstmt.setString(2,departmentEmployee.getDept_no()+"");
            pstmt.setString(3, departmentEmployee.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
       @Override
    public void updateDepartmentEmployeeToDate(DepartmentEmployee departmentEmployee, Date newToDate){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_DEPARTMENT_EMPLOYEE_TO_DATE);){
            pstmt.setString(1, newToDate+"");
            pstmt.setString(2,departmentEmployee.getDept_no()+"");
            pstmt.setString(3, departmentEmployee.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
    /**
     * This method is used to delete departments by department number.
     * @param dept_no of type integer
     */
    @Override
    public void deleteDepartmentEmployee(DepartmentEmployee departmentEmployee){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_DEPARTMENT_EMPLOYEE);){
            pstmt.setString(1, departmentEmployee.getDept_no()+"");
            pstmt.setString(2, departmentEmployee.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }         
    }
    
   
    
    @Override
    public ResultSet getDepartmentEmployeeByDeptID (int dept_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_DEPARTMENT_ID_DEPARTMENT_EMPLOYEE);){
            pstmt.setString(1, dept_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    @Override
    public ResultSet getDepartmentEmployeeByEmpID (int emp_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_EMP_ID_DEPARTMENT_EMPLOYEE);){
            pstmt.setString(1, emp_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentEmployeeDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }


}
