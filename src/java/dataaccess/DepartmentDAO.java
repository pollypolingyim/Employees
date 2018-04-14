package dataaccess;

import java.util.List;
import java.sql.ResultSet;

import transferobjects.Department;
/**
 * This is an interface for the Department DAO
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov 
 *
 */
public interface DepartmentDAO {
	/**
	 * This method is used to retrieve a list of all departments.
	 * @return List of generic type <Departments>
	 */
	public List<Department> getAllDepartments();
	/**
	 * This method is used when adding a department.
	 * @param dept_no of type integer
	 * @param dept_name of type String
	 */
	public void addDepartment(Department department);
	/**
	 * This method is used to update the department table.
	 * @param dept_no of type integer
	 * @param dept_name of type String
         *  
	 */
	public void updateDepartment(Department department, String newDeptName);
	/**
	 * This method is used to delete departments by department number.
	 * @param dept_no of type integer
	 */
	public void deleteDepartmentByDeptNo(int dept_no);
	/**
	 * This method is use to delete departments by name.
	 * @param dept_name of type String
	 */
	public void deleteDepartmentByDeptName(String dept_name);
        
        public ResultSet getDepartmentByID (int dept_no);
        
        public ResultSet getDepartmentByName(String dept_name);
}
