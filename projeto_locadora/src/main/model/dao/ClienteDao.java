package main.model.dao;
import main.model.entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

    void inserir (Cliente cliente) throws SQLException;
    void atualizar (Cliente Cliente);
    void deletarPorID(int id);
    Cliente procurarPorCPF(String Cpf);
    List<Cliente> procurarTodos();

}
