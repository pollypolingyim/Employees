package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.DepartmentEmployee;

/**
 * This is an interface for the DepartmentEmployee data access object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface DepartmentEmployeeDAO {

    /**
     * This method is used to retrieve a list of all department employees.
     *
     * @return List of generic type {@link DepartmentEmployee}
     */
    public List<DepartmentEmployee> getAllDepartmentEmployees();

    /**
     * This method is used when adding a department employee.
     *
     * @param departmentEmployee of type {@link DepartmentEmployee}
     */
    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee);

    /**
     * This method is used to update the department employee table.
     *
     * @param departmentEmployee of type {@link DepartmentEmployee}
     * @param newFromDate of type Date
     */
    public void updateDepartmentEmployeeFromDate(DepartmentEmployee departmentEmployee, Date newFromDate);

    /**
     * This method is used to update the {@link DepartmentEmployee} to_date.
     *
     * @param departmentEmployee of type {@link DepartmentEmployee}
     * @param newToDate of type Date
     */
    public void updateDepartmentEmployeeToDate(DepartmentEmployee departmentEmployee, Date newToDate);

    /**
     * This method is used to delete an {@link DepartmentEmployee}.
     *
     * @param departmentEmployee of type {@link DepartmentEmployee}
     */
    public void deleteDepartmentEmployee(DepartmentEmployee departmentEmployee);

    /**
     * This method retrieves a department employee by its ID
     *
     * @param dept_no of type String
     * @return ResultSet
     */
    public ResultSet getDepartmentEmployeeByDeptID(int dept_no);

    /**
     * This method gets a department employee by its employee number.
     *
     * @param emp_id of type integer
     * @return ResultSet
     */
    public ResultSet getDepartmentEmployeeByEmpID(int emp_id);
}
