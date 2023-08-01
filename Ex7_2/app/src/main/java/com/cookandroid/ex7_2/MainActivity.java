package com.cookandroid.ex7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baselayout;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("training 7_2를 자바로만 구현하기");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        baselayout = new LinearLayout(this);
        baselayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baselayout, params);

        btn1 = new Button(this);
        btn2 = new Button(this);
        btn1.setText("배경색 변경");
        btn2.setText("버튼 변경");
        baselayout.addView(btn1);
        baselayout.addView(btn2);

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v==btn1) {menu.add(0, 1, 0, "배경색(빨강)");
            menu.add(0, 2, 0, "배경색(초록)");
            menu.add(0, 3,0, "배경색(파랑)");
        }
        if (v==btn2) {
            menu.add(1, 4, 0, "버튼 45도 회전");
            menu.add(1, 5, 0, "버튼 2배 확대");
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case 1:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                btn2.setRotation(45);
                return true;
            case 5:
                btn2.setScaleX(2);
                return true;
        }
        return false;
    }

}