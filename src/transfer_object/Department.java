package transfer_object;

public class Department {
	private final int dept_no;
	private String dept_name;
	
	public Department(int dept_no, String dept_name) {
		this.dept_no = dept_no;
		setDept_name(dept_name);
		
	}

	public int getDept_no() {
		return dept_no;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
