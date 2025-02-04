package main.model.dao;

import main.db.DB;
import main.model.dao.impl.ClienteDaoJDBC;

public interface DaoFactory {

    public static ClienteDao createClienteDao(){
        return new ClienteDaoJDBC(DB.getConexao());
    }

}