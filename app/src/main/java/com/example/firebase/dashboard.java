package com.example.firebase;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txt= findViewById(R.id.mytxt);
            String data = getIntent().getStringExtra("name");

            txt.setText(String.format(data));

    }
}