package data_access;

import java.util.List;

import transfer_object.Department;

public interface DepartmentDAO {
	public List<Department> getAllDepartments();
	public void addDepartment(int dept_no, String dept_name);
	public void updateDepartment(int dept_no, String dept_name);
	public void deleteDepartmentByDeptNo(int dept_no);
	public void deleteDepartmentByDeptName(String dept_name);
}
