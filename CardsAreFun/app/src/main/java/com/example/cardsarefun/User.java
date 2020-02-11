package com.example.cardsarefun;

import java.util.ArrayList;

public class User {
    public ArrayList<String> userSetList;
    public ArrayList<CardSet> userCardSets;
    private static User currentUser = null;

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
}
