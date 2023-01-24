package ctrl;

import db.ExecuteDB;
import model.Admin;
import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adminCtrl extends ExecuteDB {
    //  登录方法
    private Admin adminLogin(Admin admin){
        //  读取前端登录页面的信息
        String adminNickName = admin.getAdminNickName();
        String adminPassword = admin.getAdminPassword();

        String sql = "select * from admins where adminNickName = ?,adminpassword = ?";
        Object objects[]={adminNickName,adminPassword};

        ResultSet rs = executeDBQuery(sql,objects);

        try {
            if(rs.next()){
                //  将数据库的数据赋值到对象上
                int adminId = rs.getInt("adminId");
                String adminProfile = rs.getString("adminProfile");
                int adminDepartmentId = rs.getInt("adminDepartmentId");
                int adminStation = rs.getInt("adminStation");
                admin = new Admin(adminId, adminPassword, adminNickName, adminProfile, adminDepartmentId, adminStation);
                return admin;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //  修改管理员信息
    private boolean updateInfo(Admin admin){
        String adminNickName = admin.getAdminNickName();
        String adminPassword = admin.getAdminPassword();
        String adminProfile = admin.getAdminProfile();
        int adminDepartment = admin.getAdminDepartmentId();
        int adminStation = admin.getAdminStation();
        int adminId = admin.getAdminId();

        String sql ="update admins set adminNickName = ?,adminPassword = ?,adminProfile = ?,adminDepartment = ?,adminStation = ? where adminId = ?";
        Object objects[] = {adminNickName,adminPassword,adminProfile,adminDepartment,adminStation,adminId};

        boolean updated = executeDBUpdate(sql,objects);

        return updated;
    }

    //  删除管理员
    private boolean deleteByadminId(int adminId){
        String sql = "delete from admins adminId = ?";
        Object objects[] = {adminId};

        boolean deleted = executeDBUpdate(sql, objects);
        return deleted;
    }

    //  查询本部门员工
    private List<Employee> showEmployees(int departmentId){
        String sql = "select * from employees where departmentId = ?";
        Object objects[] = {departmentId};
        ResultSet rs = executeDBQuery(sql, objects);
        //  实例化 List 集合 Employee 类的一个对象 list
        List<Employee> list = new ArrayList<>();

        try{
            while(rs.next()){
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                String employeePassword = rs.getString("employeePassword");
                int employeeGender = rs.getInt("employeeGender");
                int employeeAge = rs.getInt("employeeAge");
                String employeeProfile = rs.getString("employeeProfile");
                int employeeDepartment = rs.getInt("employeeDepartment");
                String employeePosition = rs.getString("employeePosition");
                int employeeStation = rs.getInt("employeeStation");

                Employee employee = new Employee(employeeId, employeePassword, employeeName, employeeGender, employeeAge, employeeProfile, departmentId, employeePosition, employeeStation);
                list.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    //  超级管理员修改信息功能？？
}
