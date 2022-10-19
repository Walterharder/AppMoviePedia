package com.example.moviepedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.moviepedia.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AberturaActivity extends AppCompatActivity implements Runnable {

    Thread thread;
    Handler handler;
    int i;
    private FirebaseAuth mAuth;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {

        i = 1;

        try{
            while(i<100){
                Thread.sleep(15);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                    }
                });
            }
        }catch (Exception e){

        }
        startActivity(new Intent(this, LoginCadastrar.class));

    }

//    private void abrePrincipal(){
//        binding.idNome.setText("");
//        binding.idSenha.setText("");
//        Intent intent = new Intent(getApplicationContext(), Home.class);
//        startActivity(intent);
//        finish();
//    }
    
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        try{
//            Toast.makeText(getApplicationContext(), "Usuário " + currentUser.getEmail() + " logado.",Toast.LENGTH_SHORT).show();
//            abrePrincipal();
//            finish();
//        } catch (Exception e) {
//
//        }
//        //updateUI(currentUser);
//    }
    
}


