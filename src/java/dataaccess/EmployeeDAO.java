package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.Employee;

/**
 * This is an interface for the Employee DAO
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface EmployeeDAO {

    /**
     * This method is used to retrieve a list of all employees.
     *
     * @return List of generic type {@link Employee} objects
     */
    public List<Employee> getAllEmployees();

    /**
     * This method is used when adding an employee.
     *
     * @param emp of type {@link Employee}
     */
    public void addEmployee(Employee emp);

    /**
     * This method is used to update the employee table,
     *
     * @param emp of type {@link Employee}
     * @param newFirstName of type String
     */
    public void updateEmployeeFirstName(Employee emp, String newFirstName);

    /**
     * This method is used to update the {@link Employee} objects.
     *
     * @param emp of type {@link Employee}
     * @param newLastName of type String
     */
    public void updateEmployeeLastName(Employee emp, String newLastName);

    /**
     * This method is used to delete employee by employee number
     *
     * @param emp_no of type integer
     */
    public void deleteEmployeeByID(int emp_no);

    /**
     * This method finds {@link Employee} by name.
     *
     * @param first_name of type String
     * @param last_name of type String
     * @return ResultSet
     */
    public ResultSet findEmployeeByName(String first_name, String last_name);

    /**
     * This method finds {@link Employee} by employee number.
     *
     * @param emp_no of type integer
     * @return ResultSet
     */
    public ResultSet findEmployeeByID(int emp_no);
}
