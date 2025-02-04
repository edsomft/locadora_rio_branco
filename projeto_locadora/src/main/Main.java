package main;

import main.model.dao.impl.ClienteDaoJDBC;
import main.model.entities.Cliente;

import java.sql.Date;
import java.time.LocalDate;

import static main.db.DB.*;

public class Main {
    public static void main(String[] args) {
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC(getConexao());

        Cliente cliente = new Cliente(); //Criando cliente

        //cliente.setCpf("123.456.789-00");

        /*cliente.setNome("Lara Beatriz");
        cliente.setCpf("123.456.789-00");
        cliente.setData_nascimento(Date.valueOf(LocalDate.of(1995, 8, 15))); // Definindo uma data de nascimento
        cliente.setEndereco("Rua das Flores, 123");
        cliente.setTelefone("91234-5678");
        cliente.setEmail("joao@email.com");
        cliente.setSaldo(500.00f);*/

        //clienteDao.deletarPorID(2);
        //clienteDao.inserir(cliente);
        clienteDao.procurarPorCPF("123.456.789-00");
        closeConexao();

    }
}