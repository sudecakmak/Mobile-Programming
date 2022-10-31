package com.example.quiz6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar skr,skb,skg;
    ConstraintLayout back;
    TextView tw;
    int red,green,blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skr=findViewById(R.id.skred);
        skb=findViewById(R.id.skblue);
        skg=findViewById(R.id.skgreen);


        tw =findViewById(R.id.textView);
        back=findViewById(R.id.bg);



        skr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red = skr.getProgress();
                back.setBackgroundColor(Color.rgb(red,green,blue));
                tw.setText("RGB(" + red + ", " + green +", " + blue + ")");
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
                back.setBackgroundColor(Color.rgb(red,green,blue));
                tw.setText("RGB(" + red + ", " + green +", " + blue + ")");
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
                back.setBackgroundColor(Color.rgb(red,green,blue));
                tw.setText("RGB(" + red + ", " + green +", " + blue + ")");
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