package com.example.ster_lenovo.cadernocamera;

import android.widget.EditText;

import com.example.ster_lenovo.cadernocamera.modelo.Assunto;
import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

/**
 * Created by ster-lenovo on 25/05/2017.
 */

public class AssuntoHelper {
    private final EditText campoAssunto;
    private final EditText campoConteudo;

    public AssuntoHelper(NovoAssuntoActivity activity){
        campoAssunto = (EditText) activity.findViewById(R.id.assunto_nome);
        campoConteudo = (EditText) activity.findViewById(R.id.assunto_conteudo);
    }

    public Assunto pegaAssunto() {
        Assunto assunto = new Assunto();
        assunto.setAssunto(campoAssunto.getText().toString());
        assunto.setConteudo(campoConteudo.getText().toString());

        return assunto;
    }
}
