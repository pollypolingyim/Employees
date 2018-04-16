package dataaccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import transferobjects.DepartmentManager;

/**
 * This is an interface for the DepartmentManager DAO
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface DepartmentManagerDAO {

    /**
     * This method is used to retrieve a list all department managers.
     *
     * @return List of {@link DepartmentManager}
     */
    public List<DepartmentManager> getAllDepartmentManagers();

    /**
     * This method is used when adding a department manager.
     *
     * @param departmentManager of type {@link DepartmentManager}
     */
    public void addDepartmentManager(DepartmentManager departmentManager);

    /**
     * This method is used to update the department manager table.
     *
     * @param departmentManager of type {@link DepartmentManager}
     * @param newFromDate of type Date
     */
    public void updateDepartmentManagerFromDate(DepartmentManager departmentManager, Date newFromDate);

    /**
     * This method is used to update the department manager table.
     *
     * @param departmentManager of type {@link DepartmentManager}
     * @param newToDate of type Date
     */
    public void updateDepartmentManagerToDate(DepartmentManager departmentManager, Date newToDate);

    /**
     * This method is used to delete from the department manager table.
     *
     * @param departmentManager of type {@link DepartmentManager}
     */
    public void deleteDepartmentManager(DepartmentManager departmentManager);

    /**
     * This method retrieves a department manager by its ID
     *
     * @param dept_no of type integer
     * @return ResultSet
     */
    public ResultSet getDepartmentManagerByDeptID(int dept_no);

    /**
     * This method gets a department employee by its employee number.
     *
     * @param emp_no of type integer
     * @return ResultSet
     */
    public ResultSet getDepartmentManagerByEmpID(int emp_no);
}
