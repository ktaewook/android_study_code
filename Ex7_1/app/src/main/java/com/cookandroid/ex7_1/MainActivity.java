package com.cookandroid.ex7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    ImageView img;
    MenuItem item1,item2, item3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");
        img = (ImageView) findViewById(R.id.img);
        edt1 = (EditText) findViewById(R.id.edt1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);
        MenuInflater mInflater =getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                img.setImageResource(R.drawable.han);
                img.setRotation(Integer.parseInt(edt1.getText().toString()));
                img.setVisibility(View.VISIBLE);
                item.setChecked(true);
                return true;
            case R.id.item2:
                img.setImageResource(R.drawable.chu);
                img.setRotation(Integer.parseInt(edt1.getText().toString()));
                img.setVisibility(View.VISIBLE);
                item.setChecked(true);
                return true;
            case R.id.item3:
                img.setImageResource(R.drawable.beom);
                img.setRotation(Integer.parseInt(edt1.getText().toString()));
                img.setVisibility(View.VISIBLE);
                item.setChecked(true);
                return true;
        }
        return false;
    }
}