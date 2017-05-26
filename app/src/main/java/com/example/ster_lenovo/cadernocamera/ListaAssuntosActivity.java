package com.example.ster_lenovo.cadernocamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ster_lenovo.cadernocamera.dao.AssuntoDao;
import com.example.ster_lenovo.cadernocamera.dao.CadernoDao;
import com.example.ster_lenovo.cadernocamera.modelo.Assunto;
import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

import java.util.List;

public class ListaAssuntosActivity extends AppCompatActivity {

    private ListView listarAssunto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_assuntos);

        listarAssunto = (ListView) findViewById(R.id.listar_assuntos);
        listarAssunto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Assunto assunto = (Assunto) listarAssunto.getItemAtPosition(position);

                Toast.makeText(ListaAssuntosActivity.this, "Assunto " + assunto.getAssunto() + " aberto!", Toast.LENGTH_SHORT).show();
                Intent intentVaiProAssunto = new Intent(ListaAssuntosActivity.this, NovoAssuntoActivity.class);
                startActivity(intentVaiProAssunto);
            }
        });


        Button novoAssunto = (Button) findViewById(R.id.btn_novo_assunto);
        novoAssunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProCadastroAssunto = new Intent(ListaAssuntosActivity.this, NovoAssuntoActivity.class);
                startActivity(intentVaiProCadastroAssunto);
            }


        });

        registerForContextMenu(listarAssunto);
    }

    private void carregaLista() {
        AssuntoDao dao = new AssuntoDao(this);
        List<Assunto> assuntos = dao.buscarAssunto();
        dao.close();


        ArrayAdapter<Assunto> adapter = new ArrayAdapter<Assunto>(this,android.R.layout.simple_list_item_1, assuntos);
        listarAssunto.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Assunto assunto = (Assunto) listarAssunto.getItemAtPosition(info.position);

                AssuntoDao dao = new AssuntoDao(ListaAssuntosActivity.this);
                dao.deleta(assunto);
                dao.close();

                Toast.makeText(ListaAssuntosActivity.this, "Deletar o assunto " + assunto.getAssunto(), Toast.LENGTH_SHORT).show();
                carregaLista();
                return false;
            }
        });
    }
}
