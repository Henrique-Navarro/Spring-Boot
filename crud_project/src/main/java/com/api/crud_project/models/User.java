package com.api.crud_project.models;

import jakarta.persistence.*;

import java.io.Serializable;
//Classe que representa a tabela do banco de dados
@Entity
@SequenceGenerator(name="seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private long id;
    private String nome;
    private int idade;
    private String cpf;
    private double salario;

    //GETTERS E SETTERs
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
