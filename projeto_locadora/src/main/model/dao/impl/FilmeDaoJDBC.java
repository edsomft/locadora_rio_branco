package main.model.dao.impl;

import main.model.dao.FilmeDao;
import main.model.entities.Filme;

import java.util.List;

public class FilmeDaoJDBC implements FilmeDao {

    @Override
    public void inserir(Filme filme) {

    }

    @Override
    public void atualizar(Filme filme) {

    }

    @Override
    public void deletarPorId(Integer id) {

    }

    @Override
    public Filme procurarPorId(Integer id) {
        return null;
    }

    @Override
    public List<Filme> listarTodos() {
        return List.of();
    }
}
