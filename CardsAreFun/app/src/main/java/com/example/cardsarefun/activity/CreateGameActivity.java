package com.example.cardsarefun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.cardsarefun.util.FirebaseDatabaseManager;
import com.example.cardsarefun.pojos.Game;
import com.example.cardsarefun.R;

public class CreateGameActivity extends AppCompatActivity {

    Button mainMenuBtn;
    Button createGameBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        mainMenuBtn = findViewById(R.id.mainMenuButton);
        createGameBtn = findViewById(R.id.createGameButton);

        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CreateGameActivity.this,HomeActivity.class));
            }
        });

        createGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game game = new Game();
                FirebaseDatabaseManager.getInstance().addGame(game);
                Log.i("CREATE GAME", "New game was made");
                startActivity(new Intent(CreateGameActivity.this,GameBoardActivity.class));

            }
        });


    }
}
