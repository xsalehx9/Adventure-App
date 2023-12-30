package com.Horizon_Adventure_App.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.com.Horizon_Adventure_App.Activity.R;

public class PaymentPage extends AppCompatActivity {
    Button paymenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        paymenta = findViewById(R.id.paymenta);

        paymenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentPage.this, "Done", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentPage.this,Map.class);
                startActivity(intent);
                finish();
            }
        });
    }
}