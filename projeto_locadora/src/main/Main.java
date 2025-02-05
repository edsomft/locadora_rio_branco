package main;

import main.model.dao.impl.UsuarioDaoJDBC;
import main.model.entities.Usuario;

import java.sql.SQLException;

import static main.db.DB.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDaoJDBC usuarioDao = new UsuarioDaoJDBC(getConexao());

        /*Usuario cliente = new Usuario();
        cliente.setNome("João Silva");
        cliente.setEmail("joão@gmail.com");
        cliente.setSenha("1234");
        cliente.setTipo("cliente");
        cliente.setUsername("Joaopombao");

        usuarioDao.inserir(cliente);

        System.out.println("Cliente cadastrado: " + cliente.getNome());*/

        Usuario admin = new Usuario();
        admin.setNome("Maria Silva");
        admin.setEmail("maria@gmail.com");
        admin.setSenha("4321");
        admin.setTipo("admin");
        admin.setUsername("mariaprikituda");
        usuarioDao.inserir(admin);
        System.out.println("Administrador cadastrado: " + admin.getNome());

    }
}