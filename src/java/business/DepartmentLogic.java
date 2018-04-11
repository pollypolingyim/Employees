package business;

import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;
import java.util.List;
import transferobjects.Department;

public class DepartmentLogic {
	public static final int DEPARTMENT_NAME_MAX_LENGTH = 40;
	
	private DepartmentDAO departmentDAO = null;
	
	public DepartmentLogic() {
                System.out.println("DepartmentLogicConstructor");
		departmentDAO = new DepartmentDAOImp();
	}
        
        public List<Department> getAllDepartments() {
            return departmentDAO.getAllDepartments();
        }
}
