package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * This class builds the {@link Title} transfer object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class Title {

    private int emp_no;
    private String title;
    private Date from_date;
    private Date to_date;

    /**
     * Table column name declaration for the {@link Employee} emp_no.
     */
    public static String COL_EMP_NO = "emp_no";

    /**
     * Table column name declaration for the {@link Title} title.
     */
    public static String COL_TITLE = "title";

    /**
     * Table column name declaration for the {@link Title} from_date.
     */
    public static String COL_FROM_DATE = "from_date";

    /**
     * Table column name declaration for the {@link Title} to_date.
     */
    public static String COL_TO_DATE = "to_date";

    /**
     * Constructor with 4 parameters.
     *
     * @param emp_no of type integer
     * @param title of type String
     * @param from_date of type Date
     * @param to_date of type Date
     */
    public Title(int emp_no, String title, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    
    /**
     * Constructor with 2 parameters.
     *
     * @param emp_no of type integer
     * @param title of type String
     */
    public Title(int emp_no, String title, Date from_date) {
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
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
     * Getter for title.
     *
     * @return title of type String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title
     *
     * @param title of type String
     */
    public void setTitle(String title) {
        this.title = title;
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
        hash = 29 * hash + this.emp_no;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.from_date);
        hash = 29 * hash + Objects.hashCode(this.to_date);
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
