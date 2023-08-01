package com.cookandroid.training7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInFlater = getMenuInflater();
        mInFlater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
    /* 메뉴 xml따로 안만들고 자바로만 하는 법
    menu.add(그룹 아이디, 항목 아이디, 순번, 제목);
    예를 들어
    ~~onCreateOptionMenu~~{
         menu.add(0,1,0, "배경색(빨강)");
         menu.add(0,2,0, "배경색(초록)");
         menu.add(0,3,0, "배경색(파랑)");

         SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
         sMenu.add(0,4,0, "버튼 45도 회전");
         sMenu.add(0,5,0, "버튼 2배 확대");
         return true;
         }
    어떤 행동 할 건지{
         case1:
            baseLayout.setBackgroundColor(Color.RED);
            return true;
         case2:
         ~~~ 이런 방식임.
     */
}