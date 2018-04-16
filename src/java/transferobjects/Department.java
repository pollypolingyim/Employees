package transferobjects;

import java.util.Objects;

/**
 * This class builds the {@link Department} transfer object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 *
 */
public class Department {

    private String dept_no;
    private String dept_name;

    /**
     * Table column name declaration for the {@link Department} number.
     */
    public static String COL_DEPT_NO = "dept_no";

    /**
     * Table column name declaration for the {@link Department} name.
     */
    public static String COL_DEPT_NAME = "dept_name";

    /**
     * Constructor with two arguments.
     *
     * @param dept_no of type String
     * @param dept_name of type String
     */
    public Department(String dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;

    }

    /**
     * Setter for the dept_no.
     *
     * @return dept_no of type String
     */
    public String getDept_no() {
        return dept_no;
    }

    /**
     * Setter for the dept_no.
     *
     * @param dept_no of type String
     */
    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    /**
     * Getter for the dept_name.
     *
     * @return dept_name of type String
     */
    public String getDept_name() {
        return dept_name;
    }

    /**
     * Setter for the dept_name.
     *
     * @param dept_name of type String
     */
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    /**
     * Auto-generated hasCode method.
     *
     * @return has of type integer
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.dept_no);
        hash = 37 * hash + Objects.hashCode(this.dept_name);
        return hash;
    }

    /**
     * Auto-generated equals method.
     *
     * @param obj of type {@link Object}
     * @return boolean value
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.dept_no, other.dept_no)) {
            return false;
        }
        if (!Objects.equals(this.dept_name, other.dept_name)) {
            return false;
        }
        return true;
    }
}
