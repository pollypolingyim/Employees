package data_access;

import java.sql.Date;
import java.util.List;

import transfer_object.Title;

public interface TitleDAO {
	public List<Title> getAllTitles();
	public void addTitle(int emp_no, String title, Date from_date);
	public void addTitle(int emp_no, String title, Date from_date, Date to_date);
	public void updateTitle(int emp_no, String title, Date from_date, Date to_date);
	public void deleteTitle(int emp_no, Date from_date);
}
