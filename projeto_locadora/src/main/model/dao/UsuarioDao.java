package main.model.dao;
import main.model.entities.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    void inserir (Usuario usuario) throws SQLException;
    void atualizar (Usuario usuario);
    void deletarPorUsername(String username);
    Usuario procurarPorUsername(String username);
    List<Usuario> procurarTodos();

}
