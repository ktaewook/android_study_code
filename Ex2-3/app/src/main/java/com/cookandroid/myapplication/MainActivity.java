package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.b1);
        btn2=(Button) findViewById(R.id.b2);
        btn3=(Button) findViewById(R.id.b3);
        btn4=(Button) findViewById(R.id.b4);
        btn1.setBackgroundColor(Color.GRAY);
        btn2.setBackgroundColor(Color.GREEN);
        btn3.setBackgroundColor(Color.RED);
        btn4.setBackgroundColor(Color.BLACK);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn2 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:/911"));
                startActivity(btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn3 = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
                startActivity(btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}