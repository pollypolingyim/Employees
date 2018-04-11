package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.DepartmentManager;
/**
 * This is an interface for the DepartmentManager DAO
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov
 */
public interface DepartmentManagerDAO {
	/**
	 * This method is used to retrieve a list all department managers.
	 * @return List of generic type <DepartmentManager>
	 */
	public List<DepartmentManager> getAllDepartmentManager();
	/**
	 * This method is used when adding a department manager.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
	/**
	 * This method is used to update the department manager table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
	/**
	 * This method is used to delete from the department manager table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void deleteDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
}
