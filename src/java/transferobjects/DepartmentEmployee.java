package transferobjects;

import java.sql.Date;
import java.util.Objects;

public class DepartmentEmployee {

    private int dept_no;
    private int emp_no;
    private Date from_date;
    private Date to_date;
    
    public static String COL_DEPT_NO = "dept_no";
    public static String COL_EMP_NO = "emp_no";
    public static String COL_FROM_DATE = "from_date";
    public static String COL_TO_DATE = "to_date";

    public DepartmentEmployee(int dept_no, int emp_no, Date from_date, Date to_date) {
        this.dept_no = dept_no;
        this.emp_no = emp_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.dept_no;
        hash = 71 * hash + this.emp_no;
        hash = 71 * hash + Objects.hashCode(this.from_date);
        hash = 71 * hash + Objects.hashCode(this.to_date);
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

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getDept_no() {
        return dept_no;
    }

    public int getEmp_no() {
        return emp_no;
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
}
