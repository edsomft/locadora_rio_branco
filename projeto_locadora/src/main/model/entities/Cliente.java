package main.model.entities;

import java.util.Date;

public class Cliente {
    private int cliente_id;
    private String nome;
    private String cpf;
    private java.sql.Date data_nascimento;
    private String endereco;
    private String telefone;
    private String email;
    private float saldo;

    public int getCliente_id() {
        return cliente_id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public java.sql.Date getData_nascimento() {
        return data_nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setData_nascimento(java.sql.Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
