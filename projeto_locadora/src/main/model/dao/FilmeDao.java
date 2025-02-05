package main.model.dao;

import main.model.entities.Filme;

import java.util.List;

public interface FilmeDao {

    void inserir(Filme filme);
    void atualizar(Filme filme);
    void deletarPorId(Integer id);
    Filme procurarPorId(Integer id);
    List<Filme> listarTodos();

}
