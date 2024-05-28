package com.henrique.junit;

import com.henrique.junit.DadosLocalizacao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {

    private String nome;

    private String documento;

    private LocalDate nascimento;

    private DadosLocalizacao endereco;

    public Pessoa(final String nome, final String documento, final LocalDate nascimento) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public void adicionaDadosDeEndereco(DadosLocalizacao dadosLocalizacao) {
        this.endereco = dadosLocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }

    public boolean ehMaiorDeIdade() {
        return getIdade() > 18;
    }

    public int getIdade(){
        return (int)ChronoUnit.YEARS.between(this.nascimento, LocalDate.now());
    }
}