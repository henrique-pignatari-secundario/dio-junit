package com.henrique.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTeste {

    @Test
    void deveCalcularIdadeCorretamente(){
        Pessoa pessoa = new Pessoa("jessica", LocalDate.of(2000, 1, 1));
        Assertions.assertEquals(24, pessoa.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade(){
        Pessoa pessoa = new Pessoa("jessica", LocalDate.of(2000, 1, 1));
        Assertions.assertTrue(pessoa.ehMaiorDeIdade());

        pessoa = new Pessoa("jessica", LocalDate.of(2020, 1,1));
        Assertions.assertFalse(pessoa.ehMaiorDeIdade());
    }
}
