package com.cookandroid.ex10_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent secondIntent = getIntent();
        int value=0;
        switch (secondIntent.getIntExtra("Cal",0))
        {
            case R.id.a1:
                value = secondIntent.getIntExtra("Num1",0) + secondIntent.getIntExtra("Num2",0);
                break;
            case R.id.a2:
                value = secondIntent.getIntExtra("Num1",0) - secondIntent.getIntExtra("Num2",0);
                break;
            case R.id.a3:
                value = secondIntent.getIntExtra("Num1",0)*secondIntent.getIntExtra("Num2",0);
                break;
            case R.id.a4:
                value = secondIntent.getIntExtra("Num1",0)/secondIntent.getIntExtra("Num2",0);
                break;
        }
        final int Value = value;
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplication(), MainActivity.class);
                outIntent.putExtra("value",Value);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
