package com.mycompany.app;

import java.util.Date;

public class Emprestimo {
    private Date dataRetirada;
    private Date dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(Date dataRetirada, Date dataDevolucao, Livro livro, Usuario usuario) {
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Formata datas para string legível
    public String formatarData(Date data) {
        java.text.SimpleDateFormat data_formatada = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return data_formatada.format(data);
    }

    public void imprimirDatas() {
        System.out.println("Data de Retirada: " + formatarData(dataRetirada));
        System.out.println("Data de Devolução: " + formatarData(dataDevolucao));
    }
    
    public boolean realizarEmprestimo() {
        String disponibilidade = livro.verificaDisponibilidade(this);
        if (!livro.getIsDisponivel()) {
            System.out.println(disponibilidade);
            return false;
        }
        livro.setIsDisponivel(false);
        return true;
    }
}
