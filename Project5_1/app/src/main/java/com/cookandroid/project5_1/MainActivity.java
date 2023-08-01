package com.cookandroid.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        Button btn = new Button(this);
        EditText edt = new EditText(this);
        TextView tev = new TextView(this);
        edt.setText("IT Cookbook. Android");
        tev.setText("IT Cookbook. Android");
        baseLayout.addView(edt);
        tev.setTextColor(Color.rgb(128,0,128));
        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.rgb(155, 155 ,0));
        baseLayout.addView(btn);
        baseLayout.addView(tev);
        tev.setVisibility(android.view.View.INVISIBLE);
        tev.setTextSize(25);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                tev.setVisibility(android.view.View.VISIBLE);
            }
        });
    }
}