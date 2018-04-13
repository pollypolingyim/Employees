package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.Salary;
/**
 * This class implements the {@link SalaryDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class SalaryDAOImp implements SalaryDAO {
    /**
     * This method overrides the {@link SalaryDAO} getAllSalaries method.
     *
     * @return list of Salary objects
     */
	@Override
	public List<Salary> getAllSalaries() {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * This method overrides the {@link SalaryDAO} addSalary method.
     *
     * @param emp_no of type integer
     * @param salary of type integer
     * @param from_date of reference type Date
     * @param to_date of reference type Date
     */
	@Override
	public void addSalary(int emp_no, int salary, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link SalaryDAO} updateSalary method.
     *
     * @param emp_no of type integer
     * @param salary of type integer
     * @param from_date of reference type Date
     * @param to_date of reference type Date
     */
	@Override
	public void updateSalary(int emp_no, int salary, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link SalaryDAO} deleteSalary method.
     *
     * @param emp_no of type integer
     * @param from_date of reference type Date
     */
	@Override
	public void deleteSalary(int emp_no, Date from_date) {
		// TODO Auto-generated method stub

	}

}
