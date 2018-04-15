package business;

import dataaccess.EmployeeDAO;
import dataaccess.EmployeeDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.Employee;
/**
 * This class builds the {@link Employee} object logic.
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class EmployeeLogic {
   
    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE ;
    private static final int FIRST_NAME_MAX_LENGTH = 14;
    private static final int LAST_NAME_MAX_LENGTH=16;
    private EmployeeDAO employeeDAO = null;
/**
 * No-argument constructor.
 */
    public EmployeeLogic() {
        employeeDAO = new EmployeeDAOImp();
    }
/**
 * This method is uses the {@link EmployeeDAO} to retrieve all employees.
 * @return list of all employees
 */
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
/**
 * This method is used to add employees.
 * @param employee of type {@link Employee}
 */
    public void addEmployee(Employee employee) {
        cleanEmployee(employee);
        validateEmployee(employee);
        employeeDAO.addEmployee(employee);
    }
    /**
    * This method is used to clean the {@link Employee} object.
     *
     * @param employee of type {@link Employee}
     */
    private void cleanEmployee(Employee employee) {
        if (employee.getFirst_name() != null) {
            employee.setFirst_name(employee.getFirst_name().trim());
        }
        if(employee.getLast_name()!=null){
            employee.setLast_name (employee.getLast_name().trim());
        }
     
    }
    /**
     * This method is used to validate the {@link Employee} object.
     *
     * @param employee  of type {@link Employee}
     */
    private void validateEmployee(Employee employee) {
        validateInt(employee.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateString(employee.getFirst_name(), "First name", FIRST_NAME_MAX_LENGTH, false);
        validateString(employee.getLast_name(),"Last name", LAST_NAME_MAX_LENGTH, false);
        validateDate(employee.getBirth_date(),employee.getHire_date(), false, false);
    }
    /**
     * This method is used to validate dates.
     * @param birthDate of type Date
     * @param hireDate of type Date
     * @param isNullAllowedBirthDate of type boolean
     * @param isNullAllowedHireDate of type boolean
     */
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
    /**
     * This method is used to validate integers.
     * @param value of type {@link Integer}
     * @param fieldName of type String
     * @param maxValue of type Date
     * @param isNullAllowed of type boolean
     */
    private void validateInt(Integer value, String fieldName, int maxValue, boolean isNullAllowed){
        if(value == null && !isNullAllowed){
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        }
        else if(value > maxValue){
            throw new IllegalStateException(String.format("%s exceeds max value", fieldName));
        }
    }
/**
 * This method is used to validate strings.
 * @param value of type {@link Integer}
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
