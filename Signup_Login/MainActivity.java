package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView twPas,twUS;
    ConstraintLayout back;
    Button btnlog,btnsign;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twPas =findViewById(R.id.twpas);
        twUS =findViewById(R.id.twus);
        back=findViewById(R.id.bg);
        btnlog=findViewById(R.id.btnlogin);
        btnsign=findViewById(R.id.btnsignup);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Kul_Ad",twUS.getText().toString());
                editor.putString("Kul_pas",twPas.getText().toString());
                editor.apply();

            }
        });

    }

    public void login(View view) {

        String username,password;

        SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
        username = preferences.getString("Kul_Ad","no");
        password = preferences.getString("Kul_pas","no");

        if(twUS.getText().toString().equals(username) && twPas.getText().toString().equals(password))
        {
            back.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("Username", twUS.getText().toString());
            intent.putExtra("Password",twPas.getText().toString());
            startActivity(intent);
        }
        else
        {
            count++;

            if(count == 1)
                Toast.makeText(this, "2 more", Toast.LENGTH_SHORT).show();
            if(count == 2)
                Toast.makeText(this, "1 more", Toast.LENGTH_SHORT).show();
            if(count == 3)
            {
                back.setBackgroundColor(Color.RED);
                twUS.setEnabled(false);
                twPas.setEnabled(false);
                Toast.makeText(this, "No more", Toast.LENGTH_SHORT).show();
            }

        }

    }
}