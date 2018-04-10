package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.DepartmentEmployee;

public interface DepartmentEmployeeDAO {
	public List<DepartmentEmployee> getAllDepartmentEmployee();
	public void addDeparmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
	public void updateDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
	public void deleteDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date);
}
