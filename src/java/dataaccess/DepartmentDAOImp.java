package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Department;

/**
 *
 * @author Shawn
 */
public class DepartmentDAOImp implements DepartmentDAO{

    private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_dept_name FROM Departments ORDER BY dept_no";
    private static final String INSERT_DEPARTMENTS = "INSERT INTO Departments (dept_no, dept_dept_name) VALUES(?, ?)";
    private static final String DELETE_DEPARTMENTS_BY_ID = "DELETE FROM Departments WHERE dept_no = ?";
    private static final String DELETE_DEPARTMENTS_BY_NAME = "DELETE FROM Departments WHERE dept_name=?";
    private static final String UPDATE_DEPARTMENTS = "UPDATE Departments SET dept_name = ? WHERE dept_no = ?";
    private static final String GET_BY_CODE_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments WHERE dept_no = ?";
    private static final String GET_BY_NAME_DEPARTMENTS="SELECT dept_no, dept_name FROM Departments WHERE dept_name=?";
    
    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = Collections.EMPTY_LIST;
        Department department;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENTS);
            rs = pstmt.executeQuery();
            departments = new ArrayList<>();
            while( rs.next()){
                department = new Department();
                //department.setDept_no( rs.getString("dept_no"));
                department.setDept_name( rs.getString("dept_name"));
                departments.add(department);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
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
        return departments;
    }

    @Override
    public void addDepartment(Department department) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_DEPARTMENTS);){
            pstmt.setString(1, department.getDept_no());
            pstmt.setString(2, department.getDept_name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateDepartment(Department department, String newDeptName){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_DEPARTMENTS);){
            pstmt.setString(1, newDeptName);
            pstmt.setString(2, department.getDept_no());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
      
    }
    
    /**
     * This method is used to delete departments by department number.
     * @param dept_no of type integer
     */
    @Override
    public void deleteDepartmentByDeptNo(int dept_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_DEPARTMENTS_BY_ID);){
            pstmt.setString(1, dept_no+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }         
    }
    
    /**
     * This method is use to delete departments by name.
     * @param dept_name of type String
     */
    @Override
    public void deleteDepartmentByDeptName(String dept_name){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_DEPARTMENTS_BY_NAME);){
            pstmt.setString(1, dept_name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public ResultSet getDepartmentByID (int dept_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_CODE_DEPARTMENTS);){
            pstmt.setString(1, dept_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    @Override
    public ResultSet getDepartmentByName(String dept_name){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_NAME_DEPARTMENTS);){
            pstmt.setString(1, dept_name);
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    

}
