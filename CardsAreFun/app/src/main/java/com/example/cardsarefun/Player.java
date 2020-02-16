package com.example.cardsarefun;

import java.util.ArrayList;

public class Player {
    public String playerID;
    public ArrayList<String> hand;
    public int points = 0;
    public boolean isWinner = false;

   Player(){
       if(hand == null){
           hand = new ArrayList<String>();
           hand.add("Test players starting hand");
           hand.add("We will place card ID here");
       }
   }


}
