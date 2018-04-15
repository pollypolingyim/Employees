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
     *
     * @return List of generic type {@link Title}
     */
    public List<Title> getAllTitles();

    /**
     * This method is used to add title to the Title table.
     *
     * @param title of type {@link Title}
     */
    public void addTitle(Title title);

    /**
     * This method is used to update a title in the title table.
     *
     * @param title of type {@link Title}
     * @param newTitle of type String
     */
    public void updateTitleTitle(Title title, String newTitle);

    /**
     * This method is used to update a title in the title table.
     *
     * @param title of type {@link Title}
     * @param newFromDate of type Date
     */
    public void updateTitleFromDate(Title title, Date newFromDate);

    /**
     * This method is used to update a title in the title table.
     *
     * @param title of type {@link Title}
     * @param newToDate of type Date
     */
    public void updateTitleToDate(Title title, Date newToDate);

    /**
     * This method is used to delete a title from the title table
     *
     * @param title of type {@link Title}
     */
    public void deleteTitle(Title title);

    /**
     * This method is used to get a title by employee number.
     *
     * @param emp_no of type integer
     * @return ResultSet
     */
    public ResultSet getTitleByEmpNo(int emp_no);
}
