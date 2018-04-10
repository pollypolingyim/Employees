package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public void addEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date);
	public void updateEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date);
	public void deleteEmployee(int emp_no);
	//TODO: add deleteEmployeeBy...
}
