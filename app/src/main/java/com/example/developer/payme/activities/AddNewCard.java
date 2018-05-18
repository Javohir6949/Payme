package com.example.developer.payme.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.developer.payme.R;

public class AddNewCard extends AppCompatActivity implements TextWatcher {
    Button btn_Save;
    EditText cardNumber;
    EditText owner;
    private boolean isDelete;
    private int before;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        owner = findViewById(R.id.owner);
        owner.addTextChangedListener(this);
        btn_Save = findViewById(R.id.btn_Save);
        cardNumber = findViewById(R.id.cardNumber);
        cardNumber.setFilters(new InputFilter[] { new InputFilter.LengthFilter(19) });
        cardNumber.addTextChangedListener(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int after) {
        if (before == 0)
            isDelete = false;
        else
            isDelete = true;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s == cardNumber.getEditableText()){
            String source = s.toString();
            int length = source.length();


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(source);

            if (isDelete && length > 0){
                stringBuilder.deleteCharAt(length - 1);
            }

            if(length == 4 && isDelete == false){
                stringBuilder.insert(length , " ");
                cardNumber.setText(stringBuilder);
                cardNumber.setSelection(cardNumber.getText().length());



            }else if (length == 9 && isDelete == false){
                stringBuilder.insert(length , " ");
                cardNumber.setText(stringBuilder);
                cardNumber.setSelection(cardNumber.getText().length());
            }else if (length == 14 && isDelete == false){
                stringBuilder.insert(length , " ");
                cardNumber.setText(stringBuilder);
                cardNumber.setSelection(cardNumber.getText().length());
            }
        }

        if (s == owner.getEditableText()){
            String source = s.toString();
            int length = source.length();

            if (cardNumber.getText().toString().length() == 19 && length != 0){
                btn_Save.setBackground(getResources().getDrawable(R.drawable.gradient));

            }
        }
}
}
