package com.henrique.mockito;

import com.henrique.junit.Conta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {
    @Spy
    private Conta conta = new Conta(1_000);

    @Test
    void validarOrdemDeChamadas(){
        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);
    }

    @Test
    void validarQuantidadeDeChamdas(){
        conta.validaSaldo(300);
        conta.validaSaldo(500);
        conta.validaSaldo(600);

        Mockito.verify(conta,Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }

    @Test
    void retornaTrueParaQualquerValorNaValidacaoDeSaldo(){ // ESSE METODO NAO REPRESENTA NADA, SERVE SOMENTE PARA MOSTRAR O doNothing
        Mockito.doNothing().when(conta).validaSaldo(ArgumentMatchers.anyInt());
        conta.validaSaldo(3_500);
    }
}
