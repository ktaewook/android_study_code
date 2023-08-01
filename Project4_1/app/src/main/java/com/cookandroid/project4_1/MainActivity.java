package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnAdd,btnSub,btnMul,btnDiv,btnLast;
    TextView textResult;
    String num1,num2;
    Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnLast= (Button) findViewById(R.id.BtnLast);
        textResult = (TextView) findViewById(R.id.TextResult);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= edit1.getText().toString();
                num2=edit2.getText().toString();
                result = Double.parseDouble(num1)+Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result.toString());

            }


        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= edit1.getText().toString();
                num2=edit2.getText().toString();
                result = Double.parseDouble(num1)-Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result.toString());

            }


        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= edit1.getText().toString();
                num2=edit2.getText().toString();
                result = Double.parseDouble(num1)*Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result.toString());

            }


        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= edit1.getText().toString();
                num2=edit2.getText().toString();
                result = Double.parseDouble(num1)/Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result.toString());

            }


        });
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1= edit1.getText().toString();
                num2=edit2.getText().toString();
                result = Double.parseDouble(num1)%Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+result.toString());

            }


        });
            }
}

