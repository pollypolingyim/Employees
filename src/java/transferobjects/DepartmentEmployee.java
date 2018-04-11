package transfer_object;

import java.sql.Date;

public class DepartmentEmployee {
	private  final int dept_no;
	private final int emp_no;
	private Date from_date;
	private Date to_date;
	
	public DepartmentEmployee(int dept_no, int emp_no, Date from_date, Date to_date) {
		this.dept_no = dept_no;
		this.emp_no = emp_no;
		setFrom_date(from_date);
		setTo_date(to_date);
	}

	public int getDept_no() {
		return dept_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
}
