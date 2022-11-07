package com.example.app9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et,et1,et2;
    Button bekle,btoku,bsil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.kul);
        et1=findViewById(R.id.sıf);
        et2=findViewById(R.id.mail);
        bekle=findViewById(R.id.ekle);
        btoku=findViewById(R.id.oku);
        bsil=findViewById(R.id.sıl);

        SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);

        bekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Kul_Ad",et.getText().toString());
                editor.putString("Kul_pas",et1.getText().toString());
                editor.putString("Kul_mail",et2.getText().toString());
                editor.apply();
            }
        });

        btoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
                String s = preferences.getString("Kul_Ad","no");
                String s1 = preferences.getString("Kul_pas","no");
                String s2 = preferences.getString("Kul_mail","no");

                et.setText(s);
                et1.setText(s1);
                et2.setText(s2);

            }
        });

        bsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
                et1.setText("");
                et2.setText("");

            }
        });



        // device file data data com.example uygulama adı sharedpref
    }


}