package com.fidelomolokucu.kucuapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    ImageView message;
    Animation fromBottom,fromTop,fromSide;
    EditText email;

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.logo);
        message=findViewById(R.id.message);
        email=findViewById(R.id.id_email);


        fromBottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromTop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        logo.setAnimation(fromTop);
        message.setAnimation(fromBottom);





        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,Login.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
