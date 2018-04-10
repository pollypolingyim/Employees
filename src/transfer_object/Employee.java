package transfer_object;
import java.sql.Date;

public class Employee {
	private final int emp_no;
	private Date birth_date;
	private String first_name;
	private String last_name;
	@SuppressWarnings("unused")
	private Gender gender;
	private Date hire_date;
	
	private enum Gender {
		MALE,
		FEMALE;
	}
	
	public Employee(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date) {
		this.emp_no = emp_no;
		setBirth_date(birth_date);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setGender(gender);
		this.setHire_date(hire_date);
	}

	public int getEmp_no() {
		return emp_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setGender(String gender) {
		if(gender.equals("M"))
			this.gender = Gender.MALE;
		else if(gender.equals("F")) 
			this.gender = Gender.FEMALE;
		else
			throw new IllegalStateException("Error - Gender must be MALE or FEMALE according to system specs.");
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
}

