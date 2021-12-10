package controller07266;

import core07266.Controller;
import entity07266.AdminEntity07266;
import model07266.AdminModel07266;

public class AdminController07266 extends Controller {

    public int insertData(AdminEntity07266 adminEntity){
        return model(AdminModel07266.class).insertData(adminEntity);
    }

    public int updateData(AdminEntity07266 adminEntity){
        return model(AdminModel07266.class).updateData(adminEntity);
    }

    public AdminEntity07266 login(String nip, String password){
        return model(AdminModel07266.class).login(nip, password);
    }
}
