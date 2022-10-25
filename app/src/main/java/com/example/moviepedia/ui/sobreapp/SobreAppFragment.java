package com.example.moviepedia.ui.sobreapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.telephony.TelephonyCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moviepedia.Login;
import com.example.moviepedia.LoginCadastrar;
import com.example.moviepedia.R;
import com.example.moviepedia.databinding.ActivityHome2Binding;
import com.example.moviepedia.databinding.FragmentSobreAppBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SobreAppFragment extends Fragment {

    FragmentSobreAppBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = FragmentSobreAppBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//
////        mAuth = FirebaseAuth.getInstance();
//
//        binding.logoutApp.setOnClickListener(view1 -> {
////            FirebaseAuth.getInstance().signOut();
//            if (mAuth.getCurrentUser() != null)
//                mAuth.signOut();
//            Intent intent = new Intent(getActivity(), LoginCadastrar.class);
//            startActivity(intent);
//        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sobre_app, container, false);
    }
}