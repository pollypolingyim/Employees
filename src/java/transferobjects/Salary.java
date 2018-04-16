package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * This class builds the {@link Salary} transfer object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class Salary {

    private int emp_no;
    private int salary;
    private Date from_date;
    private Date to_date;

    /**
     * Table column name declaration for the {@link Employee} number.
     */
    public static String COL_EMP_NO = "emp_no";

    /**
     * Table column name declaration for the {@link Salary} salary.
     */
    public static String COL_SALARY = "salary";

    /**
     * Table column name declaration for the {@link Salary} from_date.
     */
    public static String COL_FROM_DATE = "from_date";

    /**
     * Table column name declaration for the {@link Salary} to_date.
     */
    public static String COL_TO_DATE = "to_date";

    /**
     * Constructor with 4 parameters.
     *
     * @param emp_no of type integer
     * @param salary of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
    public Salary(int emp_no, int salary, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    /**
     * Getter for emp_no.
     *
     * @return emp_no
     */
    public int getEmp_no() {
        return emp_no;
    }

    /**
     * Setter for the emp_no
     *
     * @param emp_no of type integer
     */
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    /**
     * Getter for salary.
     *
     * @return salary of type integer
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Setter for the salary
     *
     * @param salary of type integer
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Getter for from_date.
     *
     * @return from_date of type Date
     */
    public Date getFrom_date() {
        return from_date;
    }

    /**
     * Setter for from_date.
     *
     * @param from_date of type Date
     */
    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    /**
     * Getter for to_date.
     *
     * @return to_date of type Date
     */
    public Date getTo_date() {
        return to_date;
    }

    /**
     * Setter for to_date.
     *
     * @param to_date of type Date
     */
    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    /**
     * Auto-generated hashCode method
     *
     * @return hash of type integer
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.emp_no;
        hash = 73 * hash + this.salary;
        hash = 73 * hash + Objects.hashCode(this.from_date);
        hash = 73 * hash + Objects.hashCode(this.to_date);
        return hash;
    }

    /**
     * Auto-generated equals method.
     *
     * @param obj of type {@link Object}
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salary other = (Salary) obj;
        if (this.emp_no != other.emp_no) {
            return false;
        }
        if (this.salary != other.salary) {
            return false;
        }
        if (!Objects.equals(this.from_date, other.from_date)) {
            return false;
        }
        if (!Objects.equals(this.to_date, other.to_date)) {
            return false;
        }
        return true;
    }

}
