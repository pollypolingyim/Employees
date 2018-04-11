package business;

import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;

public class DepartmentLogic {
	public static final int DEPARTMENT_NAME_MAX_LENGTH = 40;
	
	private DepartmentDAO departmentDAO = null;
	
	public DepartmentLogic() {
		departmentDAO = new DepartmentDAOImp();
	}
}
