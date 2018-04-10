package data_access;

import java.util.List;

import transfer_object.Department;
/**
 * This is an interface for the Department DAO
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov 
 *
 */
public interface DepartmentDAO {
	/**
	 * This method is used to store a list of the departments
	 * @return List of generic type <Departments>
	 */
	public List<Department> getAllDepartments();
	/**
	 * This method is used when adding a department.
	 * @param dept_no of type integer
	 * @param dept_name of type String
	 */
	public void addDepartment(int dept_no, String dept_name);
	/**
	 * This method is used to update the department table.
	 * @param dept_no of type integer
	 * @param dept_name of type String
	 */
	public void updateDepartment(int dept_no, String dept_name);
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
}
