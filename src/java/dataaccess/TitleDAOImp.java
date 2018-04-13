package dataaccess;

import java.sql.Date;
import java.util.List;

import transferobjects.Title;
/**
 * This class implements the {@link TitleDAO} interface.
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public class TitleDAOImp implements TitleDAO {
    /**
     * This method overrides the {@link TitleDAO} getAllTitles method.
     *
     * @return list of {@link Title} objects
     */
	@Override
	public List<Title> getAllTitles() {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * This method overrides the {@link TitleDAO} addTitle method.
     *
     * @param emp_no of type integer
     * @param title of type String
     * @param from_date of reference type Date
     */
	@Override
	public void addTitle(int emp_no, String title, Date from_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link TitleDAO} addTitle method.
     *
     * @param emp_no of type integer
     * @param title of type String
     * @param from_date of reference type Date
     * @param to_date of reference type Date
     */
	@Override
	public void addTitle(int emp_no, String title, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link TitleDAO} updateTitle method.
     *
     * @param emp_no of type integer
     * @param title of type String
     * @param from_date of reference type Date
     * @param to_date of reference type Date
     */
	@Override
	public void updateTitle(int emp_no, String title, Date from_date, Date to_date) {
		// TODO Auto-generated method stub

	}
    /**
     * This method overrides the {@link TitleDAO} deleteTitle method.
     *
     * @param emp_no of type integer
     * @param from_date of reference type Date
     */
	@Override
	public void deleteTitle(int emp_no, Date from_date) {
		// TODO Auto-generated method stub

	}

}
