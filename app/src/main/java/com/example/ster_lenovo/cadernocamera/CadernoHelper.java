package com.example.ster_lenovo.cadernocamera;


import android.widget.EditText;

import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

public class CadernoHelper {

    private final EditText campoNome;
    private final EditText campoInstiuicao;
    private final EditText campoOrientador;

    public CadernoHelper(NovoCadernoActivity activity){
         campoNome = (EditText) activity.findViewById(R.id.caderno_nome);
         campoInstiuicao = (EditText) activity.findViewById(R.id.caderno_instituicao);
         campoOrientador = (EditText) activity.findViewById(R.id.caderno_orientador);
    }

    public Caderno pegaCaderno() {
        Caderno caderno = new Caderno();
        caderno.setNome(campoNome.getText().toString());
        caderno.setInstituicao(campoInstiuicao.getText().toString());
        caderno.setOrientador(campoOrientador.getText().toString());

        return caderno;
    }
}
