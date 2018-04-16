package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * This class builds the {@link Employee} transfer object.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class Employee {

    /**
     * Enum variable for the genders.
     */
    public enum Gender {
        M,
        F;
    }
    private int emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    private Gender gender;
    private Date hire_date;

    /**
     * Table column name declaration for the {@link Employee} number.
     */
    public static String COL_EMP_NO = "emp_no";

    /**
     * Table column name declaration for the {@link Employee} birth_date.
     */
    public static String COL_BIRTH_DATE = "birth_date";

    /**
     * Table column name declaration for the {@link Employee} first_name.
     */
    public static String COL_FIRST_NAME = "first_name";

    /**
     * Table column name declaration for the {@link Employee} last_name.
     */
    public static String COL_LAST_NAME = "last_name";

    /**
     * Table column name declaration for the {@link Employee} gender.
     */
    public static String COL_GENDER = "gender";

    /**
     * Table column name declaration for the {@link Employee} hire_date.
     */
    public static String COL_HIRE_DATE = "hire_date";
    
    public static int counter = 1;
    

    /**
     * Constructor with 6 parameters.
     *
     * @param emp_no of type integer
     * @param birth_date of type Date
     * @param first_name of type String
     * @param last_name of type String
     * @param gender of type String
     * @param hire_date of type Date
     */
    public Employee(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender.equals("M")?Gender.M:Gender.F;
        this.hire_date = hire_date;
    }
    
    public Employee(Date birth_date, String first_name, String last_name, String gender, Date hire_date) {
        this.emp_no = counter++;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender.equals("M")?Gender.M:Gender.F;
        this.hire_date = hire_date;
    }
    
    public int getEmp_no() {
        return emp_no;
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
     * Getter for birth_date.
     *
     * @return birth_date of type Date
     */
    public Date getBirth_date() {
        return birth_date;
    }

    /**
     * Setter for the birth_date
     *
     * @param birth_date of type Date
     */
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * Getter for the first_name
     *
     * @return first_name of type String
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter for the first_name
     *
     * @param first_name of type String
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter for the last_name
     *
     * @return last_name of type String
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Setter for the last_name
     *
     * @param last_name of type String
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Getter for the gender.
     *
     * @return gender of type String
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Setter for the gender
     *
     * @param gender of type String
     */
    public void setGender(String gender) {
        this.gender = gender.equals("M")?Gender.M:Gender.F;    
    }

    /**
     * Getter for the hire_date.
     *
     * @return hire_date of type Date
     */
    public Date getHire_date() {
        return hire_date;
    }

    /**
     * Setter for the hire_date
     *
     * @param hire_date of type Date
     */
    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    /**
     * Auto-generated hashCode method
     *
     * @return hash of type integer
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.emp_no;
        hash = 37 * hash + Objects.hashCode(this.birth_date);
        hash = 37 * hash + Objects.hashCode(this.first_name);
        hash = 37 * hash + Objects.hashCode(this.last_name);
        hash = 37 * hash + Objects.hashCode(this.gender);
        hash = 37 * hash + Objects.hashCode(this.hire_date);
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
        final Employee other = (Employee) obj;
        if (this.emp_no != other.emp_no) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.birth_date, other.birth_date)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.hire_date, other.hire_date)) {
            return false;
        }
        return true;
    }

}
