package com.example.ster_lenovo.cadernocamera.modelo;

/**
 * Created by ster-lenovo on 25/05/2017.
 */

public class Assunto {
    private Long id;
    private String assunto;
    private String conteudo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString(){
        return getId() + " - " + getAssunto();
    }
}
