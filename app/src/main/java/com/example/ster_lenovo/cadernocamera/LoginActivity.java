package com.example.ster_lenovo.cadernocamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button botaoLogar = (Button) findViewById(R.id.btn_entrar);
        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiPraInstituicao = new Intent(LoginActivity.this, InstituicaoActivity.class);
                startActivity(intentVaiPraInstituicao);
            }
        });
    }
}
