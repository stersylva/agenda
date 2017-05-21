package com.example.ster_lenovo.cadernocamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ster_lenovo.cadernocamera.dao.CadernoDao;
import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

import java.util.List;

public class ListaCadernoActivity extends AppCompatActivity {

    private ListView listarCaderno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_caderno);

        listarCaderno = (ListView) findViewById(R.id.listar_caderno);
        Button novoCardeno = (Button) findViewById(R.id.btn_novo_caderno);
        novoCardeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProCadastroCaderno = new Intent(ListaCadernoActivity.this, NovoCadernoActivity.class);
                startActivity(intentVaiProCadastroCaderno);
            }


        });

        registerForContextMenu(listarCaderno);
    }

    private void carregaLista() {
        CadernoDao dao = new CadernoDao(this);
        List<Caderno> cadernos = dao.buscarCadernos();
        dao.close();


        ArrayAdapter<Caderno> adapter = new ArrayAdapter<Caderno>(this,android.R.layout.simple_list_item_1, cadernos);
        listarCaderno.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

}
