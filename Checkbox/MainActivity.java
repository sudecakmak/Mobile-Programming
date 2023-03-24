package com.example.sudeakmak_mobilapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.tw);
    }

    Vector <String> selected = new Vector <String>();

    public void select(View view) {
        CheckBox chk = (CheckBox) view;

        if(chk.isChecked())
        {
            selected.add(chk.getText().toString());
        }
        else
        {
            selected.remove(chk.getText().toString());
        }

        if(!selected.isEmpty())
        {
            String day=selected.toString();
            day=day.replace("[","");
            day=day.replace("]","");

            textview.setText(day);
        }
        else
        {
            textview.setText("There is no selected day");
        }
    }
}
