package com.salcisne.androidteste.model;

public class Produto {
    private String nome;
    private String local;
    private Integer quantidade;

    public Produto(String nome, String local, int quantidade) {
        this.nome = nome;
        this.local = local;
        this.quantidade = quantidade;
    }
    public Produto(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
