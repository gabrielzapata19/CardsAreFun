package com.example.cardsarefun.activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cardsarefun.R;

public class CardActivity extends RecyclerView.Adapter<CardActivity.CardHolder> {

    TextView cardText;

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class CardHolder extends RecyclerView.ViewHolder {
        public CardHolder(@NonNull View itemView) {
            super(itemView);

           cardText = itemView.findViewById(R.id.cardTextView);



        }




    }

}
