package com.dbvetex.dentiest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView btntv, btnforgot;
    private Button btnsubmit, btnsigngoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntv = findViewById(R.id.signupbtnloginpg);
        btnforgot = findViewById(R.id.forgotpassword);
        btnsubmit = findViewById(R.id.loginsubmitbtn);
        btnsigngoogle = findViewById(R.id.signinwithgoogle);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication();
            }
        });

        btntv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opneRegistration();
            }
        });
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgot();
            }
        });
    }

    private void authentication() {
        // Get the email and password from user input fields
        String emailToCheck = "user@example.com"; // Replace with the user's email to check
        String passwordToCheck = "userpassword"; // Replace with the user's password to check

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("customerInfo");


        // Query the database to find a user with the given email
        databaseReference.orderByChild("email").equalTo(emailToCheck)
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        CustomerInfo user = userSnapshot.getValue(CustomerInfo.class); // Replace 'User' with your data model
                        if (user != null && user.getPassword().equals(passwordToCheck)) {
                            // User found and password matches, you can proceed with the login
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                             loginSuccesfull();
                        } else {
                          
                            Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // User not found; show an error message or take appropriate action
                    Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database read errors if needed.
            }
        });
    }

    private void loginSuccesfull() {
        Intent intent = new Intent(this, FrantPages.class);
        startActivity(intent);
    }
    public  void opneRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    public void openForgot(){
        Intent intent = new Intent(this, ForegotPassword.class);
        startActivity(intent);
    }
}