package transferobjects;

import java.sql.Date;
import java.util.Objects;

public class Salary {

    private int emp_no;
    private int salary;
    private Date from_date;
    private Date to_date;
    
    public static String COL_EMP_NO = "emp_no";
    public static String COL_SALARY = "salary";
    public static String COL_FROM_DATE = "from_date";
    public static String COL_TO_DATE = "to_date";
   

    public Salary(int emp_no, int salary, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.emp_no;
        hash = 73 * hash + this.salary;
        hash = 73 * hash + Objects.hashCode(this.from_date);
        hash = 73 * hash + Objects.hashCode(this.to_date);
        return hash;
    }

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
