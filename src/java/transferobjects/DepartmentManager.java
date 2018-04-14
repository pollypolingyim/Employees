package transferobjects;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

public class DepartmentManager {

    Integer emp_no;
    String dept_no;
    Date from_date;
    Date to_date;

    public static String COL_EMP_NO = "emp_no";
    public static String COL_DEPT_NO = "dept_no";
    public static String COL_FROM_DATE = "from_date";
    public static String COL_TO_DATE = "to_date";
            
    public DepartmentManager(int emp_no, String dept_no, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.dept_no = dept_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    
    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
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
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.emp_no);
        hash = 71 * hash + Objects.hashCode(this.dept_no);
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
        final DepartmentManager other = (DepartmentManager) obj;
        if (!Objects.equals(this.emp_no, other.emp_no)) {
            return false;
        }
        if (!Objects.equals(this.dept_no, other.dept_no)) {
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
