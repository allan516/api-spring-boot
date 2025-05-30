package com.vendas.gestao_vendas.excecao;

public class Erro {
    private String msgUsuario;
    private String msgDesenvolvedor;

    public Erro(String msgUsuario, String msgDesenvolvedor) {
        this.msgUsuario = msgUsuario;
        this.msgDesenvolvedor = msgDesenvolvedor;
    }

    public String getMsgDesenvolvedor() {
        return msgDesenvolvedor;
    }

    public String getMsgUsuario() {
        return msgUsuario;
    }
}
