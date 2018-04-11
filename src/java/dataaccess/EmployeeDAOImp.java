package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.Employee;

public class EmployeeDAOImp implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender,
			Date hire_date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender,
			Date hire_date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(int emp_no) {
		// TODO Auto-generated method stub

	}

}
