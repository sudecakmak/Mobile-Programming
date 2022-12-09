package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);

        // SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
        // String s = preferences.getString("Kul_Ad","no");
        // String s1 = preferences.getString("Kul_pas","no");

        // user.setText(s);
        // pass.setText(s1);

        user.setText(intent.getStringExtra("Username"));
        pass.setText(intent.getStringExtra("Password"));

    }
}