package com.example.developer.payme.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.payme.activities.AddNewCard;
import com.example.developer.payme.R;
import com.example.developer.payme.model.Card;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class fragment1 extends Fragment {
    FloatingActionButton fab;
    private RecyclerView recyclerView;
    private List<Card> cards;
    private MyAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        view.findViewById(R.id.fab);
        cards = new ArrayList<>();
        cards.add(new Card("Ruzimurodov Javohir","8600  31**  ****  3953"));
        cards.add(new Card("Iskandarov Salim","8600  34**  ****  2598"));
        cards.add(new Card("Tosheva Gulnoza","8600  36**  ****  2365"));
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter();

        recyclerView.setAdapter(adapter);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddNewCard.class);
                startActivityForResult(intent,1);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){

                String cardNumber = data.getStringExtra("cardNumber");
                String encoded = EncodedCardNumber(cardNumber);
                String owner = data.getStringExtra("owner");
                cards.add(new Card(owner,encoded));
                adapter.notifyDataSetChanged();

            }
        }
    }

    private String EncodedCardNumber(String cardNumber) {
        String part1 = cardNumber.substring(0,7);
        String part2 = "**  ****  ";
        String part3 = cardNumber.substring(15,19);
        return part1+part2+part3;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Card card = cards.get(position);
            holder.name.setText(card.getName());
            holder.cardNumber.setText(card.getNumber());
        }

        @Override
        public int getItemCount() {
            return cards.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView name;
            TextView cardNumber;

            public MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                cardNumber = itemView.findViewById(R.id.cardNumber);

            }
        }
    }
}
