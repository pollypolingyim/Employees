package business;

import dataaccess.EmployeeDAO;
import dataaccess.EmployeeDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.Employee;

public class EmployeeLogic {
   
    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE ;
    private static final int FIRST_NAME_MAX_LENGTH = 14;
    private static final int LAST_NAME_MAX_LENGTH=16;
    

    private EmployeeDAO employeeDAO = null;

    public EmployeeLogic() {
        employeeDAO = new EmployeeDAOImp();
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public void addEmployee(Employee employee) {
        cleanEmployee(employee);
        validateEmployee(employee);
        employeeDAO.addEmployee(employee);
    }

    private void cleanEmployee(Employee employee) {
        if (employee.getFirst_name() != null) {
            employee.setFirst_name(employee.getFirst_name().trim());
        }
        if(employee.getLast_name()!=null){
            employee.setLast_name (employee.getLast_name().trim());
        }
     
    }

    private void validateEmployee(Employee employee) {
        validateInt(employee.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateString(employee.getFirst_name(), "First name", FIRST_NAME_MAX_LENGTH, false);
        validateString(employee.getLast_name(),"Last name", LAST_NAME_MAX_LENGTH, false);
        validateDate(employee.getBirth_date(),employee.getHire_date(), false, false);
    }
    
    private void validateDate(Date birthDate, Date hireDate, boolean isNullAllowedBirthDate, boolean isNullAllowedHireDate){
        if(birthDate==null && !isNullAllowedBirthDate){
            throw new IllegalStateException("birth date cannot be null");
        }
        else if(hireDate==null && !isNullAllowedHireDate){
            throw new IllegalStateException("hire date cannot be null");
        }
        else if (hireDate.compareTo(birthDate)<=0){
            throw new IllegalStateException("hire date has to be after birth date");
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
