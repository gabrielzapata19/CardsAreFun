package com.example.cardsarefun;

import java.util.ArrayList;

public class CardSet {
    private String setName = null;
    private ArrayList<String> blackCards = null;
    private ArrayList<String> whiteCards = null;

    public CardSet(String _setName, ArrayList<String> _blackCards, ArrayList<String> _whiteCards){
        setName = _setName;
        blackCards = _blackCards;
        whiteCards = _whiteCards;
    }
}
