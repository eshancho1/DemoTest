package com.example.demotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InputAnswer extends AppCompatActivity {

    EditText userYear;
    Button submitButton;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_answer);

        userYear = findViewById(R.id.Year);
        submitButton = findViewById(R.id.submitAnswer);
        fAuth = FirebaseAuth.getInstance();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = userYear.getText().toString().trim();

                if(TextUtils.isEmpty(year)){
                    userYear.setError("Please enter your year");
                    return;
                }

                if(year.length() < 4){
                    userYear.setError("Please enter the full word");
                    return;
                }

                //user authentication

              finish();
            }
        });
    }



    public void backHome2(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}