package business;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.Salary;

/**
 * This class builds the {@link Salary} object logic.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class SalaryLogic {

    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE;
    private static final int SALARY_MAX_VALUE = Integer.MAX_VALUE;
    private SalaryDAO salaryDAO = null;

    /**
     * No-argument constructor.
     */
    public SalaryLogic() {
        salaryDAO = new SalaryDAOImp();
    }

    /**
     * This method is uses the {@link SalaryDAO} to retrieve all salaries.
     *
     * @return list of all salaries
     */
    public List<Salary> getAllSalaries() {
        return salaryDAO.getAllSalaries();
    }

    /**
     * This method is used to add salaries.
     *
     * @param salary of type {@link Salary}
     */
    public void addSalary(Salary salary) {
        cleanSalary(salary);
        validateSalary(salary);
        salaryDAO.addSalary(salary);
    }

    /**
     * This method is used to clean the {@link Salary} object.
     *
     * @param salary of type {@link Salary}
     */
    private void cleanSalary(Salary salary) {

    }

    /**
     * This method is used to validate the {@link Salary} object.
     *
     * @param salary of type {@link Salary}
     */
    private void validateSalary(Salary salary) {
        validateInt(salary.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateInt(salary.getSalary(), "Salary", SALARY_MAX_VALUE, false);
        validateDate(salary.getFrom_date(), salary.getTo_date(), false, false);
    }

    /**
     * This method is used to validate dates.
     *
     * @param birthDate of type Date
     * @param hireDate of type Date
     * @param isNullAllowedBirthDate of type boolean
     * @param isNullAllowedHireDate of type boolean
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
     * This method is used to validate integers.
     *
     * @param value of type {@link Integer}
     * @param fieldName of type String
     * @param maxValue of type Date
     * @param isNullAllowed of type boolean
     */
    private void validateInt(Integer value, String fieldName, int maxValue, boolean isNullAllowed) {
        if (value == null && !isNullAllowed) {
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        } else if (value > maxValue) {
            throw new IllegalStateException(String.format("%s exceeds max value", fieldName));
        }
    }

}