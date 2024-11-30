package com.mycompany.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Devido ao método parse, utiliza try-catch para que, se for passad uma data
        no formato incorreto, ex: 21-11-2024, o código exibe um alerta*/
        try{
            //Cria autores
            Autor autor1 = new Autor("Carlos Drummond de Andrade", null, "Brasileira");
            Autor autor2 = new Autor("George R. R. Martin", null, "Norte-Americana");

            //Cria alguns livros
            Livro livro1 = new Livro("Livro 1", "Ficção", true, autor1);
            Livro livro2 = new Livro("Livro 2", "Poesia", true, autor1);
            Livro livro3 = new Livro("Livro 3", "Aventura", true, autor2);
            Livro livro4 = new Livro("Livro 4", "Ação", false, autor2);

            //Define livro para os autores
            autor1.setLivros(new Livro[]{livro1, livro2});
            autor2.setLivros(new Livro[]{livro3, livro4});

            //Cria usuarios
            Usuario usuario1 = new Usuario("Thulio", new Livro[]{livro1, livro2}, 25, null);
            Usuario usuario2 = new Usuario("Julia", new Livro[]{livro3, livro4}, 24, null);

            //Define datas de emprestimo e devolução
            SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");
            Date dataRetirada1 = data_formatada.parse("15/11/2024");
            Date dataDevolucao1 = data_formatada.parse("26/11/2024");

            // Exemplo 1: Empréstimo de um livro disponível
            Emprestimo emprestimo1 = new Emprestimo(dataRetirada1, dataDevolucao1, livro1, usuario1);
            if (emprestimo1.realizarEmprestimo()) {
                usuario1.adicionarEmprestimo(emprestimo1); // Adiciona ao histórico
                emprestimo1.imprimirDatas();
            }

            System.out.println();
            
            // Exemplo 2: Tentativa de empréstimo de um livro indisponível
            Emprestimo emprestimo2 = new Emprestimo(dataRetirada1, dataDevolucao1, livro4, usuario2);
            if (!emprestimo2.realizarEmprestimo()) {
                System.out.println("Não foi possível realizar o empréstimo do livro: " + livro4.getTitulo());
            }
            
            System.out.println();
            
            // Exemplo 3: Exibição dos autores e suas obras
            Autor[] autores = {autor1, autor2};
            for (Autor autor : autores) {
                System.out.println("Autor: " + autor.getNome());
                for (Livro livro : autor.getLivros()) {
                    System.out.println(" Livro: " + livro.getTitulo() + " - Gênero: " + livro.getGenero());
                }
                System.out.println();
            }
            
            System.out.println();
            
            // Exemplo 4: Exibição do histórico de empréstimos de um usuário
            System.out.println("Histórico de Empréstimos do Usuário: " + usuario1.getNome());
            for (Emprestimo emprestimo : usuario1.getHistoricoEmprestimos()) {
                System.out.println(" Livro: " + emprestimo.getLivro().getTitulo() +
                " | Data de Retirada: " + emprestimo.formatarData(emprestimo.getDataRetirada()) +
                " | Data de Devolução: " + emprestimo.formatarData(emprestimo.getDataDevolucao()));
                System.out.println();
            }
         } catch(ParseException e) {
            System.out.println("Erro ao converter datas: " + e.getMessage());
        }
    }
}