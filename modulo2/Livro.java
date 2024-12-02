package com.mycompany.app;

public class Livro {
    private String titulo;
    private String genero;
    private boolean isDisponivel;
    private Autor autor;

    public Livro(String titulo, Autor autor, String genero, boolean isDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
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

    public String getAutorNome() {
        return (autor != null) ? autor.getNome() : "Autor desconhecido";
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