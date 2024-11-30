package com.mycompany.app;

public class Livro {
    private String titulo;
    private String genero;
    private boolean isDisponivel;
    private Autor autor;

    public Livro(String titulo, String genero, boolean isDisponivel, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.isDisponivel = isDisponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public boolean getIsDisponivel() {
        return isDisponivel;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    //Verifica se o livro está disponível
    public String verificaDisponibilidade(Emprestimo emprestimoAtual) {
        if (!isDisponivel) {
            return "O livro está indisponível. Data de empréstimo: " +
                    emprestimoAtual.formatarData(emprestimoAtual.getDataRetirada());
        }
        return "O livro está disponível";
    }
}