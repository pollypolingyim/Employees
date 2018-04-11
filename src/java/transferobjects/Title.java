package transfer_object;

import java.sql.Date;

public class Title {
	private final int emp_no;
	private final String title;
	private final Date from_date;
	private Date to_date;
	
	public Title(int emp_no, String title, Date from_date) {
		this.emp_no = emp_no;
		this.title = title;
		this.from_date = from_date;
	}
	
	public Title(int emp_no, String title, Date from_date, Date to_date) {
		this.emp_no = emp_no;
		this.title = title;
		this.from_date = from_date;
		setTo_date(to_date);
	}

	public int getEmp_no() {
		return emp_no;
	}

	public String getTitle() {
		return title;
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
