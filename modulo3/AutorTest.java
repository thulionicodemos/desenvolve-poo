package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    @Test
    void testGetNomeAutor() {
        // Criando um autor
        Autor autor = new Autor("Machado de Assis", "Brasileira");

        // Verificando os atributos
        assertEquals("Machado de Assis", autor.getNome());
        assertEquals("Brasileira", autor.getNacionalidade());
    }

    @Test
    void testSetNomeAutor() {
        // Criando um autor
        Autor autor = new Autor("J. K. Rowling", "Britânica");

        // Atualizando o nome do autor
        autor.setNome("Joanne Rowling");

        // Verificando a atualização
        assertEquals("Joanne Rowling", autor.getNome());
    }

    @Test
    void testLivros() {
        // Criando livros
        Livro livro1 = new Livro("Dom Casmurro", null, "Romance", true);
        Livro livro2 = new Livro("Memórias Póstumas de Brás Cubas", null, "Romance", true);

        // Criando um array de livros e associando ao autor
        Livro[] livros = {livro1, livro2};
        Autor autor = new Autor("Machado de Assis", "Brasileira");
        autor.setLivros(livros);

        // Verificando os livros associados
        assertNotNull(autor.getLivros());
        assertEquals(2, autor.getLivros().length);
        assertEquals("Dom Casmurro", autor.getLivros()[0].getTitulo());
        assertEquals("Memórias Póstumas de Brás Cubas", autor.getLivros()[1].getTitulo());
    }

    @Test
    void testNacionalidade() {
        // Criando um autor com nacionalidade desconhecida
        Autor autor = new Autor("Desconhecido", null);

        // Verificando o comportamento com nacionalidade nula
        assertNull(autor.getNacionalidade());
    }
}