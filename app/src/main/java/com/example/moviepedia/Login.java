package com.example.moviepedia;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.moviepedia.databinding.ActivityLoginBinding;
import com.example.moviepedia.databinding.ActivityMainBinding;
import com.example.moviepedia.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    GoogleSignInClient googleSignInClient;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();

        binding.botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    loginUsuarioESenha(
                            binding.idNome.getText().toString(),
                            binding.idSenha.getText().toString());
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Preencha o nome de usuário e senha!", Toast.LENGTH_LONG).show();
                }

            }
        });
   }

   private void loginUsuarioESenha(String usuario, String senha){
       mAuth.signInWithEmailAndPassword(usuario, senha)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           //Log.d(TAG, "signInWithCustomToke:success");
                           FirebaseUser user = mAuth.getCurrentUser();
                           Toast.makeText(getApplicationContext(), "Login com sucesso.",Toast.LENGTH_LONG).show();
                           abrePrincipal();
                           finish();
                           //updateUI(user);
                       } else {
                           Log.w(TAG, "signInWithCustomToke:failure", task.getException());
                           Toast.makeText(getApplicationContext(), "Erro ao efetuar o login.", Toast.LENGTH_LONG).show();
                           //updateUI(null);
                       }
                   }
               });
   }

   private void abrePrincipal(){
        binding.idNome.setText("");
        binding.idSenha.setText("");
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish();
   }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        try{
            //Toast.makeText(getApplicationContext(), "Usuário " + currentUser.getEmail() + " logado.",Toast.LENGTH_SHORT).show();
           // abrePrincipal();
            //finish();
        } catch (Exception e) {

        }
        //updateUI(currentUser);
    }
}