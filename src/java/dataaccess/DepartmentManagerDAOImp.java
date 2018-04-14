package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import transferobjects.DepartmentManager;

/**
 * This class implements the {@link DepartmentManagerDAO} interface.
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov 
 */
public class DepartmentManagerDAOImp implements DepartmentManagerDAO {
   private static final String GET_ALL_DEPARTMENT_MANAGER = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp ORDER BY dept_no, emp_no LIMIT 100";
    private static final String INSERT_DEPARTMENT_MANAGER = "INSERT INTO dept_manager (emp_no, dept_no, from_date, to_date) VALUES(?, ?,?,?)";
    private static final String DELETE_DEPARTMENT_MANAGER = "DELETE FROM dept_manager WHERE dept_no = ? AND emp_no=?";
    private static final String UPDATE_DEPARTMENT_MANAGER_FROM_DATE = "UPDATE dept_manager SET from_date = ?  WHERE dept_no = ? AND emp_no=?";
    private static final String UPDATE_DEPARTMENT_MANAGER_TO_DATE="UPDATE dept_manager SET to_date=? WHERE dept_no=? AND emp_no=?";
    private static final String GET_BY_DEPARTMENT_ID_DEPARTMENT_MANAGER = "SELECT dept_no, dept_name, from_date, to_date FROM dept_emp WHERE dept_no = ?";
    private static final String GET_BY_EMP_ID_DEPARTMENT_MANAGER="SELECT dept_no, dept_name, from_date, to_date FROM dept_emp WHERE emp_no=?";
    
    @Override
    public List<DepartmentManager> getAllDepartmentManagers() {
        List<DepartmentManager> departmentManagers = Collections.EMPTY_LIST;
        DepartmentManager departmentManager;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_MANAGER);
            rs = pstmt.executeQuery();
            departmentManagers= new ArrayList<>();
            while( rs.next()){
                departmentManager = new DepartmentManager(
                        rs.getInt("emp_no"),
                        rs.getString("dept_no"),
                        rs.getDate("from_date"),
                        rs.getDate("to_date"));
                
                departmentManagers.add(departmentManager);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
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
        return departmentManagers;
    }

   @Override
    public void addDepartmentManager(DepartmentManager departmentManager) {
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_DEPARTMENT_MANAGER);){
            pstmt.setString(1, departmentManager.getEmp_no()+"");
            pstmt.setString(2, departmentManager.getDept_no()+"");
            pstmt.setString(3, departmentManager.getFrom_date()+"");
            pstmt.setString(4, departmentManager.getTo_date()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateDepartmentManagerFromDate(DepartmentManager departmentManager, Date newFromDate){
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_DEPARTMENT_MANAGER_FROM_DATE);){
            pstmt.setString(1, newFromDate+"");
            pstmt.setString(2,departmentManager.getDept_no()+"");
            pstmt.setString(3, departmentManager.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void updateDepartmentManagerToDate(DepartmentManager departmentManager, Date newToDate){
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_DEPARTMENT_MANAGER_TO_DATE);){
            pstmt.setString(1, newToDate+"");
            pstmt.setString(2,departmentManager.getDept_no()+"");
            pstmt.setString(3, departmentManager.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * This method is used to delete departments by department number.
     * @param dept_no of type integer
     */
    @Override
    public void deleteDepartmentManager(DepartmentManager departmentManager){
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_DEPARTMENT_MANAGER);){
            pstmt.setString(1, departmentManager.getDept_no()+"");
            pstmt.setString(2, departmentManager.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }         
    }
    
   
    
    @Override
    public ResultSet getDepartmentManagerByDeptID (int dept_no){
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_DEPARTMENT_ID_DEPARTMENT_MANAGER);){
            pstmt.setString(1, dept_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManagerDAOImp.class.getName()).log(Level.SEVERE, "", ex);
        } 
        return null;
    }
    
    @Override
    public ResultSet getDepartmentManagerByEmpID (int emp_no){
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_EMP_ID_DEPARTMENT_MANAGER);){
            pstmt.setString(1, emp_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(DepartmentManagerDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
