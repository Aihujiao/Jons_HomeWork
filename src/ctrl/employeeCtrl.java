package ctrl;

import db.ExecuteDB;
import model.Department;
import model.Employee;

public class employeeCtrl extends ExecuteDB{
    //  为部门添加员工
    private boolean addEmployee(Employee employee){
        String sql = "insert into employees value(null,?,?,?,?,?,?,?,?)";
        String employeeName = employee.getEmployeeName();
        String employeePassword =employee.getEmployeePassword();
        int employeeGender = employee.getEmployeeGender();
        int employeeAge = employee.getEmployeeAge();
        String employeeProfile = employee.getEmployeeProfile();
        int employeeDepartmentId = employee.getDepartmentId();
        String employeePosition = employee.getEmployeePosition();
        int employeeStation = employee.getEmployeeStation();

        Object objects[] = {employeeName,employeePassword,employeeGender,employeeAge,employeeProfile,employeeDepartmentId,employeePosition,employeeStation};
        boolean added = executeDBUpdate(sql, objects);

        return added;
    }

    //  更新员工信息
    private boolean updateEmployee(Employee employee){
        String sql = "update employees set employeeName = ?,employeePassword = ?,employeeGender = ?,employeeAge = ?,employeeProfile = ?,employeeDepartmentId = ?,employeePosition = ?,employeeStation = ? where employeeId = ?";
        String employeeName = employee.getEmployeeName();
        String employeePassword =employee.getEmployeePassword();
        int employeeGender = employee.getEmployeeGender();
        int employeeAge = employee.getEmployeeAge();
        String employeeProfile = employee.getEmployeeProfile();
        int employeeDepartmentId = employee.getDepartmentId();
        String employeePosition = employee.getEmployeePosition();
        int employeeStation = employee.getEmployeeStation();
        int employeeId = employee.getEmployeeId();

        Object objects[] ={employeeName,employeePassword,employeeGender,employeeAge,employeeProfile,employeeDepartmentId,employeePosition,employeeStation,employeeId};
        boolean updated = executeDBUpdate(sql, objects);

        return updated;
    }

    //  查询员工信息
    private Employee getEmployeeInfor(int employeeId){
        Employee employee = new Employee();
        return employee;
    }
}
