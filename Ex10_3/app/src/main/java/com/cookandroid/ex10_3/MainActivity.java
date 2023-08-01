package com.cookandroid.ex10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("세컨드 액티비티 이용한 계산기");
        EditText edit1 = (EditText) findViewById(R.id.edit1);
        EditText edit2 = (EditText) findViewById(R.id.edit2);
        Button btn = (Button)  findViewById(R.id.btn);
        RadioGroup rGroup = (RadioGroup) findViewById(R.id.rGroup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edit2.getText().toString()));
                intent.putExtra("Cal", rGroup.getCheckedRadioButtonId());
                startActivityForResult(intent,0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultcode, Intent data) {
        super.onActivityResult(requestCode, resultcode, data);
        if (resultcode == RESULT_OK) {
            int result = data.getIntExtra("value", 0);
            Toast.makeText(getApplication(), "합계 :" + result, Toast.LENGTH_SHORT).show();
        }
    }
}