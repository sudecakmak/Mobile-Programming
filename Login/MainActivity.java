package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView twPas,twUS;
    ConstraintLayout back;
    Button btn;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twPas =findViewById(R.id.twpas);
        twUS =findViewById(R.id.twus);
        back=findViewById(R.id.bg);
        btn=findViewById(R.id.button);
    }

    public void login(View view) {

        String s= "sude";

        if(twUS.getText().toString().equals(s) && twPas.getText().toString().equals(s))
        {
            back.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "No more", Toast.LENGTH_SHORT).show();
            }

        }

    }
}