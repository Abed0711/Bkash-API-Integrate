package com.example.bkashabed.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bkashabed.R;


public class MainActivity extends AppCompatActivity {

    private Button btnCheckout;
    private EditText etAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        btnCheckout = findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInputs();
            }
        });

    }

    private void checkInputs() {
        String amountInString = etAmount.getText().toString().trim();


        double amount = 0.0;

        try {
            amount = Double.parseDouble(amountInString);
        } catch (Exception e) {
            amount = 0.0;
        }

        if (amount < 1) {
            etAmount.setError("You have to pay at least BDT 1. ");
            etAmount.requestFocus();
            return;
        }   // here you need to check internet connection on another condition like if(is_online)
        else {
            Intent intent = new Intent(MainActivity.this, BkashActivityPage.class);
            intent.putExtra("AMOUNT", String.valueOf(amount));  //sent amount to bkash activity
            startActivity(intent);
        }

    }
}
