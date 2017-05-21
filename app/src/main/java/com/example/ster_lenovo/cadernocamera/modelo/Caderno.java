package com.example.ster_lenovo.cadernocamera.modelo;

/**
 * Created by ster-lenovo on 21/05/2017.
 */

public class Caderno {
    private Long id;
    private String nome;
    private String instituicao;
    private String orientador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }
}
