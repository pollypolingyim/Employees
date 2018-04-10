package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.DepartmentManager;

public interface DepartmentManagerDAO {
	public List<DepartmentManager> getAllDepartmentManager();
	public void addDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
	public void updateDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
	public void deleteDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date);
}
