package main.model.dao.impl;

import main.db.DB;
import main.model.dao.ClienteDao;
import main.model.entities.Cliente;

import java.net.StandardSocketOptions;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection conexao;

    public ClienteDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Cliente a) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement("insert into clientes(Cli_Nome, Cli_CPF, Cli_DtNasc, Cli_End, Cli_Tel, Cli_Email, Cli_Debito)" +
                    "values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, a.getNome());
            st.setString(2, a.getCpf());
            st.setDate(3, a.getData_nascimento());
            st.setString(4, a.getEndereco());
            st.setString(5, a.getTelefone());
            st.setString(6, a.getEmail());
            st.setFloat(7, a.getSaldo());

            int linhasAfetadas = st.executeUpdate(); //verificar linhas afetadas no banco

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int cliente_id = rs.getInt(1);
                    a.setCliente_id(cliente_id);
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public void atualizar(Cliente a) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "UPDATE clientes " +
                            "SET Cli_nome = ?, " +
                            "Cli_cpf = ?,"+
                            "Cli_DtNasc = ?,"+
                            "Cli_End = ?,"+
                            "Cli_Tel = ?," +
                            "Cli_Email = ?," +
                            "Cli_Debito = ?" +
                            "WHERE Cli_Cpf = ?");

            st.setString(1, a.getNome());
            st.setString(2, a.getCpf());
            st.setDate(3, a.getData_nascimento());
            st.setString(4, a.getEndereco());
            st.setString(5, a.getTelefone());
            st.setString(6, a.getEmail());
            st.setFloat(7, a.getSaldo());
            st.setString(8, a.getCpf());
            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno", e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletarPorID(int id) {

        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "DELETE FROM clientes WHERE Cli_Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir aluno", e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Cliente procurarPorCPF(String cpf) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st=conexao.prepareStatement("SELECT * FROM clientes WHERE Cli_Cpf = ?");

            st.setString(1, cpf);

            rs = st.executeQuery();
            if (rs.next()) {
                Cliente a = new Cliente();
                a.setCliente_id(rs.getInt("Cli_Id"));
                a.setNome(rs.getString("Cli_Nome"));
                a.setCpf(rs.getString("Cli_Cpf"));
                a.setData_nascimento(rs.getDate("Cli_DtNasc"));
                a.setEndereco(rs.getString("Cli_End"));
                a.setTelefone(rs.getString("Cli_Tel"));
                a.setEmail(rs.getString("Cli_Email"));
                a.setSaldo(rs.getFloat("Cli_Debito"));

                System.out.println(a.getCliente_id());
                System.out.println(a.getNome());
                System.out.println(a.getCpf());
                System.out.println(a.getData_nascimento());
                System.out.println(a.getEndereco());
                System.out.println(a.getTelefone());
                System.out.println(a.getEmail());
                System.out.println(a.getSaldo());

                return a;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao procurar aluno por ID", e);

        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);


        }
    }

    @Override
    public List<Cliente> procurarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement(
                    "SELECT * FROM clientes ORDER BY Cli_Id");
            rs = st.executeQuery();

            List<Cliente> lista = new ArrayList<>();

            while (rs.next()) {
                Cliente a = new Cliente();
                a.setCliente_id(rs.getInt("Cli_Id"));
                a.setNome(rs.getString("Cli_Nome"));
                a.setCpf(rs.getString("Cli_Cpf"));
                a.setData_nascimento(rs.getDate("Cli_DtNasc"));
                a.setEndereco(rs.getString("Cli_End"));
                a.setTelefone(rs.getString("Cli_Tel"));
                a.setEmail(rs.getString("Cli_Email"));
                a.setSaldo(rs.getFloat("Cli_Debito"));
                lista.add(a);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
