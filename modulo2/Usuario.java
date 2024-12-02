package com.mycompany.app;

public class Usuario extends Pessoa {
    private int idade;
    private Emprestimo[] historicoEmprestimos;

    public Usuario(String nome, int idade, Emprestimo[] historicoEmprestimos) {
        super(nome);
        this.idade = idade;
        this.historicoEmprestimos = historicoEmprestimos != null ? historicoEmprestimos : new Emprestimo[0];
    }

    public int getIdade() {
        return idade;
    }

    public Emprestimo[] getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimo(Emprestimo novoEmprestimo) {
        Emprestimo[] novoHistorico = new Emprestimo[historicoEmprestimos.length + 1];
        System.arraycopy(historicoEmprestimos, 0, novoHistorico, 0, historicoEmprestimos.length);
        novoHistorico[historicoEmprestimos.length] = novoEmprestimo;
        historicoEmprestimos = novoHistorico;
    }
}