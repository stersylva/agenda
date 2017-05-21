package com.example.ster_lenovo.cadernocamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ster_lenovo.cadernocamera.dao.CadernoDAO;
import com.example.ster_lenovo.cadernocamera.modelo.Caderno;

public class NovoCadernoActivity extends AppCompatActivity {

    private CadernoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_caderno);

        helper = new CadernoHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Caderno caderno = helper.pegaCaderno();
                CadernoDAO dao = new CadernoDAO(this);
                dao.insere(caderno);
                dao.close();
                Toast.makeText(NovoCadernoActivity.this, "Caderno " + caderno.getNome() +  " Cadastrado!", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
