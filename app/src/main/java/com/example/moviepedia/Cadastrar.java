package com.example.moviepedia;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.moviepedia.databinding.ActivityCadastrarBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Cadastrar extends AppCompatActivity {

//    private Button id_confirmar;
    ActivityCadastrarBinding binding;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCadastrarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        id_confirmar = findViewById(R.id.id_confirmar);
        mAuth = FirebaseAuth.getInstance();

//        id_confirmar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent id_confirmar = new Intent(Cadastrar.this, Home.class);
//                startActivity(id_confirmar);
//            }
//        });

        binding.idConfirmar.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(binding.idEmailCadastro.getText())){
                binding.idEmailCadastro.setError("Informe o E-mail para cadastro!");
                Toast.makeText(getApplicationContext(),"Preencha o E-mail!", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(binding.idSenhaCadastro.getText())){
                binding.idSenhaCadastro.setError("Informe a senha para cadastro!");
                Toast.makeText(getApplicationContext(),"Preencha a senha!", Toast.LENGTH_LONG).show();
            } else {
                criarUsuarioeSenha(binding.idEmailCadastro.getText().toString(), binding.idSenhaCadastro.getText().toString());
            }
        });

    }

    private void criarUsuarioeSenha(String usuario, String senha){
        mAuth.createUserWithEmailAndPassword(usuario, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso.",Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Log.w(TAG, "signInWithCustomToke:failure", task.getException());
                    Toast.makeText(getApplicationContext(), "Erro ao cadastrar usuário.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpaCampos(){
        binding.idEmailCadastro.setText(" ");
        binding.idSenhaCadastro.setText(" ");
    }
}