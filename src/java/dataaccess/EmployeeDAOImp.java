package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.Employee;
/**
 * This class implements the {@link EmployeeDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class EmployeeDAOImp implements EmployeeDAO {
    /**
     * This method overrides the {@link EmployeeDAO} getAllEmployees method.
     *
     * @return list of Employee objects
     */
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * This method overrides the {@link EmployeeDAO} addEmployee method.
     *
     * @param emp_no of type integer
     * @param birth_date of reference type Date
     * @param first_name of type String
     * @param last_name of type String
     * @param gender of type String
     * @param hire_date of reference type Date
     */
	@Override
	public void addEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender,
			Date hire_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link EmployeeDAO} updateEmployee method.
     *
     * @param emp_no of type integer
     * @param birth_date of reference type Date
     * @param first_name of type String
     * @param last_name of type String
     * @param gender of type String
     * @param hire_date of reference type Date
     */
	@Override
	public void updateEmployee(int emp_no, Date birth_date, String first_name, String last_name, String gender,
			Date hire_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link EmployeeDAO} deleteEmployee method.
     *
     * @param emp_no of type integer
     */
	@Override
	public void deleteEmployee(int emp_no) {
		// TODO Auto-generated method stub

	}

}
