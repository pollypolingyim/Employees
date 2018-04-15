package business;


import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;
import java.util.List;
import transferobjects.Department;

public class DepartmentLogic {
     private static final int DEPARTMENT_CODE_MAX_LENGTH = 4;
    private static final int DEPARTMENT_NAME_MAX_LENGTH = 40;

    private DepartmentDAO departmentDAO = null;

    public DepartmentLogic() {
        departmentDAO = new DepartmentDAOImp();
    }

    public List<Department> getAllDepartments() {
        
        return departmentDAO.getAllDepartments();
    }

    public void addDepartment(Department department) {
        cleanDepartment(department);
        validateDepartment(department);
        departmentDAO.addDepartment(department);
    }

    private void cleanDepartment(Department department) {
        if (department.getDept_no() != null) {
            department.setDept_no(department.getDept_no().trim());
        }
        if (department.getDept_name() != null) {
            department.setDept_name(department.getDept_name().trim());
        }
    }

    private void validateDepartment(Department department) {
        validateString(department.getDept_no(), "Department Code", DEPARTMENT_CODE_MAX_LENGTH, false);
        validateString(department.getDept_name(), "Department Name", DEPARTMENT_NAME_MAX_LENGTH, false);
    }

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
