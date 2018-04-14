package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

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
	public List<DepartmentEmployee> getAllDepartmentEmployees();
	/**
	 * This method is used when adding a department employee.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addDepartmentEmployee(DepartmentEmployee departmentEmployee);
	/**
	 * This method is used to update the department employee table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateDepartmentEmployeeFromDate(DepartmentEmployee departmentEmployee, Date newFromDate);
	/**
	 * This method is used to delete from the department employee table.
	 * @param emp_no of type integer
	 * @param dept_no of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
        
        public void updateDepartmentEmployeeToDate (DepartmentEmployee departmentEmployee, Date newToDate);
	public void deleteDepartmentEmployee(DepartmentEmployee departmentEmployee);
        
        public ResultSet getDepartmentEmployeeByDeptID (int dept_no);
        
        public ResultSet getDepartmentEmployeeByEmpID(int emp_id);
}

