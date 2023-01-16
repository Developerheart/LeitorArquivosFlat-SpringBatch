package com.developer.heart.arquivosflatleitorspringbatch.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    private String nome;
    private String sobrenome;
    private int idade;
    private String email;
    private List<Transacao> transacoes;


    public List<Transacao> getTransacoes() {
        if (transacoes == null)
            transacoes = new ArrayList<>();
        return transacoes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", transacoes=" + transacoes +
                '}';
    }
}
