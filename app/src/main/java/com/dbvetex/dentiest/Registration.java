package com.dbvetex.dentiest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity {

    private TextView tvBack,tvLogin,edtname,edtemail,edtpass,edtnumber;
    private Button buttonsubmitreg;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    CustomerInfo customerInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tvBack = findViewById(R.id.tvBackRegis);
        tvLogin = findViewById(R.id.tvRegToLogin);
        edtemail = findViewById(R.id.edtemailrag);
        edtnumber = findViewById(R.id.edtnumberreg);
        edtname = findViewById(R.id.edtnamereg);
        edtpass = findViewById(R.id.edtpassrag);


        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("customerInfo");

        customerInfo = new CustomerInfo();
        buttonsubmitreg = findViewById(R.id.btnsubmitrag);

        buttonsubmitreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtemail.getText().toString();
                String name =  edtname.getText().toString();
                String number = edtnumber.getText().toString();
                String password = edtpass.getText().toString();

                if (email.isEmpty() || name.isEmpty() || number.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Registration.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    // Generate a unique key for the new customer entry
                    String customerKey = databaseReference.child("customerInfo").push().getKey();

                    // Create a CustomerInfo object
                    CustomerInfo newCustomer = new CustomerInfo();
                    newCustomer.setEmail(email);
                    newCustomer.setNumber(number);
                    newCustomer.setName(name);
                    newCustomer.setPassword(password);

                    // Store the new customer data using the generated key
                    if (customerKey != null) {
                        databaseReference.child("customerInfo").child(customerKey).setValue(newCustomer)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        Toast.makeText(Registration.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                                       calling();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Registration.this, "Failed to add data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
//                addDetails(email,number,name,password);

            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opneBackToLogin();
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opneLogin();
            }
        });
    }

    private void calling() {
        Intent intent = new Intent(this, FrantPages.class);
        startActivity(intent);
    }

  /*  private void addDetails(String email, String number, String name, String password) {

        customerInfo.setEmail(email);
        customerInfo.setNumber(number);
        customerInfo.setName(name);
        customerInfo.setPassword(password);

        DatabaseReference usersRef = databaseReference.child("customerInfo");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(customerInfo);
                Toast.makeText(Registration.this, "Add Data", Toast.LENGTH_SHORT).show();
                return;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.d(error.getMessage()," Error ");

                Toast.makeText(Registration.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }*/

    private void opneBackToLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void opneLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}