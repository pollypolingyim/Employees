package transferobjects;

import java.util.Objects;

public class Department {

    private String dept_no;
    private String dept_name;
    
    public static String COL_DEPT_NO = "dept_no";
    public static String COL_DEPT_NAME = "dept_name";

    public Department(String dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;

    }

    public String getDept_no() {
        return dept_no;
    }



    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.dept_no);
        hash = 37 * hash + Objects.hashCode(this.dept_name);
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
