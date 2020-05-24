package com.example.cardsarefun.pojos;

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

    public void addCardToHand(String card) {
        this.hand.add(card);
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerID() {
        return playerID;
    }
}
