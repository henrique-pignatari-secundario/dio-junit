package com.henrique.junit;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class EscolhendoAOrdemTeste {

    @DisplayName("A")
    @Order(4)
    @Test
    void validaFluxoA(){
        Assertions.assertTrue(true);
    }

    @DisplayName("B")
    @Order(3)
    @Test
    void validaFluxoB(){
        Assertions.assertTrue(true);
    }

    @DisplayName("C")
    @Order(2)
    @Test
    void validaFluxoC(){
        Assertions.assertTrue(true);
    }

    @DisplayName("D")
    @Order(1)
    @Test
    void validaFluxoD(){
        Assertions.assertTrue(true);
    }
}
