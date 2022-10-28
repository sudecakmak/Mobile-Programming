package com.example.quiz5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    ArrayList<String> eleman;
    ImageView img;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn =findViewById(R.id.spinner3);
        img=findViewById(R.id.imageView);

        eleman=new ArrayList<>();
        eleman.add("raphael");
        eleman.add("michelangelo");
        eleman.add("donatello");
        eleman.add("leonardo");

        arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,eleman);

        spn.setAdapter(arrayAdapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                {
                    img.setImageResource(R.drawable.raphael);
                }
                if(i==1)
                {
                    img.setImageResource(R.drawable.michelangelo);
                }
                if(i==2)
                {
                    img.setImageResource(R.drawable.dona);
                }
                if(i==3)
                {
                    img.setImageResource(R.drawable.ninja_kaplumbagalar_leonardo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}