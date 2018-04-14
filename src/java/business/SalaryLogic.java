package business;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.Salary;


public class SalaryLogic {
 
    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE ;
    private static final int SALARY_MAX_VALUE =Integer.MAX_VALUE;

    private SalaryDAO salaryDAO = null;

    public SalaryLogic() {
        salaryDAO = new SalaryDAOImp();
    }

    public List<Salary> getAllSalaries() {
        return salaryDAO.getAllSalaries();
    }

    public void addSalary(Salary salary) {
        cleanSalary(salary);
        validateSalary(salary);
        salaryDAO.addSalary(salary);
    }

    private void cleanSalary(Salary salary) {
     
     
    }

    private void validateSalary(Salary salary) {
        validateInt(salary.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateInt(salary.getSalary(), "Salary", SALARY_MAX_VALUE, false);
        validateDate(salary.getFrom_date(),salary.getTo_date(), false, false);
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

}
