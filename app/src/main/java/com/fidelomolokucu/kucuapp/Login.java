package com.fidelomolokucu.kucuapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import dmax.dialog.SpotsDialog;

public class Login extends AppCompatActivity {
    Animation fromBottom,fromSide;
    Button login,register;
    EditText email,password;

    AlertDialog progressDialog;

    ImageView reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login =findViewById(R.id.id_login);
        register=findViewById(R.id.id_register);
        reset=findViewById(R.id.id_reset);
        email=findViewById(R.id.id_email);
        password=findViewById(R.id.id_password);


        fromBottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromSide= AnimationUtils.loadAnimation(this,R.anim.slide_in_left);

        login.setAnimation(fromBottom);
        register.setAnimation(fromBottom);
        reset.setAnimation(fromBottom);

        email.setAnimation(fromSide);
        password.setAnimation(fromSide);



        progressDialog = new SpotsDialog(Login.this, R.style.Custom);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  ProgressDialog progressDialog=new ProgressDialog(Login.this);
                progressDialog.setMessage(" please wait loading....");
                progressDialog.show();*/

                Intent intent=new Intent(getApplicationContext(),Appmain.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });


    }
}
