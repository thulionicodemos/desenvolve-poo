package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PessoaTest {
    @Test
    public void testGetNome() {
        // Cria uma instancia da classe pessoa
        Pessoa pessoa1 = new Pessoa("Thulio", null);

        // Verifica se o nome retornado é o mesmo que foi definido
        assertEquals("Thulio", pessoa1.getNome());
    }
}