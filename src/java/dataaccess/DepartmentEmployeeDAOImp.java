package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.DepartmentEmployee;
/**
 * This class implements the {@link DepartmentEmployeeDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov
 */
public class DepartmentEmployeeDAOImp implements DepartmentEmployeeDAO {
    /**
     * This method overrides the {@link DepartmentEmployeeDAO} getAllDepartments
     * method
     *
     * @return List of {@link DepartmentEmployee} objects.
     */
	@Override
	public List<DepartmentEmployee> getAllDepartmentEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * This method overrides the {@link DepartmentEmployeeDAO}
     * addDeparmentEmployee method.
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
	@Override
	public void addDeparmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link DepartmentEmployeeDAO}
     * updateDepartmentEmployee method.
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
	@Override
	public void updateDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link DepartmentEmployeeDAO}
     * deleteDepartmentEmployee method.
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
	@Override
	public void deleteDepartmentEmployee(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}

}
