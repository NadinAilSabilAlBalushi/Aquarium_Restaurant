package com.example.aquariumrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectOne extends AppCompatActivity {
    Intent intent;
    String type;
    Button Chef, Customer, DeliveryPerson;

    ConstraintLayout bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_one);
        Chef = (Button) findViewById(R.id.chef);
        DeliveryPerson = (Button) findViewById(R.id.delivery);
        Customer = (Button) findViewById(R.id.customer);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image1), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image4), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image5), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image6), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image7), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image8), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image9), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.image10), 3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);
        bgimage = findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")) {
                    Intent loginemail = new Intent(SelectOne.this, ChefLogin.class);
                    startActivity(loginemail);
                    finish();
                }
                if (type.equals("Phone")) {
                    Intent loginphone = new Intent(SelectOne.this, ChefLoginByPhone.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("SignUp")) {
                    Intent Register = new Intent(SelectOne.this, ChefRegisterationByEmail.class);
                    startActivity(Register);


                }

            }
        });

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")) {
                    Intent loginemailcust = new Intent(SelectOne.this, CustomerLogin.class);
                    startActivity(loginemailcust);
                    finish();
                }
                if (type.equals("Phone")) {
                    Intent loginphonecust = new Intent(SelectOne.this, CustomerLoginPhone.class);
                    startActivity(loginphonecust);
                    finish();
                }
                if (type.equals("SignUp")) {
                    Intent Registercust = new Intent(SelectOne.this, CustomerRegisteration.class);
                    startActivity(Registercust);
                }
            }
        });

        DeliveryPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("SignUp")) {
                    Intent Registerdelivery = new Intent(SelectOne.this, Delivery_registeration.class);
                    startActivity(Registerdelivery);
                }
                if (type.equals("Phone")) {
                    Intent loginphone = new Intent(SelectOne.this, Delivery_LoginPhone.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("Email")) {
                    Intent loginemail = new Intent(SelectOne.this, DeliveryLogin.class);
                    startActivity(loginemail);
                    finish();
                }
            }
        });
    }
}
