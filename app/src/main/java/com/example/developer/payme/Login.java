package com.example.developer.payme;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private String password = "";

    private Toolbar toolbar;
    private RelativeLayout btn1;
    private RelativeLayout btn2;
    private RelativeLayout btn3;
    private RelativeLayout btn4;
    private RelativeLayout btn5;
    private RelativeLayout btn6;
    private RelativeLayout btn7;
    private RelativeLayout btn8;
    private RelativeLayout btn9;
    private RelativeLayout btn0;
    private RelativeLayout btn_delete;

    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private ImageView circle4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btn_delete = findViewById(R.id.btn_delete);

        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
        circle4 = findViewById(R.id.circle4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn_delete.setOnClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn1:{
                IncrementString("1");
                SetDotsColored();
                break;
            }
            case R.id.btn2:{
                IncrementString("2");
                SetDotsColored();
                break;
            }
            case R.id.btn3:{
                IncrementString("3");
                SetDotsColored();
                break;
            }
            case R.id.btn4:{
                IncrementString("4");
                SetDotsColored();
                break;
            }
            case R.id.btn5:{
                IncrementString("5");
                SetDotsColored();
                break;
            }
            case R.id.btn6:{
                IncrementString("6");
                SetDotsColored();
                break;
            }
            case R.id.btn7:{
                IncrementString("7");
                SetDotsColored();
                break;
            }
            case R.id.btn8:{
                IncrementString("8");
                SetDotsColored();
                break;
            }
            case R.id.btn9:{
                IncrementString("9");
                SetDotsColored();
                break;
            }
            case R.id.btn0:{
                IncrementString("0");
                SetDotsColored();
                break;
            }
            case R.id.btn_delete:{
                ClearDot();
                break;
            }


        }
    }

    private void IncrementString(String temp) {
        password = password+temp;

    }

    private void ClearDot() {
        password = password.substring(0,password.length()-1);

        if (password.length() == 2){
            circle3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if (password.length() == 1){
            circle2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if (password.length() == 0){
            circle1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }


    }

    private void SetDotsColored() {
        Log.d("ishladi",password);

       if(password.length() == 1){
           circle1.setImageDrawable(getResources().getDrawable(R.drawable.circle2));
       }
       if (password.length() == 2){
           circle2.setImageDrawable(getResources().getDrawable(R.drawable.circle2));
       }
       if (password.length() == 3){
           circle3.setImageDrawable(getResources().getDrawable(R.drawable.circle2));
       }
       if (password.length() == 4){
           circle4.setImageDrawable(getResources().getDrawable(R.drawable.circle2));
           CheckAccess();

       }

    }

    private void ClearALL() {
        circle1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        circle2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        circle3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        circle4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
    }

    private void CheckAccess() {
        if (password.equals("0000")){
            Intent move  = new Intent(this,MainActivity.class);
            startActivity(move);

        }else{
            final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
            LinearLayout dots = findViewById(R.id.dots);
            password = "";

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                v.vibrate(150);
            }


            dots.startAnimation(animShake);
            ClearALL();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

      /*  if (Const.CleatDots.equals("Yes")){
            ClearALL();
        }
        Const.CleatDots = "";*/

    }
}
