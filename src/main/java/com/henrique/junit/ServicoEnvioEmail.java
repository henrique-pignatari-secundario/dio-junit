package com.henrique.junit;

public class ServicoEnvioEmail {
    private PlataformaDeEnvio plataformaDeEnvio;

    public void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHtml){
        Email email = null;

        if(formatoHtml){
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        }else {
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }

        plataformaDeEnvio.enviaEmail(email);
    }
}
