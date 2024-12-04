package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LivroTest {

    @Test
    void testAtributosLivro() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro1 = new Livro("Java Basico", autor, "tecnologia", true);
        Livro livro2 = new Livro("Java Avançado", autor, "tecnologia", false);

        // Teste atributos livro1
        assertEquals("Java Basico", livro1.getTitulo());
        assertEquals("tecnologia", livro1.getGenero());
        assertTrue(livro1.getIsDisponivel());
        assertEquals(autor, livro1.getAutor());

        // Teste atributos livro2
        assertEquals("Java Avançado", livro2.getTitulo());
        assertEquals("tecnologia", livro2.getGenero());
        assertFalse(livro2.getIsDisponivel());
        assertEquals(autor, livro2.getAutor());
    }

    @Test
    void testVerificaDisponibilidade() throws Exception {
        // Criação do autor, livro e datas de empréstimo
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Avançado", autor, "tecnologia", false);

        // Configurando a data de empréstimo simulando indisponibilidade
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEmprestimo = sdf.parse("25/11/2024");
        Date dataDevolucao = sdf.parse("30/11/2024");

        // Criando um empréstimo associado do livro
        Usuario usuario = new Usuario("João", 30, null);
        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, livro, usuario);

        // Testando a indisponibilidade do livro
        assertEquals(
            "O livro está indisponível. Data de empréstimo: 25/11/2024",
            livro.verificaDisponibilidade(emprestimo)
        );

        // Alterando a disponibilidade do livro
        livro.setIsDisponivel(true);
        assertEquals("O livro está disponível", livro.verificaDisponibilidade(emprestimo));
    }

    @Test
    void testGetAutorNome() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Basico", autor, "tecnologia", true);

        // Testando o nome do autor associado ao livro
        assertEquals("Jess", livro.getAutorNome());

        // Testando quando não há autor associado
        livro.setAutor(null);
        assertEquals("Autor desconhecido", livro.getAutorNome());
    }
}