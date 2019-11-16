package com.example.keeplog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Button btn_back, btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_back = findViewById(R.id.btn_back);
        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //자동로그인 값 삭제
                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                pref.edit().remove("keeplog").commit();

                //로그인 화면으로 넘기기
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이전 화면으로 넘기기
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
