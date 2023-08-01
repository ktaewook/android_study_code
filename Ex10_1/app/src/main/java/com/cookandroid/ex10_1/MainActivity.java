package com.cookandroid.ex10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rGruop = (RadioGroup) findViewById(R.id.rGruop);
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), SecondActivity.class);
                Intent intent2 = new Intent(getApplicationContext(), ThirdActivity.class);
                switch (rGruop.getCheckedRadioButtonId()){
                    case R.id.movesecond:
                        startActivity(intent1);
                        break;
                    case R.id.movethird:
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}