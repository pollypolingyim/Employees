package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import transferobjects.Salary;

/**
 * This class implements the {@link SalaryDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class SalaryDAOImp implements SalaryDAO {

    private static final String GET_ALL_SALARY = "SELECT emp_no, salary, from_date, to_date FROM salaries ORDER BY emp_no, from_date LIMIT 100";
    private static final String INSERT_SALARY = "INSERT INTO salaries (emp_no, salary, from_date, to_date) VALUES(?, ?,?,?)";
    private static final String DELETE_SALARY = "DELETE FROM salaries WHERE emp_no=?";
    private static final String UPDATE_SALARY_SALARY = "UPDATE salaries SET salary=? WHERE emp_no=?";
    private static final String UPDATE_SALARY_FROM_DATE = "UPDATE salaries SET from_date = ?  WHERE emp_no=?";
    private static final String UPDATE_SALARY_TO_DATE = "UPDATE salaries SET to_date=? WHERE emp_no=?";
    private static final String GET_BY_EMP_ID_SALARY = "SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no=?";

    /**
     * Overridden {@link SalaryDAO} getAllSalaries method.
     *
     * @return list of {@link Salary}
     */
    @Override
    public List<Salary> getAllSalaries() {
        List<Salary> salaries = Collections.EMPTY_LIST;
        Salary salary;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_SALARY);
            rs = pstmt.executeQuery();
            salaries = new ArrayList<>();
            while (rs.next()) {
                salary = new Salary(
                        rs.getInt(Salary.COL_EMP_NO),
                        rs.getInt(Salary.COL_SALARY),
                        rs.getDate(Salary.COL_FROM_DATE),
                        rs.getDate(Salary.COL_TO_DATE));

                salaries.add(salary);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return salaries;
    }

    /**
     * Overridden {@link SalaryDAO} addSalary method.
     *
     * @param salary of type {@link Salary}
     */
    @Override
    public void addSalary(Salary salary) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_SALARY);) {
            pstmt.setString(1, salary.getEmp_no() + "");
            pstmt.setString(2, salary.getSalary() + "");
            pstmt.setString(3, salary.getFrom_date() + "");
            pstmt.setString(4, salary.getTo_date() + "");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Overridden {@link SalaryDAO} updateSalarySalary method
     *
     * @param salary of type {@link Salary}
     * @param newSalary of type integer
     */
    @Override
    public void updateSalarySalary(Salary salary, int newSalary) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_SALARY_SALARY);) {
            pstmt.setString(1, newSalary + "");
            pstmt.setString(2, salary.getEmp_no() + "");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Overridden {@link SalaryDAO} updateSalaryFromDate method.
     *
     * @param salary of type {@link Salary}
     * @param newFromDate of type Date
     */
    @Override
    public void updateSalaryFromDate(Salary salary, Date newFromDate) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_SALARY_FROM_DATE);) {
            pstmt.setString(1, newFromDate + "");
            pstmt.setString(2, salary.getEmp_no() + "");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Overridden {@link SalaryDAO} updateSalaryToDate method.
     *
     * @param salary of type {@link Salary}
     * @param newToDate of type Date
     */
    @Override
    public void updateSalaryToDate(Salary salary, Date newToDate) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_SALARY_TO_DATE);) {
            pstmt.setString(1, newToDate + "");
            pstmt.setString(2, salary.getEmp_no() + "");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Overridden {@link SalaryDAO} deleteSalary
     *
     * @param salary of {@link Salary}
     */
    @Override
    public void deleteSalary(Salary salary) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_SALARY);) {
            pstmt.setString(1, salary.getEmp_no() + "");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(SalaryDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Overridden {@link SalaryDAO} getSalaryByEmpID
     *
     * @param emp_no of type integer
     * @return ResultSet
     */
    @Override
    public ResultSet getSalaryByEmpID(int emp_no) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_EMP_ID_SALARY);) {
            pstmt.setString(1, emp_no + "");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImp.class.getName()).log(Level.SEVERE, "", ex);
        }
        return null;
    }
}
