package com.cookandroid.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewFlipper flipper;
        flipper = (ViewFlipper) findViewById(R.id.Flipper);
        Button start = (Button) findViewById(R.id.Start);
        Button stop = (Button) findViewById(R.id.Stop);
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                flipper.startFlipping();
                flipper.setFlipInterval(1000);
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                flipper.stopFlipping();
            }
        });
    }
}