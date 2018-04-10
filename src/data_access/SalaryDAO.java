package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.Salary;

public interface SalaryDAO {
	public List<Salary> getAllSalaries();
	public void addSalary(int emp_no, int salary, Date from_date, Date to_date);
	public void updateSalary(int emp_no, int salary, Date from_date, Date to_date);
	public void deleteSalary(int emp_no, Date from_date);
	//TODO: add deleteSalaryBy...

}
