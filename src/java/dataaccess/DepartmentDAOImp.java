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
 * This class implements the {@link DepartmentDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 *
 */
public class DepartmentDAOImp implements DepartmentDAO {

    private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments ORDER BY dept_no LIMIT 100";
    private static final String INSERT_DEPARTMENTS = "INSERT INTO Departments (dept_no, dept_name) VALUES(?, ?)";
    private static final String DELETE_DEPARTMENTS_BY_ID = "DELETE FROM Departments WHERE dept_no = ?";
    private static final String DELETE_DEPARTMENTS_BY_NAME = "DELETE FROM Departments WHERE dept_name=?";
    private static final String UPDATE_DEPARTMENTS = "UPDATE Departments SET dept_name = ? WHERE dept_no = ?";
    private static final String GET_BY_CODE_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments WHERE dept_no = ?";
    private static final String GET_BY_NAME_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments WHERE dept_name=?";

    /**
     * This method overrides the {@link DepartmentDAO} getAllDepartments method
     *
     * @return list of departments
     */
    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = Collections.EMPTY_LIST;
        Department dept;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_DEPARTMENTS);
            rs = pstmt.executeQuery();
            departments = new ArrayList<>(100);
            while (rs.next()) {
                dept = new Department(
                        rs.getString(Department.COL_DEPT_NO),
                        rs.getString(Department.COL_DEPT_NAME));
                departments.add(dept);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * This method overrides the {@link Department} addDepartment method.
     *
     * @param department of type {@link Department}
     */
    @Override
    public void addDepartment(Department department) {
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_DEPARTMENTS);){
            pstmt.setString(1, department.getDept_no()+"");
            pstmt.setString(2, department.getDept_name()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method overrides the {@link Department} updateDepartment method.
     *
     * @param department of type {@link Department}
     * @param newDeptName of type String
     */
    @Override
    public void updateDepartment(Department department, String newDeptName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method overrides the {@link Department} deleteDepartmentByDeptNo
     * method.
     *
     * @param dept_no of type integer
     */
    @Override
    public void deleteDepartmentByDeptNo(int dept_no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method overrides the {@link Department} deleteDepartmentByDeptNo
     * method.
     *
     * @param dept_name of type integer
     */
    @Override
    public void deleteDepartmentByDeptName(String dept_name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method overrides the {@link Department} getDepartmentByID method.
     *
     * @param dept_no of type integer
     * @return ResultSet
     */
    @Override
    public ResultSet getDepartmentByID(int dept_no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method overrides the {@link Department} getDepartmentByName method.
     *
     * @param dept_name of type integer
     * @return ResultSet
     */
    @Override
    public ResultSet getDepartmentByName(String dept_name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
