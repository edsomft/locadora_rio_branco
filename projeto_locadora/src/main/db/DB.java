package main.db;
import java.sql.*;

public class DB {

    private static Connection conexao =null;

    public static Connection getConexao(){
        if(conexao ==null){
            try {
                conexao = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/locadora_rio_branco","root","edson12@3");
                System.out.println("Conexão bem-sucedida!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conexao;
    }

    public static void closeConexao(){
        if(conexao !=null){
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeStatement(Statement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

