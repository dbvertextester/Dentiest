package com.dbvetex.dentiest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OTPsubmitpg extends AppCompatActivity {

    private Button btnotp;
    private TextView tvBackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpsubmitpg);

        btnotp = findViewById(R.id.btnotpSubmit);
        tvBackbtn = findViewById(R.id.tvBackToforgot);

        btnotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreatepass();
            }
        });
        tvBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackForgot();
            }
        });
    }
    private void openCreatepass(){
        Intent intent = new Intent(this, CreatePassword.class);
        startActivity(intent);
    }
    private void openBackForgot(){
        Intent intent = new Intent(this, ForegotPassword.class);
        startActivity(intent);
    }
}