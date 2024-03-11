package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
FirebaseAuth mAuth;
Button btn;

    EditText edt1 , edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.mybtn);
        edt1 = findViewById(R.id.myedt1);
        edt2 = findViewById(R.id.myedt2);

        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(v -> {
            String uid = edt1.getText().toString().trim();
            String pwd = edt2.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(uid,pwd).addOnCompleteListener(task -> {
                Intent intent = new Intent(MainActivity.this, dashboard.class);

                intent.putExtra("name",uid);

                startActivity(intent);
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,"sucessful", Toast.LENGTH_SHORT).show();
                }
            });
        });


    }

}