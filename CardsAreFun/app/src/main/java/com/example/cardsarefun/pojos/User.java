package com.example.cardsarefun.pojos;

import java.util.ArrayList;

public class User {
    private ArrayList<CardSet> userCardSets;
    private static User currentUser = null;

    public ArrayList<String> userSetList;
    public Integer gamesPlayed = 0;
    public Integer totalPoints = 0;
    public Integer totalWins = 0;
    /* TODO: Find a way to implement the most upvoted answer for user
    public Pair<String, ArrayList<String>> mostUpvotedAnswer = new Pair<>("",new ArrayList<String>());
    */

    public static User getCurrentUser(){
        if(currentUser == null){
            currentUser = new User();
        }
        return currentUser;
    }

    private User(){
        userSetList = new ArrayList<>();
        userSetList.add("set-one");

        userCardSets = new ArrayList<>();
    }

    public void setUserSetList(ArrayList<String> _setList){
        userSetList = _setList;
    }

    public void setUserCardSets(ArrayList<CardSet> _userCardSets){
        userCardSets = _userCardSets;
    }

    public ArrayList<CardSet> getUserCardSets(){
        return userCardSets;
    }
}
