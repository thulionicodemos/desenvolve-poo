package com.mycompany.app;

public class Autor extends Pessoa{
    private String nacionalidade;

    public Autor(String nome, Livro[] livros, String nacionalidade) {
        super(nome);
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}