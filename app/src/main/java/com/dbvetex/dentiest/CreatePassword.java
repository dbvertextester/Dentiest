package com.dbvetex.dentiest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreatePassword extends AppCompatActivity {

    private Button btncreatesubmit;
    private TextView tvBackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);


        btncreatesubmit = findViewById(R.id.btnCreateSubmit);
        tvBackbtn = findViewById(R.id.tvBackCreatepass);

        btncreatesubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainpages();
            }
        });
        tvBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBackotp();
            }
        });
    }
    private void openMainpages(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void openBackotp(){
        Intent intent = new Intent(this, OTPsubmitpg.class);
        startActivity(intent);
    }
}