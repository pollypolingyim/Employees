package business;

import dataaccess.DepartmentManagerDAO;
import dataaccess.DepartmentManagerDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.DepartmentManager;

/**
 * This class represents the {@link DepartmentManager} business logic.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */

public class DepartmentManagerLogic {

    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE;
    private static final int DEPT_NUM_MAX_LENGTH = 4;
    private DepartmentManagerDAO departmentManagerDAO = null;

    /**
     * No-argument constructor
     */
    public DepartmentManagerLogic() {
        departmentManagerDAO = new DepartmentManagerDAOImp();
    }

    /**
     * This method uses the {@link DepartmentManagerDAO} to retrieve all
     * departments.
     *
     * @return {@link DepartmentManager} object
     */
    public List<DepartmentManager> getAllDepartmentManagers() {
        return departmentManagerDAO.getAllDepartmentManagers();
    }

    /**
     * This method is used when adding departments manager.
     *
     * @param departmentManager of type {@link DepartmentManager}
     */
    public void addDepartmentManager(DepartmentManager departmentManager) {
        cleanDepartmentManager(departmentManager);
        validateDepartmentManager(departmentManager);
        departmentManagerDAO.addDepartmentManager(departmentManager);
    }

    /**
     * This method is used to clean the {@link DepartmentManager} object.
     *
     * @param departmentManager of type {@link Department}
     */
    private void cleanDepartmentManager(DepartmentManager departmentManager) {
        if (departmentManager.getDept_no() != null) {
            departmentManager.setDept_no(departmentManager.getDept_no().trim());
        }
    }

    /**
     * This method is used to validate the {@link DepartmentManager} object.
     *
     * @param departmentManager of type {@link DepartmentManager}
     */
    private void validateDepartmentManager(DepartmentManager departmentManager) {
        validateInt(departmentManager.getEmp_no(), "Manager number", EMP_NUM_MAX_VALUE, false);
        validateString(departmentManager.getDept_no(), "Department number", DEPT_NUM_MAX_LENGTH, false);
        validateDate(departmentManager.getFrom_date(), departmentManager.getTo_date(), false, false);
    }

    /**
     * This method validates the dates
     *
     * @param fromDateof type Date
     * @param toDate of type Date
     * @param isNullAllowedFromDate of type boolean
     * @param isNullAllowedToDate of type boolean
     */
    private void validateDate(Date fromDate, Date toDate, boolean isNullAllowedFromDate, boolean isNullAllowedToDate) {
        if (fromDate == null && !isNullAllowedFromDate) {
            throw new IllegalStateException("from date cannot be null");
        } else if (toDate == null && !isNullAllowedToDate) {
            throw new IllegalStateException("to date cannot be null");
        } else if (toDate.compareTo(fromDate) <= 0) {
            throw new IllegalStateException("to date has to be after from date");
        }
    }

    /**
     * This method validates the {@link Integer} values in the class.
     *
     * @param value of type Integer
     * @param fieldName of type String
     * @param maxValue of type integer
     * @param isNullAllowed of type boolean
     */
    private void validateInt(Integer value, String fieldName, int maxValue, boolean isNullAllowed) {
        if (value == null && !isNullAllowed) {
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        } else if (value > maxValue) {
            throw new IllegalStateException(String.format("%s exceeds max value", fieldName));
        }
    }

    /**
     * This method validates strings.
     *
     * @param value of type String
     * @param fieldName of type String
     * @param maxLength of type integer
     * @param isNullAllowed of type boolean
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        } else if (value.isEmpty()) {
            throw new IllegalStateException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalStateException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
