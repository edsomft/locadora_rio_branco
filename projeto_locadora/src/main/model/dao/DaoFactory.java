package main.model.dao;

import main.db.DB;
import main.model.dao.impl.UsuarioDaoJDBC;

public interface DaoFactory {

    public static UsuarioDao createUsuarioDao(){
        return new UsuarioDaoJDBC(DB.getConexao());
    }
    //public static FilmeDao creatFilmeDao() { return new FilmeDaoJDBC(DB.getConexao())};
}