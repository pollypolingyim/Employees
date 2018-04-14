package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.Salary;
/**
 * This is an interface for the Salary DAO
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface SalaryDAO {
	/**
	 * This method is used to retrieve a list all salaries.
	 * @return List of generic type <Employee>
	 */
	public List<Salary> getAllSalaries();
	/**
	 * This method is used to add salary to the salary table.
	 * @param emp_no of type integer
	 * @param salary of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addSalary(Salary salary);
	/**
	 * This method is used to update the salary table.
	 * @param emp_no of type integer
	 * @param salary of type integer
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
        public void updateSalarySalary(Salary salary, int newSalary);
	public void updateSalaryFromDate(Salary salary,Date newFromDate );
        public void updateSalaryToDate(Salary salary, Date newToDate);
	/**
	 * This method is used to delete from the salary table.
	 * @param emp_no of type integer
	 * @param from_date of reference type Date
	 */
	public void deleteSalary(Salary salary);
        public ResultSet getSalaryByEmpID (int emp_no);
        
	//TODO: add deleteSalaryBy...

}
