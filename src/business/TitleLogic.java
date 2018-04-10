package business;

import data_access.DepartmentDAO;
import data_access.DepartmentDAOImp;

public class TitleLogic {
	public static final int DEPARTMENT_NAME_MAX_LENGTH = 40;
	
	private DepartmentDAO departmentDAO = null;
	
	public TitleLogic() {
		departmentDAO = new DepartmentDAOImp();
	}
}
