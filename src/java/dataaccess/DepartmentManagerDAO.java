package dataaccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import transferobjects.DepartmentManager;
/**
 * This is an interface for the DepartmentManager DAO
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface DepartmentManagerDAO {
	/**
	 * This method is used to retrieve a list all department managers.
	 * @return List of generic type <DepartmentManager>
	 */
	public List<DepartmentManager> getAllDepartmentManagers();
	/**
	 * This method is used when adding a department manager.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addDepartmentManager(DepartmentManager departmentManager);
	/**
	 * This method is used to update the department manager table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateDepartmentManagerFromDate(DepartmentManager departmentManager, Date newFromDate);
        
        public void updateDepartmentManagerToDate(DepartmentManager departmentManager, Date newToDate);
	/**
	 * This method is used to delete from the department manager table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void deleteDepartmentManager(DepartmentManager departmentManager);
        
        public ResultSet getDepartmentManagerByDeptID (int dept_no);
        
        public ResultSet getDepartmentManagerByEmpID(int emp_no);
}
