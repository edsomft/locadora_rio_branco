package main.model.dao.impl;

import main.db.DB;
import main.model.dao.UsuarioDao;
import main.model.entities.Usuario;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conexao;

    public UsuarioDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Usuario usuario) throws SQLException {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "INSERT INTO Usuarios (nome, email, senha, tipo, username) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setString(4, usuario.getTipo());
            st.setString(5, usuario.getUsername());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
                rs.close();
            } else {
                throw new SQLException("Erro ao inserir usuário!");
            }
        } finally {
            DB.closeStatement(st);
        }
    }
    @Override
    public void atualizar(Usuario usuario){
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "UPDATE Usuarios SET nome = ?, email = ?, senha = ?, tipo = ?, username = ? WHERE id = ?"
            );

            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setString(4, usuario.getTipo());
            st.setString(5, usuario.getUsername());

            st.setInt(6, usuario.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletarPorUsername(String username) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement("DELETE FROM Usuarios WHERE username = ?");
            st.setString(1, username);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Usuario procurarPorUsername(String username) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conexao.prepareStatement("SELECT * FROM Usuarios WHERE username = ?");
            st.setString(1, username);
            rs = st.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setUsername(rs.getString("username"));

                return usuario;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Usuario> procurarTodos() {
        List<Usuario> lista = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexao.createStatement();
            rs = st.executeQuery("SELECT * FROM Usuarios");

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setUsername(rs.getString("username"));

                usuario.setId(rs.getInt("id"));
                lista.add(usuario);
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
