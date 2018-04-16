package business;

import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;
import java.util.List;
import transferobjects.Department;

/**
 * This class represents the {@link Department} business logic.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class DepartmentLogic {

    private static final int DEPARTMENT_CODE_MAX_LENGTH = 4;
    private static final int DEPARTMENT_NAME_MAX_LENGTH = 40;
    private DepartmentDAO departmentDAO = null;

    /**
     * No-argument constructor
     */
    public DepartmentLogic() {
        departmentDAO = new DepartmentDAOImp();
    }

    /**
     * This method uses the {@link DepartmentDAO} to retrieve all departments.
     *
     * @return {@link Department} object
     */
    public List<Department> getAllDepartments() {
        
        return departmentDAO.getAllDepartments();
    }

    /**
     * This method is used when adding departments.
     *
     * @param department of type {@link Department}
     */
    public void addDepartment(Department department) {
        cleanDepartment(department);
        validateDepartment(department);
        departmentDAO.addDepartment(department);
    }

    /**
     * This method is used to clean the {@link Department} object.
     *
     * @param department of type {@link Department}
     */
    private void cleanDepartment(Department department) {
        if (department.getDept_no() != null) {
            department.setDept_no(department.getDept_no().trim());
        }
        if (department.getDept_name() != null) {
            department.setDept_name(department.getDept_name().trim());
        }
    }

    /**
     * This method is used to validate the {@link Department} object.
     *
     * @param department of type {@link Department}
     */
    private void validateDepartment(Department department) {
        validateString(department.getDept_no(), "Department Code", DEPARTMENT_CODE_MAX_LENGTH, false);
        validateString(department.getDept_name(), "Department Name", DEPARTMENT_NAME_MAX_LENGTH, false);
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
