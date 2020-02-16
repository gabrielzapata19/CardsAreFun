package com.example.cardsarefun;

import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

public class GameState {
    public boolean active = false;
    public Type type;
    public int currentRound = 0;

    public CardsPlayed cardsPlayed;
    public long timePlayed = 0;

    public ArrayList<Player> players;

    GameState(){
        if(players == null){
            Player player = new Player();
            cardsPlayed  = new CardsPlayed();
            type = new Type();
            try{
                player.playerID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                players.add(player);
            }catch (NullPointerException n){
                n.printStackTrace();
            }
        }


    }


}
