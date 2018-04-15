package transferobjects;

import java.sql.Date;
import java.util.Objects;

public class Title {

    private int emp_no;
    private String title;
    private Date from_date;
    private Date to_date;

    public static String COL_EMP_NO = "emp_no";
    public static String COL_TITLE = "title";
    public static String COL_FROM_DATE = "from_date";
    public static String COL_TO_DATE = "to_date";
    
    
    public Title(int emp_no, String title, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public Title(int emp_no, String title, Date from_date) {
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash = 29 * hash + this.emp_no;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.from_date);
        hash = 29 * hash + Objects.hashCode(this.to_date);
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
        final Title other = (Title) obj;
        if (this.emp_no != other.emp_no) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
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
