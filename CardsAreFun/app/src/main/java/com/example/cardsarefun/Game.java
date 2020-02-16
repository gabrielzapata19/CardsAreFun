package com.example.cardsarefun;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
     public String gameID = getGameID();

     public GameState gameState = null;

     public ArrayList<String> gameSetList = null;

     String getGameID(){
         FirebaseUser currentUser= null;
         try{
             currentUser = FirebaseAuth.getInstance().getCurrentUser();
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
             LocalDateTime now = LocalDateTime.now();
             gameID = formatter.format(now);
         }
         catch(NullPointerException n){
             Log.d("DEBUG", "Current User is null. GameID not made.");
         }
         return gameID + "-" + currentUser.getUid();
     };








}
