package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.Title;
/**
 * This is an interface for the Title DAO
 * @author Shawn Pottle
 * @author Polly Yum
 * @author Aleksandar Krumov
 */
public interface TitleDAO {
	/**
	 * This method is used to retrieve a list all titles.
	 * @return List of generic type <Title>
	 */
	public List<Title> getAllTitles();
	/**
	 * This method is used to add a title to the title table
	 * @param emp_no of type integer
	 * @param title of type String
	 * @param from_date of reference type Date
	 */
	public void addTitle(int emp_no, String title, Date from_date);
	/**
	 * This method is used to add title to the Title table.
	 * @param emp_no of type integer
	 * @param title of type String
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void addTitle(int emp_no, String title, Date from_date, Date to_date);
	/**
	 * This method is used to update a title in the title table.
	 * @param emp_no of type integer
	 * @param title of type String
	 * @param from_date of reference type Date
	 * @param to_date of reference type Date
	 */
	public void updateTitle(int emp_no, String title, Date from_date, Date to_date);
	/**
	 * This method is used to delete a title from the title table
	 * @param emp_no of type integer
	 * @param from_date of reference type Date
	 */
	public void deleteTitle(int emp_no, Date from_date);
}
