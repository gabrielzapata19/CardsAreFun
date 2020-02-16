package com.example.cardsarefun;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
     private String gameID;

     public GameState gameState;

     public ArrayList<String> gameSetList;

     public Game(){
         if(gameID == null){
             gameSetList = new ArrayList<>();
             gameSetList.add("set-one");
             gameState = new GameState();
             gameID = getNewGameID();
         }

     }
     public String getGameID(){
         return gameID;
     }

     private String getNewGameID(){
         FirebaseUser currentUser= null;
         String timeStamp = null;
         try{
             currentUser = FirebaseAuth.getInstance().getCurrentUser();
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
             LocalDateTime now = LocalDateTime.now();
             timeStamp = formatter.format(now);
         }
         catch(NullPointerException n){
             Log.d("DEBUG", "Current User is null. GameID not made.");
         }
         gameID = timeStamp + "-" + currentUser.getUid();
         return gameID;
     };

     //Not sure if this will be used
     public void setGameState(GameState _gameState){
         gameState = _gameState;
     }








}
