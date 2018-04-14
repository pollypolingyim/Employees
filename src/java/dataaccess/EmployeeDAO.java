package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.Employee;
/**
 * This is an interface for the Employee DAO
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface EmployeeDAO {
	/**
	 * This method is used to retrieve a list all employees.
	 * @return List of generic type <Employee>
	 */
	public List<Employee> getAllEmployees();
	/**
	 * This method is used when adding an employee.
	 * @param emp_no of type integer
	 * @param birth_date of reference type Date
	 * @param first_name of type String
	 * @param last_name of type String
	 * @param gender of type String
	 * @param hire_date of reference type Date
	 */
	public void addEmployee(Employee emp);
	/**
	 * This method is used to update the employee table,
	 * @param emp_no of type integer
	 * @param birth_date of reference type Date
	 * @param first_name of type String
	 * @param last_name of type String
	 * @param gender of type String
	 * @param hire_date of reference type Date
	 */
	public void updateEmployeeFirstName(Employee emp, String newFirstName);
        
        public void updateEmployeeLastName(Employee emp, String newLastName);
	/**
	 * This method is used to delete employee by employee number
	 * @param emp_no of type integer
	 */
	public void deleteEmployeeByID(int emp_no);
        
        
        public ResultSet findEmployeeByName(String first_name, String last_name);
        
        public ResultSet findEmployeeByID(int emp_no);
	//TODO: add deleteEmployeeBy...
}
