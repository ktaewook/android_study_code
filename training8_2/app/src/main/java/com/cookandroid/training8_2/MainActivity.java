package com.cookandroid.training8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btnPrev, btnNext;
    myPictureView myPictureView;
    int num = 0;
    File[] imageFiles=new File[0];
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPictureView = findViewById(R.id.myPictureView);

        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/Pictures").listFiles();
        for (int i=0; i<imageFiles.length; i++)
            if(allFiles[i].isFile()) {
                imageFiles = Arrays.copyOf(imageFiles, imageFiles.length +1);
                imageFiles[imageFiles.length-1] = allFiles[i];
            }
        imageFname = imageFiles[num].toString();
        myPictureView.imagePath=imageFname;

        btnPrev.setOnClickListener(v -> {
            if(num <= 0){
                Toast.makeText(getApplicationContext(), "첫번째 그림입니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                num--;
                imageFname = imageFiles[num].toString();
                myPictureView.imagePath = imageFname;
                myPictureView.invalidate();
            }
        });

        btnNext.setOnClickListener(v -> {
            if(num >= imageFiles.length - 1){
                Toast.makeText(getApplicationContext(), "마지막 그림입니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                num++;
                imageFname = imageFiles[num].toString();
                myPictureView.imagePath = imageFname;
                myPictureView.invalidate();
            }
        });
    }
}