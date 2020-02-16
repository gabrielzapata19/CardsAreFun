package com.example.cardsarefun;

import java.util.ArrayList;

public class Player {
    public String playerID;
    public ArrayList<CardSet> hand = null;
    public int points = 0;
    public boolean isWinner = false;

    public void setPlayerID(String _PID){
        playerID = _PID;
    }
    public String getPlayerID(){
        return playerID;
    }


}
