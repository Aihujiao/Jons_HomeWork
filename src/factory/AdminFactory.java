package factory;

import ctrl.AdminCtrl;
import ctrl.dao.AdminDao;

public class AdminFactory {
    private static AdminFactory adminFactory;
    private ctrl.dao.AdminDao adminDao;

    public static AdminFactory instance(){
        if(adminFactory == null){
            AdminFactory adminFactory = new AdminFactory();
        }
        return  adminFactory;
    }

    public AdminDao getAdminDao(){
        if(adminDao == null){
            AdminDao adminDao = new AdminCtrl();
        }
        return adminDao;
    }
}
