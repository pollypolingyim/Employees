package business;

import data_access.DepartmentDAO;
import data_access.DepartmentDAOImp;

public class SalaryLogic {
	public static final int DEPARTMENT_NAME_MAX_LENGTH = 40;
	
	private DepartmentDAO departmentDAO = null;
	
	public SalaryLogic() {
		departmentDAO = new DepartmentDAOImp();
	}
}
