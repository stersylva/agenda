package com.example.ster_lenovo.cadernocamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ster_lenovo.cadernocamera.dao.AssuntoDao;
import com.example.ster_lenovo.cadernocamera.modelo.Assunto;


public class NovoAssuntoActivity extends AppCompatActivity {

    private AssuntoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_assunto);

        helper = new AssuntoHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Assunto assunto = helper.pegaAssunto();
                AssuntoDao dao = new AssuntoDao(this);
                dao.insere(assunto);
                dao.close();

                Toast.makeText(NovoAssuntoActivity.this, "Assunto " + assunto.getAssunto() + " Cadastrado!", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
