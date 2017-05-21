package com.example.ster_lenovo.cadernocamera;

import android.widget.EditText;

import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

/**
 * Created by ster-lenovo on 20/05/2017.
 */

public class CadernoHelper {

    private final EditText campoNome;
    private final EditText campoInstituicao;
    private final EditText campoOrientador;

    public CadernoHelper(NovoCadernoActivity cadernoActivity) {
        campoNome = (EditText) cadernoActivity.findViewById(R.id.caderno_nome);
        campoInstituicao = (EditText) cadernoActivity.findViewById(R.id.caderno_instituicao);
        campoOrientador = (EditText) cadernoActivity.findViewById(R.id.caderno_orientador);
    }

    public Caderno pegaCaderno() {
        Caderno caderno = new Caderno();
        caderno.setNome(campoNome.getText().toString());
        caderno.setInstituicao(campoInstituicao.getText().toString());
        caderno.setOrientador(campoOrientador.getText().toString());

        return caderno;
    }
}
