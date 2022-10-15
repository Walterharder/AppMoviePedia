package com.example.moviepedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cadastrar extends AppCompatActivity {

    private Button id_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        id_confirmar = findViewById(R.id.id_confirmar);

        id_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent id_confirmar = new Intent(Cadastrar.this, Home.class);
                startActivity(id_confirmar);
            }
        });

    }
}