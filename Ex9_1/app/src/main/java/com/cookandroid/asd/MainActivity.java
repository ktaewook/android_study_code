package com.cookandroid.asd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML 파일 대신 재정의한 클래스를 화면에 보여줌
        setContentView(new MyGraphicView(this));
    }

    // View 클래스를 상속받아 MyGraphicView 클래스를 재정의
    private static class MyGraphicView extends View {
        // 재정의한 클래스의 생성자
        public MyGraphicView(Context context) {
            super(context);
        }

        // 클래스가 생성되거나 무효화(invalidate)되면 호출되는 메서드
        // 일반적으로 화면에 그려질 내용을 이곳에 코딩함
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            RectF rect1 = new RectF(40,30,700,70);
            canvas.drawRect(rect1, paint);

            RectF rect2 = new RectF(40,100,700,170);
            canvas.drawRoundRect(rect2,50,50, paint);

            canvas.drawOval(110,230,600,400,paint);

            RectF rectF = new RectF();
            rectF.set(100, 600, 100 + 400, 1000);
            canvas.drawArc(rectF, 40, 80, true, paint);
            

            paint.setColor(Color.BLUE);
            rectF.set(100, 1100, 100 + 200, 1300);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.argb(0x88, 0xff, 0x00, 0x00));
            rectF.set(150, 1220, 150 + 200, 1600);
            canvas.drawRect(rectF, paint);
        }
    }
}