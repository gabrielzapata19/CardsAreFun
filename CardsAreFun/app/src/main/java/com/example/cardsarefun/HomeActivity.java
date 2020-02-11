package com.example.cardsarefun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button logoutBtn ;
    Button createGameBtn;
    Button joinGameBtn;
    FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createGameBtn = findViewById(R.id.createGameButton);
        joinGameBtn = findViewById(R.id.joainGameButton);
        logoutBtn = findViewById(R.id.logoutBtn);
        FirebaseDatabaseManager.getInstance().getUserSetList();

        createGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,CreateGameActivity.class));
            }
        });

        joinGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,JoinGameActivity.class));
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity( new Intent(HomeActivity.this,LoginActivity.class));
            }
        });



    }





}
