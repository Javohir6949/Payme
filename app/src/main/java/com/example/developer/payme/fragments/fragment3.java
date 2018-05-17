package com.example.developer.payme.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.payme.R;
import com.example.developer.payme.model.Saved;

import java.util.ArrayList;
import java.util.List;

public class fragment3 extends Fragment {
    private RecyclerView recyclerView;
    private List<Saved> savedList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,container,false);
        savedList = new ArrayList<>();

        savedList.add(new Saved("Java","+998943296949"));
        savedList.add(new Saved("Tonik","+998943698978"));
        savedList.add(new Saved("Jambo","+998948895648"));
        savedList.add(new Saved("Rumba","+998944585489"));
        savedList.add(new Saved("Natalya","+998941234567"));

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter());
        return view;
    }

    class  MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
        Saved saved = savedList.get(position);
        holder.savedName.setText(saved.getSavedName());
        holder.savedNumber.setText(saved.getSavedNumber());
        }

        @Override
        public int getItemCount() {
            return savedList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView savedName;
            TextView savedNumber;
            public MyViewHolder(View itemView) {
                super(itemView);
                savedName = itemView.findViewById(R.id.savedName);
                savedNumber = itemView.findViewById(R.id.savedNumber);
            }
        }
    }
}
