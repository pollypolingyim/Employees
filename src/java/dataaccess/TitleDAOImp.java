package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import transferobjects.Title;

import transferobjects.Title;
/**
 * This class implements the {@link TitleDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class TitleDAOImp implements TitleDAO {
     private static final String GET_ALL_TITLE = "SELECT emp_no, title, from_date, to_date FROM titles ORDER BY emp_no";
    private static final String INSERT_TITLE = "INSERT INTO titles (emp_no, title, from_date, to_date) VALUES(?, ?,?,?)";
    private static final String DELETE_TITLE = "DELETE FROM titles WHERE emp_no=?";
    private static final String UPDATE_TITLE_TITLE = "UPDATE titles SET title=? WHERE emp_no=?";
    private static final String UPDATE_TITLE_FROM_DATE = "UPDATE titles SET from_date = ?  WHERE emp_no=?";
    private static final String UPDATE_TITLE_TO_DATE="UPDATE titles SET to_date=? WHERE emp_no=?";
    private static final String GET_BY_EMP_ID_TITLE="SELECT emp_no, title, from_date, to_date FROM titles WHERE emp_no=?";
    
    @Override
    public List<Title> getAllTitles() {
        List<Title> titles = Collections.EMPTY_LIST;
        Title title;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_TITLE);
            rs = pstmt.executeQuery();
            titles= new ArrayList<>();
            while( rs.next()){
                title = new Title();
                title.setTitle(rs.getString("title"));
                title.setEmp_no( rs.getInt("emp_no"));
                title.setFrom_date(rs.getDate("from_date"));
                title.setTo_date(rs.getDate("to_date"));
                
                titles.add(title);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
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
        return titles;
    }

   @Override
    public void addTitle(Title title) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_TITLE);){
            pstmt.setString(1, title.getEmp_no()+"");
            pstmt.setString(2, title.getTitle());
            pstmt.setString(3, title.getFrom_date()+"");
            pstmt.setString(4, title.getTo_date()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateTitleTitle(Title title, String newTitle){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_TITLE_TITLE);){
            pstmt.setString(1, newTitle);
            pstmt.setString(2, title.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void updateTitleFromDate(Title title, Date newFromDate){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_TITLE_FROM_DATE);){
            pstmt.setString(1, newFromDate+"");
            pstmt.setString(2, title.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void updateTitleToDate(Title title, Date newToDate){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( UPDATE_TITLE_TO_DATE);){
            pstmt.setString(1, newToDate+"");
            pstmt.setString(2, title.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * This method is used to delete departments by department number.
     * @param dept_no of type integer
     */
    @Override
    public void deleteTitle(Title title){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( DELETE_TITLE);){
            pstmt.setString(1, title.getEmp_no()+"");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        }         
    }
    
   
    
    @Override
    public ResultSet getTitleByEmpNo (int emp_no){
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_EMP_ID_TITLE);){
            pstmt.setString(1, emp_no+"");
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            //Logger.getLogger(TitleDAOImpl.class.getDept_name()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
