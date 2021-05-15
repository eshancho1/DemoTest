package com.example.demotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class RecordVoice extends AppCompatActivity {

    private Button userRecordButton;
    private TextView recordInstruct;

    private MediaRecorder recorder;

    private String fileName = null;

    private static final String LOG_TAG = "Record Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_voice);

        userRecordButton = findViewById(R.id.recordButton);
        recordInstruct = findViewById(R.id.instructText);

        fileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        fileName += "/recorded_audio.3gp";

        userRecordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    startRecording();

                    recordInstruct.setText("Recording..");

                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    stopRecording();

                    recordInstruct.setText("Recording stopped");
                }
                return false;
            }
        });
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
    }


    public void backHome3(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }


}