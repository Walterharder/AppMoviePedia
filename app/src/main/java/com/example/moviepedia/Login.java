package com.example.moviepedia;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.moviepedia.databinding.ActivityLoginBinding;
import com.example.moviepedia.databinding.ActivityMainBinding;
import com.example.moviepedia.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login extends AppCompatActivity{

    ActivityLoginBinding binding;
//    GoogleSignInClient googleSignInClient;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("739273654615-ip43k7h96jatquhubohp6eb3p1ap6s6s.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso);
//
        binding.botaoEntrar.setOnClickListener(view12 -> {

            if (TextUtils.isEmpty(binding.idNome.getText())){
                binding.idNome.setError("Usuário não pode estar em branco.");
                Toast.makeText(getApplicationContext(),"Preencha o nome de usuário!", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(binding.idSenha.getText())){
                binding.idSenha.setError("Senha não pode estar em branco.");
                Toast.makeText(getApplicationContext(),"Preencha a senha do usuário!", Toast.LENGTH_LONG).show();
            } else {
                loginUsuarioESenha(binding.idNome.getText().toString(), binding.idSenha.getText().toString());
            }
                try{
                    loginUsuarioESenha(
                            binding.idNome.getText().toString(),
                            binding.idSenha.getText().toString());
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Preencha o nome de usuário e senha!", Toast.LENGTH_LONG).show();
                }

        });
//
//        binding.botaoGoogle.setOnClickListener(view1 -> {
//            signIn();
//        });
   }

//    private void signIn(){
//        Intent intent = googleSignInClient.getSignInIntent();
//        startActivityForResult(intent, 1);
//    }

//    private void loginComGoogle(String token){
//        AuthCredential credencial = GoogleAuthProvider.getCredential(token,null);
//
//        mAuth.signInWithCredential(credencial).addOnCompleteListener(this, task -> {
//            if (task.isSuccessful()){
//                Toast.makeText(getApplicationContext(), "Login com Google efetuado com sucesso.",Toast.LENGTH_LONG).show();
//                abrePrincipal();
//                finish();
//            } else {
//                Toast.makeText(getApplicationContext(), "Erro ao efetuar login com Google.",Toast.LENGTH_LONG).show();
//            }
//        });
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent intent){
//        super.onActivityResult(requestCode, resultCode, intent);
//
//        if (requestCode == 1){
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(intent);
//            try {
//                GoogleSignInAccount conta = task.getResult(ApiException.class);
//                loginComGoogle(conta.getIdToken());
//            } catch (ApiException exception){
//                Toast.makeText(getApplicationContext(), "Nenhum usuário Google logado no dispositivo.",Toast.LENGTH_LONG).show();
//                Log.d("Erro: ",exception.toString());
//            }
//        }
//    }

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
        binding.idNome.setText(" ");
        binding.idSenha.setText(" ");
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);

   }



    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        try{
//            Toast.makeText(getApplicationContext(), "Usuário " + currentUser.getEmail() + " logado.",Toast.LENGTH_SHORT).show();
//            abrePrincipal();


        } catch (Exception e) {

        }
        //updateUI(currentUser);
    }
}