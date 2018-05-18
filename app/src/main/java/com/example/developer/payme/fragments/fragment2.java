package com.example.developer.payme.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.developer.payme.R;

public class fragment2 extends Fragment implements View.OnClickListener {
    private ImageView visibility;
    private boolean visible = true;
    private RelativeLayout wordSum2;
    private TextView expense;
    private LinearLayout hide2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        visibility = view.findViewById(R.id.visibility);
        wordSum2 = view.findViewById(R.id.wordSum2);
        expense = view.findViewById(R.id.expense);
        hide2 = view.findViewById(R.id.hide2);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.visibility: {
                Log.d("bosildi", "sdsds");
                if (visible) {
                    Log.d("bosildi", "sdsds");
                    visibility.setImageDrawable(getResources().getDrawable(R.drawable.invisible));
                    hide2.setVisibility(View.VISIBLE);
                    wordSum2.setVisibility(View.GONE);
                    expense.setVisibility(View.GONE);
                } else {
                    Log.d("bosildi", "sdsds");
                    visibility.setImageDrawable(getResources().getDrawable(R.drawable.visible));
                    hide2.setVisibility(View.GONE);
                    wordSum2.setVisibility(View.VISIBLE);
                    expense.setVisibility(View.VISIBLE);
                }
                break;
            }
        }
    }
}
