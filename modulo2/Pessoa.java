package com.mycompany.app;

public class Pessoa {
    private String nome;
    private Livro[] livros;

    public Pessoa(String nome) {
        this.nome = nome;
        this.livros = null;
    }

    public String getNome() { //Getter nome
        return nome;
    }

    public void setNome(String nome) { //Setter nome
        this.nome = nome;
    }

    public Livro[] getLivros() { //Getter livro
        return livros;
    }

    public void setLivros(Livro[] livros) { //Setter livro
        this.livros = livros;
    }
}