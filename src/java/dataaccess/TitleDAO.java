package dataaccess;

import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;

import transferobjects.Title;

/**
 * This is an interface for the Title DAO
 *
 * @author Shawn Pottle
 * @author Polly Yim
 * @author Aleksandar Krumov
 */
public interface TitleDAO {
	/**
	 * This method is used to retrieve a list all titles.
	 * @return List of generic type <Title>
	 */
	public List<Title> getAllTitles();
        
        public List<Title> getAllDistinctTitles();
	/**
	 * This method is used to add title to the Title table.
	 * @param emp_no of type integer
	 * @param title of type String
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addTitle(Title title);
	/**
	 * This method is used to update a title in the title table.
	 * @param emp_no of type integer
	 * @param title of type String
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateTitleTitle(Title title, String newTitle);
        public void updateTitleFromDate (Title title, Date newFromDate);
        public void updateTitleToDate(Title title, Date newToDate);
	/**
	 * This method is used to delete a title from the title table
	 * @param emp_no of type integer
	 * @param from_date of reference type Date
	 */
	public void deleteTitle(Title title);
        
        public ResultSet getTitleByEmpNo (int emp_no);
}
