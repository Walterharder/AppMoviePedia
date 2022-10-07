package com.example.moviepedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginCadastrar extends AppCompatActivity {

    private Button botaoLogin;
    private Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cadastrar);

        botaoLogin = findViewById(R.id.id_login);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(LoginCadastrar.this,Login.class);
                startActivity(login);
            }
        });

        botaoCadastrar = findViewById(R.id.id_cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrar = new Intent(LoginCadastrar.this,Cadastrar.class);
                startActivity(cadastrar);
            }
        });

     }



}