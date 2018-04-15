package business;

import dataaccess.TitleDAO;
import dataaccess.TitleDAOImp;
import java.sql.Date;
import java.util.List;
import transferobjects.Title;


public class TitleLogic {

    private static final int EMP_NUM_MAX_VALUE = Integer.MAX_VALUE ;
    private static final int TITLE_MAX_LENGTH =50;

    private TitleDAO titleDAO = null;

    public TitleLogic() {
        titleDAO = new TitleDAOImp();
    }

    public List<Title> getAllTitles() {
        return titleDAO.getAllTitles();
    }
    
    public List<Title> getAllDistinctTitles() {
        return titleDAO.getAllDistinctTitles();
    }

    public void addTitle(Title title) {
        cleanTitle(title);
        validateTitle(title);
        titleDAO.addTitle(title);
    }

    private void cleanTitle(Title title) {
        if (title.getTitle() != null) {
            title.setTitle(title.getTitle().trim());
        }
    }

    private void validateTitle(Title title) {
        validateInt(title.getEmp_no(), "Employee number", EMP_NUM_MAX_VALUE, false);
        validateString(title.getTitle(), "Title", TITLE_MAX_LENGTH, false);
        validateDate(title.getFrom_date(),title.getTo_date(), false, true);
    }
    
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        } else if (value.isEmpty()) {
            throw new IllegalStateException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalStateException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
    
    private void validateDate(Date fromDate, Date toDate, boolean isNullAllowedFromDate, boolean isNullAllowedToDate){
        if(fromDate==null && !isNullAllowedFromDate){
            throw new IllegalStateException("from date cannot be null");
        }
        else if(toDate==null && !isNullAllowedToDate){
            throw new IllegalStateException("to date cannot be null");
        }
        else if (fromDate!=null && toDate!=null && toDate.compareTo(fromDate)<=0){
            throw new IllegalStateException("to date has to be after from date");
        }
    }
    
    private void validateInt(Integer value, String fieldName, int maxValue, boolean isNullAllowed){
        if(value == null && !isNullAllowed){
            throw new IllegalStateException(String.format("%s cannot be null", fieldName));
        }
        else if(value > maxValue){
            throw new IllegalStateException(String.format("%s exceeds max value", fieldName));
        }
    }
}
