package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText num1;
    EditText num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.btndiv);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
    }

    public void btnadd(View view) {
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum =n1+n2;
        result.setText(String.valueOf(sum));
    }


    public void btnsub(View view) {
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum =n1-n2;
        result.setText(String.valueOf(sum));
    }

    public void btndiv(View view) {
        float n1= Float.parseFloat(num1.getText().toString());
        float n2= Float.parseFloat(num2.getText().toString());

        if(n2==0)
        {
            result.setText("Invalid operation");
        }
        else
        {
            float sum =n1/n2;
            result.setText(String.valueOf(sum));
        }
    }

    public void btnmul(View view) {
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum =n1*n2;
        result.setText(String.valueOf(sum));
    }
}