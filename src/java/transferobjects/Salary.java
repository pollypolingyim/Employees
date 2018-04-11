package transferobjects;

import java.sql.Date;

public class Salary {
	private final int emp_no;
	private int salary;
	private final Date from_date;
	private Date to_date;
	
	public Salary(int emp_no, int salary, Date from_date, Date to_date) {
		this.emp_no = emp_no;
		this.setSalary(salary);
		this.from_date = from_date;
		this.setTo_date(to_date);
	}

	public int getEmp_no() {
		return emp_no;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	
}
