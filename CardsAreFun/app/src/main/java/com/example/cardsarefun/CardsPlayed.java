package com.example.cardsarefun;

import java.util.ArrayList;

public class CardsPlayed {

    public ArrayList<String> blackCards;
    public ArrayList<String> whiteCards;


    //TODO remove following hard coded value after confirming structure in DB
    CardsPlayed(){
        blackCards = new ArrayList<String>();
        whiteCards = new ArrayList<String>();
        addBlackCardPlayed("Test Black cards played");
        addWhitekCardPlayed("Test White cards played");
    }


    public void addBlackCardPlayed(String _BCID){
        blackCards.add(_BCID);
    }

    public void addWhitekCardPlayed(String _WCID){
        whiteCards.add(_WCID);
    }
}
