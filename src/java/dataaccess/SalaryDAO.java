package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.Salary;

/**
 * This is an interface for the Salary DAO
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface SalaryDAO {

    /**
     * This method is used to retrieve a list all salaries.
     *
     * @return List of generic type {@link Salary}
     */
    public List<Salary> getAllSalaries();

    /**
     * This method is used to add salary to the salary table.
     *
     * @param salary of type {@link Salary}
     */
    public void addSalary(Salary salary);

    /**
     * This method is used to update the salary table.
     *
     * @param salary of type {@link Salary}
     * @param newSalary of type integer
     */
    public void updateSalarySalary(Salary salary, int newSalary);

    /**
     * This method is used to update the salary table.
     * @param salary of type {@link Salary}
     * @param newFromDate of type Date
     */
    public void updateSalaryFromDate(Salary salary, Date newFromDate);

    /**
     * This method is used to update the salary table.
     * @param salary of type {@link Salary}
     * @param newToDate of type Date
     */
    public void updateSalaryToDate(Salary salary, Date newToDate);

    /**
     * This method is used to delete from the salary table.
     *
     * @param salary of type {@link Salary}
     */
    public void deleteSalary(Salary salary);

    /**
     * This method is used to get a salary by employee number.
     *
     * @param emp_no of type integer
     * @return ResultSet
     */
    public ResultSet getSalaryByEmpID(int emp_no);

    //TODO: add deleteSalaryBy...
}
