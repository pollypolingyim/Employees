package dataaccess;

import java.util.List;

import transfer_object.Department;
/**
 * This class implements the {@link DepartmentDAO} interface.
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov 
 *
 */
public class DepartmentDAOImp implements DepartmentDAO {
/**
 * This method overrides the {@link DepartmentDAO} getAllDepartments method
 * @return list of departments
 */
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}
/**
 * This method overrides the {@link  DepartmentDAO} addDepartment method
 * @param dept_no of type integer
 * @param dept_name of type String
 */
	@Override
	public void addDepartment(int dept_no, String dept_name) {
		// TODO Auto-generated method stub
	}
/**
 * This method overrides the {@link  DepartmentDAO} updateDepartment method.
 * @param dept_no of type integer
 * @param dept_name of type String
 */
	@Override
	public void updateDepartment(int dept_no, String dept_name) {
		// TODO Auto-generated method stub

	}
/**
 * This method overrides the {@link  DepartmentDAO} deleteDepartmentByNo method.
 * @param dept_no of type integer
 */
	@Override
	public void deleteDepartmentByDeptNo(int dept_no) {
		// TODO Auto-generated method stub

	}
/**
 * This method overrides the {@link  DepartmentDAO} deleteDepartmentByName method.
 * @param dept_name of type String
 */
	@Override
	public void deleteDepartmentByDeptName(String dept_name) {
		// TODO Auto-generated method stub

	}

}
