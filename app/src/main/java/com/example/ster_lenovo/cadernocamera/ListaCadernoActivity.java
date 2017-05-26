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
        listarCaderno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
              Caderno caderno = (Caderno) listarCaderno.getItemAtPosition(position);

                Toast.makeText(ListaCadernoActivity.this, "Caderno " + caderno.getNome() + " aberto!", Toast.LENGTH_SHORT).show();
                Intent intentVaiProAssunto = new Intent(ListaCadernoActivity.this, ListaAssuntosActivity.class);
                startActivity(intentVaiProAssunto);
            }
        });


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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Caderno caderno = (Caderno) listarCaderno.getItemAtPosition(info.position);

                CadernoDao dao = new CadernoDao(ListaCadernoActivity.this);
                dao.deleta(caderno);
                dao.close();

                Toast.makeText(ListaCadernoActivity.this, "Deletar o caderno " + caderno.getNome(), Toast.LENGTH_SHORT).show();
                carregaLista();
                return false;
            }
        });

    }

}
