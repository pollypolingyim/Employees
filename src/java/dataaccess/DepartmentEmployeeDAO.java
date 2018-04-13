package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.DepartmentEmployee;
	/**
	 * This is an interface for the DepartmentEmployee DAO
	 * @author Shawn Pottle
	 * @author Polly Yim
	 * @author Aleksandar Krumov
	 */
public interface DepartmentEmployeeDAO {
	/**
	 * This method is used to retrieve a list of all department employees.
	 * @return List of generic type <DepartmentEmployee>
	 */
	public List<DepartmentEmployee> getAllDepartmentEmployee();
	/**
	 * This method is used when adding a department employee.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addDeparmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
	/**
	 * This method is used to update the department employee table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
	/**
	 * This method is used to delete from the department employee table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void deleteDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
}

