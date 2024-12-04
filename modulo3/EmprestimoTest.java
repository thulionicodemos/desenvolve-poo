package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class EmprestimoTest {

    @Test
    void testGetAtributosEmprestimo() {
        // Configurando os dados necessários
        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
        Usuario usuario = new Usuario("Gabriel", 21, null);

        // Criando o empréstimo
        Emprestimo emprestimo = new Emprestimo(dataRetirada, dataDevolucao, livro, usuario);

        // Verificando
        assertEquals(dataRetirada, emprestimo.getDataRetirada());
        assertEquals(dataDevolucao, emprestimo.getDataDevolucao());
        assertEquals(livro, emprestimo.getLivro());
        assertEquals(usuario, emprestimo.getUsuario());
    }

    @Test
    void testFormatarData() {
        // Configurando os dados necessários
        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
        Usuario usuario = new Usuario("Gabriel", 21, null);

        // Criando o empréstimo
        Emprestimo emprestimo = new Emprestimo(dataRetirada, dataDevolucao, livro, usuario);

        // Verificando
        String dataFormatada = emprestimo.formatarData(dataRetirada);
        assertNotNull(dataFormatada);
        assertTrue(dataFormatada.matches("\\d{2}/\\d{2}/\\d{4}")); // Verifica se o formato é dd/MM/yyyy
    }

    @Test
    void testImprimirDatas() {
        // Configurando os dados necessários
        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
        Usuario usuario = new Usuario("Gabriel", 21, null);

        // Criando o empréstimo
        Emprestimo emprestimo = new Emprestimo(dataRetirada, dataDevolucao, livro, usuario);

        // Verificando
        emprestimo.imprimirDatas();
    }

    @Test
    void testRealizarEmprestimo() {
        // Configurando os dados necessários
        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
        Usuario usuario = new Usuario("Gabriel", 21, null);

        // Criando o empréstimo
        Emprestimo emprestimo = new Emprestimo(dataRetirada, dataDevolucao, livro, usuario);

        // Testando o empréstimo com livro disponível
        assertTrue(emprestimo.realizarEmprestimo());
        assertFalse(livro.getIsDisponivel());

        // Testando o empréstimo com livro indisponível
        assertFalse(emprestimo.realizarEmprestimo());
    }
}