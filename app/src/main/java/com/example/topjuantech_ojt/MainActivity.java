package com.example.topjuantech_ojt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    //vars declaration
    private Button btn_login, btn_signupUser, btn_signupManager;

//    //Variables
//    Animation topAnim, bottomAnim, scaleUp, scaleDown;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //methods to find id
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_signupUser = (Button) findViewById(R.id.btn_signupUser);
        btn_signupManager = (Button) findViewById(R.id.btn_signupManager);

        //Animations
        RelativeLayout relativeLayout = findViewById(R.id.mainAct);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //button onTouch or redirection
        btn_signupUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    Intent intent = new Intent(MainActivity.this, RegistrationUser.class);
                    startActivity(intent);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(MainActivity.this, RegistrationUser.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        btn_signupManager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    Intent intent = new Intent(MainActivity.this, RegistrationManager.class);
                    startActivity(intent);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(MainActivity.this, RegistrationManager.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        btn_login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
}