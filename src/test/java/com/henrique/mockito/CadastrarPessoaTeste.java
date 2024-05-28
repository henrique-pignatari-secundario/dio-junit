package com.henrique.mockito;

import com.henrique.junit.ApiDosCorreios;
import com.henrique.junit.CadastrarPessoa;
import com.henrique.junit.DadosLocalizacao;
import com.henrique.junit.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosdeCadastro(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "guaratingueta", "Rua 1", "casa", "bairro");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);

        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("nome", "123", LocalDate.now(), "123");

        Assertions.assertEquals("nome", pessoa.getNome());
        Assertions.assertEquals("123", pessoa.getDocumento());
        Assertions.assertEquals("SP", pessoa.getEndereco().getUf());
        Assertions.assertEquals("casa", pessoa.getEndereco().getComplemento());
    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios(){
//        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
        Mockito.doThrow(IllegalArgumentException.class)
                        .when(apiDosCorreios)
                                .buscaDadosComBaseNoCep(anyString());

        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("nome", "123", LocalDate.now(), "123"));
    }
}
