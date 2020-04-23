package com.example.rida.ui.expenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.R;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class ExpensesRecyclerAdapter extends RecyclerView.Adapter<ExpensesRecyclerAdapter.ViewHolder> {

    private String[] cardTitles = { "Total Gas and Maintenance Cost", "Total Mileage", "Total Earnings" };
    private double[] cardVals = { 12.00, 1409.0, 123.00 };

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView expenseName;
        public TextView expenseTotal;

        public ViewHolder(View card) {
            super(card);
            expenseName = (TextView) card.findViewById(R.id.expenseName);
            expenseTotal = (TextView) card.findViewById(R.id.expenseTotal);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       /*
        ---This block of code was for debugging. Might want to put a display the newsfeed list here---
       FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        myRef = database.getReference("newsfeed");
        Post p = new Post("charlie", "hey friends", "yesterday");
        myRef.push().setValue(p);*/

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contents_tracker, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //it appears that this is where we need to implement the data of the posts
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //myRef = database.getReference("newsfeed");
        //DataSnapshot ds = database.onDataChange();
        viewHolder.expenseName.setText(cardTitles[i]);
        viewHolder.expenseTotal.setText("$" + cardVals[i]);
    }

    @Override
    public int getItemCount() {
        return cardTitles.length;
    }
}
