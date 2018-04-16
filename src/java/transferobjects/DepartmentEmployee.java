package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * This class represents the {@link DepartmentEmployee} transfer object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class DepartmentEmployee {

    private String dept_no;
    private int emp_no;
    private Date from_date;
    private Date to_date;

    /**
     * Table column name declaration for the {@link Department} number.
     */
    public static String COL_DEPT_NO = "dept_no";

    /**
     * Table column name declaration for the {@link DepartmentEmployee} number.
     */
    public static String COL_EMP_NO = "emp_no";

    /**
     * Table column name declaration for the {@link DepartmentEmployee}
     * from_date.
     */
    public static String COL_FROM_DATE = "from_date";

    /**
     * Table column name declaration for the {@link DepartmentEmployee} to_date.
     */
    public static String COL_TO_DATE = "to_date";

    /**
     * Constructor with four arguments.
     *
     * @param dept_no of type String
     * @param emp_no of type integer
     * @param from_date of type Date
     * @param to_date of type Date
     */
    public DepartmentEmployee(String dept_no, int emp_no, Date from_date, Date to_date) {
        this.dept_no = dept_no;
        this.emp_no = emp_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    /**
     * This method sets the dept_no value.
     *
     * @param dept_no of type String
     */
    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    /**
     * Auto-generated hashCode method
     *
     * @return hash of type integer
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.dept_no);
        hash = 37 * hash + this.emp_no;
        hash = 37 * hash + Objects.hashCode(this.from_date);
        hash = 37 * hash + Objects.hashCode(this.to_date);
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
        final DepartmentEmployee other = (DepartmentEmployee) obj;
        if (this.dept_no != other.dept_no) {
            return false;
        }
        if (this.emp_no != other.emp_no) {
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

    /**
     * Setter for emp_no
     *
     * @param emp_no of type integer
     */
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    /**
     * Getter for dept_no
     *
     * @return dept_no of type String
     */
    public String getDept_no() {
        return dept_no;
    }

    /**
     * Getter for the emp_no
     *
     * @return emp_no of type integer
     */
    public int getEmp_no() {
        return emp_no;
    }

    /**
     * Getter for the from_date
     *
     * @return from_date of type date
     */
    public Date getFrom_date() {
        return from_date;
    }

    /**
     * Setter for the from_date
     *
     * @param from_date of type Date
     */
    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    /**
     * Getter for the to_date
     *
     * @return to_date of type Date
     */
    public Date getTo_date() {
        return to_date;
    }

    /**
     * Setter for the to_date
     *
     * @param to_date of type Date
     */
    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
}
