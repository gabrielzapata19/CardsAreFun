package com.example.cardsarefun;

import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

public class GameState {
    public boolean active = false;
    public Type type;
    public int currentRound = 0;

    //public ArrayLis<Cards>;
    public long timePlayed = 0;

    public ArrayList<String> players;

    GameState(){
        type = type.Points;
        if(players == null){
            try{
                players.add(FirebaseAuth.getInstance().getCurrentUser().getUid());
            }catch (NullPointerException n){
                n.printStackTrace();
            }
        }


    }






}
