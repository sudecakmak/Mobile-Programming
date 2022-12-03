package com.example.quiz6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    SeekBar skr, skb, skg;
    ConstraintLayout back;
    TextView tw;
    int red, green, blue;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        skr = findViewById(R.id.skred2);
        skb = findViewById(R.id.skblue2);
        skg = findViewById(R.id.skgreen2);


        tw = findViewById(R.id.textView);
        back = findViewById(R.id.bg);
        btn2=findViewById(R.id.bnext);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences preferences = getSharedPreferences("Kullanici_Ayar", MODE_PRIVATE);
        String s, s1, s2;

        s = preferences.getString("Red", "0");
        s1 = preferences.getString("Green", "0");
        s2 = preferences.getString("Blue", "0");

        skr.setProgress(Integer.parseInt(s));
        skb.setProgress(Integer.parseInt(s2));
        skg.setProgress(Integer.parseInt(s1));
        tw.setText("RGB(" + s + ", " + s1 + ", " + s2 + ")");
        back.setBackgroundColor(Color.rgb(Integer.parseInt(s), Integer.parseInt(s1), Integer.parseInt(s2)));

        skr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red = skr.getProgress();
                back.setBackgroundColor(Color.rgb(red, green, blue));
                tw.setText("RGB(" + red + ", " + green + ", " + blue + ")");
                SharedPreferences preferences = getSharedPreferences("Kullanici_Ayar", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Red", String.valueOf(red));
                editor.putString("Green", String.valueOf(green));
                editor.putString("Blue", String.valueOf(blue));
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blue = skb.getProgress();
                back.setBackgroundColor(Color.rgb(red, green, blue));
                tw.setText("RGB(" + red + ", " + green + ", " + blue + ")");
                SharedPreferences preferences = getSharedPreferences("Kullanici_Ayar", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Red", String.valueOf(red));
                editor.putString("Green", String.valueOf(green));
                editor.putString("Blue", String.valueOf(blue));
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                green = skg.getProgress();
                back.setBackgroundColor(Color.rgb(red, green, blue));
                tw.setText("RGB(" + red + ", " + green + ", " + blue + ")");
                SharedPreferences preferences = getSharedPreferences("Kullanici_Ayar", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Red", String.valueOf(red));
                editor.putString("Green", String.valueOf(green));
                editor.putString("Blue", String.valueOf(blue));
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}