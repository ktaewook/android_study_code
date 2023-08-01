package com.cookandroid.project9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, blur, emboss;
    MyGraphicView graphicView;
    static float scaleX=1, scaleY=1;
    static float angle=0,color = 1,satur=1,em=1,bl=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictuerLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictuerLayout.addView(graphicView);
        clickIcons();
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lema256);
            int picX = (this.getWidth()-picture.getWidth())/2;
            int picY = (this.getHeight()-picture.getHeight())/2;
            int cenX= this.getWidth()/2;
            int cenY = this.getWidth()/2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);
            Paint paint= new Paint();

            EmbossMaskFilter eMask;
            eMask = new EmbossMaskFilter(new float[] {3,3,3},0.5f, 5, 10);
            if (em==0) paint.setMaskFilter(eMask);

            BlurMaskFilter Blur;
            Blur = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            if (bl==0) paint.setMaskFilter(Blur);
            float[] array = {color, 0 , 0, 0 , 0,
                    0, color , 0, 0 , 0,
                    0, 0 , color, 0 , 0,
                    0, 0 , 0, 1 , 0};
            ColorMatrix cm = new ColorMatrix(array);
            //여기서 saturation을 setColorFilter보다 뒤에 넣으면 setColorFilter가 무시되기때문에 앞에 코딩해야함.
            cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });
        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });
        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                angle = angle+20;
                graphicView.invalidate();
            }
        });
        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                satur = satur + 0.2f;
                graphicView.invalidate();
            }
        });
        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                satur = satur - 0.2f;
                graphicView.invalidate();
            }
        });
        emboss = (ImageButton) findViewById(R.id.emboss);
        emboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (em==0) em=1;
                else em=0;
                graphicView.invalidate();
            }
        });
        blur = (ImageButton) findViewById(R.id.blur);
        blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bl==0) bl=1;
                else bl=0;
                graphicView.invalidate();
            }
        });
    }

}