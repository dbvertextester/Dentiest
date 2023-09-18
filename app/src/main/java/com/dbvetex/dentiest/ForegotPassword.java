package com.dbvetex.dentiest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForegotPassword extends AppCompatActivity {

    private TextView tvBack;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foregot_password);

        btnSubmit = findViewById(R.id.forgotSubmit);
        tvBack = findViewById(R.id.tvforgTomain);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOtpPgs();
            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackToMain();
            }
        });

    }
    public void openOtpPgs(){
        Intent intent = new Intent(this, OTPsubmitpg.class);
        startActivity(intent);
    }
    public void openBackToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}