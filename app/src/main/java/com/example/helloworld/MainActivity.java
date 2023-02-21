package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextview;//声明
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextview = (Button)findViewById(R.id.btn_textview);
        mBtnTextview.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);

            }




        });
        mBtnButton = findViewById(R.id.btn_button);
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到Button演示界面
                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到EditText演示界面
                Intent intent = new Intent(MainActivity.this,EditTextActivity.class);
                startActivity(intent);

            }
        });
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(MainActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);







    }
}