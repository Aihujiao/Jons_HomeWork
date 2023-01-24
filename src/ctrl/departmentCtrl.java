package ctrl;

import db.ExecuteDB;
import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class departmentCtrl extends ExecuteDB {
    //  添加部门
    private boolean addDepartment (Department department){
        String sql = "insert into departments value (null,?,?,?)";
        int departmentAdminId = department.getDepartmentAdminId();
        String departmentName = department.getDepartmentName();
        String departmentIntro = department.getDepartmentIntro();
        Object objects[] = {departmentAdminId,departmentName,departmentIntro};

        boolean added = executeDBUpdate(sql, objects);

        return  added;
    }

    //  修改部门信息
    private boolean updateDepartment(Department department){
        String sql = "update departments set departmentAdminId = ?,departmentName =?,departmentIntro = ? where departmentId = ?";
        int departmentId = department.getDepartmentId();
        int departmentAdminId = department.getDepartmentAdminId();
        String departmentName = department.getDepartmentName();
        String departmentIntro = department.getDepartmentIntro();

        Object objects[] = {departmentAdminId,departmentName,departmentIntro,departmentId};
        boolean updated = executeDBUpdate(sql, objects);

        return updated;
    }

    //  查询部门信息
    private Department getDepartmentInforById(int departmentId){
        Department department = new Department();
        String sql = "select * from departments where departmentId = ?";

        Object objects[] = {departmentId};
        ResultSet rs = executeDBQuery(sql, objects);

        try {
            if (rs.next()){
                int departmentAdminId = rs.getInt("departmentId");
                String departmentName = rs.getString("departmentName");
                String departmentIntro = rs.getString("departmentIntro");
                department = new Department(departmentId, departmentAdminId, departmentName, departmentIntro);
            }else{

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return department;
    }
}
