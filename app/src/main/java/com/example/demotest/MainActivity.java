package com.example.demotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //logout button functionality
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void playVideo(View view){
        startActivity(new Intent(getApplicationContext(), PlayVideo.class));
        finish();
    }
//
    public void inputAnswer(View view){
        startActivity(new Intent(getApplicationContext(), InputAnswer.class));
        finish();
    }
//
    public void recordVoice(View view){
        startActivity(new Intent(getApplicationContext(), RecordVoice.class));
        finish();
    }


}