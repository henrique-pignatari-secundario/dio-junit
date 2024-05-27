package com.henrique.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTeste {
    @Test
    void validarCenariosDeExcecaoNaTransferencia(){
        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();
        Assertions.assertThrows(IllegalArgumentException.class,() -> transferenciaEntreContas.transfere(-1));
    }
}
