package transferobjects;

import java.sql.Date;
import java.util.Objects;

public class Employee {

    public enum Gender {
        MALE,
        FEMALE;
    }
    private int emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    private Gender gender;
    private Date hire_date;

    public static String COL_EMP_NO = "emp_no";
    public static String COL_BIRTH_DATE = "birth_date";
    public static String COL_FIRST_NAME = "first_name";
    public static String COL_LAST_NAME = "last_name";
    public static String COL_GENDER = "gender";
    public static String COL_HIRE_DATE = "hire_date";
    
    public Employee(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender.equals("M")?Gender.MALE:Gender.FEMALE;
        this.hire_date = hire_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.equals("M")?Gender.MALE:Gender.FEMALE;    
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

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
