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
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov 
 *
 */
public class DepartmentDAOImp implements DepartmentDAO {

    
        private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_name FROM departments ORDER BY dept_no";
        private static final String INSERT_DEPARTMENTS = "INSERT INTO Courses (course_num, name) VALUES(?, ?)";
        private static final String DELETE_DEPARTMENTS = "DELETE FROM Courses WHERE course_num = ?";
        private static final String UPDATE_DEPARTMENTS = "UPDATE Courses SET name = ? WHERE course_num = ?";
        //private static final String GET_BY_CODE_COURSES = "SELECT course_num, name FROM Courses WHERE name = ?";
	
/**
 * This method overrides the {@link DepartmentDAO} getAllDepartments method
 * @return list of departments
 */
	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = Collections.EMPTY_LIST;
                Department dept;
                Connection con = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try{
                    System.out.println("Connecting");
                    DataSource ds = new DataSource();
                    con = ds.createConnection();
                    
                    System.out.println("Connected");
                    pstmt = con.prepareStatement( GET_ALL_DEPARTMENTS);
                    rs = pstmt.executeQuery();
                    departments = new ArrayList<>(100);
                    while( rs.next()){
                        dept = new Department(rs.getString("dept_no"),rs.getString("dept_name"));
                        departments.add(dept);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
 * This method overrides the {@link  DepartmentDAO} addDepartment method
 * @param dept_no of type integer
 * @param dept_name of type String
 */
	@Override
	public void addDepartment(int dept_no, String dept_name) {
		// TODO Auto-generated method stub

	}
/**
 * This method overrides the {@link  DepartmentDAO} updateDepartment method.
 * @param dept_no of type integer
 * @param dept_name of type String
 */
	@Override
	public void updateDepartment(int dept_no, String dept_name) {
		// TODO Auto-generated method stub

	}
/**
 * This method overrides the {@link  DepartmentDAO} deleteDepartmentByNo method.
 * @param dept_no of type integer
 */
	@Override
	public void deleteDepartmentByDeptNo(int dept_no) {
		// TODO Auto-generated method stub

	}
/**
 * This method overrides the {@link  DepartmentDAO} deleteDepartmentByName method.
 * @param dept_name of type String
 */
	@Override
	public void deleteDepartmentByDeptName(String dept_name) {
		// TODO Auto-generated method stub

	}

}
