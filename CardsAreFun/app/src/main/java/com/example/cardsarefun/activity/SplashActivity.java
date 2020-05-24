package com.example.cardsarefun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cardsarefun.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth myFirebasAuth;
    private static int SPLASH_TIMR_OUT = 3000;
    @Override
    protected void onStart() {
        super.onStart();
        //Going to do something with this. Load current user if already logined in
        //FirebaseUser currentUser = myFirebasAuth.getCurrentUser();
        //Then load the users card info for later
        //Hello there
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        }, SPLASH_TIMR_OUT);



    }
}
