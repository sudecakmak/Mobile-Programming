package com.example.quiz6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   ConstraintLayout cs;
   TextView t;
   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btcolor);
        cs=findViewById(R.id.bg);
        t=findViewById(R.id.tw2);

        SharedPreferences preferences = getSharedPreferences("Kullanici_Ayar", MODE_PRIVATE);
        String s, s1, s2;

        s = preferences.getString("Red", "255");
        s1 = preferences.getString("Green", "255");
        s2 = preferences.getString("Blue", "255");

        t.setText("RGB(" + s + ", " + s1 + ", " + s2 + ")");
        cs.setBackgroundColor(Color.rgb(Integer.parseInt(s), Integer.parseInt(s1), Integer.parseInt(s2)));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}