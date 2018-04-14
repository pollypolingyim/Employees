package business;


import dataaccess.DepartmentEmployeeDAO;
import dataaccess.DepartmentEmployeeDAOImp;
import java.util.List;
import java.sql.Date;
import transferobjects.DepartmentEmployee;


public class DepartmentEmployeeLogic {
   
    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE ;
    private static final int DEPT_NUM_MAX_LENGTH = 4;

    private DepartmentEmployeeDAO departmentEmployeeDAO = null;

    public DepartmentEmployeeLogic() {
        departmentEmployeeDAO = new DepartmentEmployeeDAOImp();
    }

    public List<DepartmentEmployee> getAllDepartmentEmployees() {
        return departmentEmployeeDAO.getAllDepartmentEmployees();
    }

    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        cleanDepartmentEmployee(departmentEmployee);
        validateDepartmentEmployee(departmentEmployee);
        departmentEmployeeDAO.addDepartmentEmployee(departmentEmployee);
    }

    private void cleanDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        if (departmentEmployee.getDept_no() != null) {
            departmentEmployee.setDept_no(departmentEmployee.getDept_no().trim());
        }
     
    }

    private void validateDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        validateInt(departmentEmployee.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateString(departmentEmployee.getDept_no(), "Department number", DEPT_NUM_MAX_LENGTH, false);
        validateDate(departmentEmployee.getFrom_date(),departmentEmployee.getTo_date(), false, false);
    }
    
    private void validateDate(Date fromDate, Date toDate, boolean isNullAllowedFromDate, boolean isNullAllowedToDate){
        if(fromDate==null && !isNullAllowedFromDate){
            throw new IllegalStateException("from date cannot be null");
        }
        else if(toDate==null && !isNullAllowedToDate){
            throw new IllegalStateException("to date cannot be null");
        }
        else if (toDate.compareTo(fromDate)<=0){
            throw new IllegalStateException("to date has to be after from date");
        }
    }
    
    private void validateInt(Integer value, String fieldName, int maxValue, boolean isNullAllowed){
        if(value == null && !isNullAllowed){
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        }
        else if(value > maxValue){
            throw new IllegalStateException(String.format("%s exceeds max value", fieldName));
        }
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
