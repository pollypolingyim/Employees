package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.DepartmentManager;

/**
 * This class implements the {@link DepartmentManagerDAO} interface.
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov 
 */
public class DepartmentManagerDAOImp implements DepartmentManagerDAO {
    /**
     * This method overrides the {@link DepartmentManagerDAO}
     * getAllDepartmentManager method.
     *
     * @return list of DepartmentManager objects
     */
	@Override
	public List<DepartmentManager> getAllDepartmentManager() {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * This method overrides the {@link DepartmentManagerDAO}
     * addDepartmentManager method
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
	@Override
	public void addDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link DepartmentManagerDAO}
     * updateDepartmentManager method
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type date
     */
	@Override
	public void updateDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link DepartmentManagerDAO}
     * deleteDepartmentManager method.
     *
     * @param emp_no of type integer
     * @param dept_no of type integer
     * @param from_date of type Date
     * @param to_date of type date
     */
	@Override
	public void deleteDepartmentManager(int emp_no, int dept_no, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}

}
