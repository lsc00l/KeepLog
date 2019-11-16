package com.example.keeplog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edt_id, edt_pass;
CheckBox chk_keeplog;
Button btn_login;
    String id,pass ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_pass = findViewById(R.id.edt_pass);
        chk_keeplog = findViewById(R.id.chk_keeplog);
        btn_login = findViewById(R.id.btn_login);

        id = String.valueOf(edt_id.getText());
        pass = String.valueOf(edt_pass.getText());

        //SharedPreferences 조회
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        boolean keeplog = pref.getBoolean("keeplog", false); //자동로그인 체크 여부
        //SharedPreferences의 자동로그인 값이 true이면 페이지 넘기기
        if(keeplog){
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
            finish();
        }



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 유지에 체크했다면
                if(chk_keeplog.isChecked()){
                    //SharedPreferences에 저장(체크여부, id)
                    SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putBoolean("keeplog",true);
                    editor.putString("userId",id);
                    editor.commit();
               }
                //화면 넘기기
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
