package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void testAtributosUsuario() {
        // Criando um usuário com histórico vazio
        Usuario usuario = new Usuario("Carlos", 30, null);

        // Verificando os atributos do usuário
        assertEquals("Carlos", usuario.getNome());
        assertEquals(30, usuario.getIdade());
        assertNotNull(usuario.getHistoricoEmprestimos());
        assertEquals(0, usuario.getHistoricoEmprestimos().length);
    }

    @Test
    void testAdicionarEmprestimo() {
        // Configurando dados para o teste
        Autor autor = new Autor("George Orwell", "Inglês");
        Livro livro = new Livro("1984", autor, "Ficção", true);
        Emprestimo emprestimo = new Emprestimo(new java.util.Date(), new java.util.Date(), livro, null);

        Usuario usuario = new Usuario("Alice", 25, null);

        // Adicionando um empréstimo ao histórico
        usuario.adicionarEmprestimo(emprestimo);

        // Verificando o histórico atualizado
        Emprestimo[] historico = usuario.getHistoricoEmprestimos();
        assertEquals(1, historico.length);
        assertEquals(emprestimo, historico[0]);

        // Adicionando outro empréstimo
        Livro outroLivro = new Livro("Revolução dos Bichos", autor, "Ficção", true);
        Emprestimo outroEmprestimo = new Emprestimo(new java.util.Date(), new java.util.Date(), outroLivro, null);

        usuario.adicionarEmprestimo(outroEmprestimo);

        // Verificando o histórico novamente
        historico = usuario.getHistoricoEmprestimos();
        assertEquals(2, historico.length);
        assertEquals(outroEmprestimo, historico[1]);
    }

    @Test
    void testHistoricoEmprestimosInicializado() {
        // Criando um usuário com um histórico de empréstimos inicial
        Autor autor = new Autor("Jane Austen", "Inglesa");
        Livro livro = new Livro("Orgulho e Preconceito", autor, "Romance", true);
        Emprestimo emprestimoInicial = new Emprestimo(new java.util.Date(), new java.util.Date(), livro, null);

        Emprestimo[] historicoInicial = {emprestimoInicial};
        Usuario usuario = new Usuario("Maria", 28, historicoInicial);

        // Verificando o histórico inicial
        Emprestimo[] historico = usuario.getHistoricoEmprestimos();
        assertEquals(1, historico.length);
        assertEquals(emprestimoInicial, historico[0]);
    }
}
