package com.cookandroid.ex12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    myDBHelper myHleper;
    EditText edtName,edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect,btnRe,btnDe;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNum);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumResult);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSearch);
        btnRe  = (Button) findViewById(R.id.btnRe);
        btnDe  = (Button) findViewById(R.id.btnDe);

        myHleper = new myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHleper.getWritableDatabase();
                myHleper.onUpgrade(sqlDB, 1 ,2);
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHleper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES('" + edtName.getText().toString()+"', "+edtNumber.getText().toString() +");");
                btnSelect.callOnClick();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHleper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT *FROM groupTBL;", null);

                String strNames = "그룸 이름" +"\r\n" +"-------"+"\r\n";
                String strNum="인원"+"\r\n" +"-------"+"\r\n";
                while(cursor.moveToNext()) {
                    strNames += cursor.getString(0)+"\r\n";
                    strNum += cursor.getString(1) +"\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNum);

                cursor.close();
                sqlDB.close();
            }
        });
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHleper.getWritableDatabase();
                sqlDB.execSQL("UPDATE groupTBL SET gNumber = '"+edtNumber.getText().toString() +"' WHERE gName = '" + edtName.getText().toString()+"';");
                btnSelect.callOnClick();
                sqlDB.close();
            }
        });
        btnDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHleper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName='" + edtName.getText().toString()+"'");
                btnSelect.callOnClick();
            }
        });
    }
    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "groupDB", null, 1);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }

}