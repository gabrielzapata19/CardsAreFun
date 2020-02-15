package com.example.cardsarefun;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDatabaseManager {

    private static FirebaseDatabaseManager manager = null;
    private FirebaseDatabase database;

    public static FirebaseDatabaseManager getInstance(){
        if(manager == null){
            manager = new FirebaseDatabaseManager();
        }
        return manager;
    }

    private FirebaseDatabaseManager(){
        database = FirebaseDatabase.getInstance();
    }

    public void addUser(String _UID, User _user){
        DatabaseReference ref = database.getReference();
        ref.child("users").child(_UID).setValue(_user);
    }

    public void getUserSetList(){
        DatabaseReference userSetsRef = database.getReference()
                .child("users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("userSetList");

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> userSets = (ArrayList<String>) dataSnapshot.getValue();
                User.getCurrentUser().setUserSetList(userSets);

                getUserCardSets();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        userSetsRef.addValueEventListener(listener);
    }

    public void getUserCardSets(){
        DatabaseReference cardListRef = database.getReference()
                .child("sets");

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<CardSet> availableCardSets = new ArrayList<>();
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    if(User.getCurrentUser().userSetList.contains(child.getKey())){
                        ArrayList<String> blackCards = new ArrayList<>();
                        ArrayList<String> whiteCards = new ArrayList<>();

                        for(DataSnapshot bc:child.child("black-cards").getChildren()){
                            blackCards.add(bc.getValue().toString());
                        }

                        for(DataSnapshot wc:child.child("white-cards").getChildren()){
                            whiteCards.add(wc.getValue().toString());
                        }

                        CardSet cs = new CardSet(child.getKey(),blackCards,whiteCards);
                        availableCardSets.add(cs);
                    }
                }
                        User.getCurrentUser().setUserCardSets(availableCardSets);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        cardListRef.addValueEventListener(listener);
    }
}
