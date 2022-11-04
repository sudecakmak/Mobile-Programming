package com.example.app8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    ListView mylist;
    ArrayList<String> myarraylist;
    ArrayAdapter<String> arrayAdapter1;

    ArrayList<String> eleman;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn=findViewById(R.id.spinner);
        mylist=findViewById(R.id.liste);

        eleman=new ArrayList<>();
        eleman.add("Karadeniz");
        eleman.add("Akdeniz");
        eleman.add("İç anadolu");

        arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,eleman);

        spn.setAdapter(arrayAdapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    myarraylist=new ArrayList<String>();
                    myarraylist.add("Trabzon");
                    myarraylist.add("Giresun");
                    myarraylist.add("Samsun");
                    myarraylist.add("Artvin");

                    arrayAdapter1=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,myarraylist);
                    mylist.setAdapter(arrayAdapter1);
                }
                if(i==1)
                {
                    myarraylist=new ArrayList<String>();
                    myarraylist.add("Antalya");
                    myarraylist.add("Muğla");
                    myarraylist.add("Burdur");
                    myarraylist.add("Mersin");

                    arrayAdapter1=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,myarraylist);
                    mylist.setAdapter(arrayAdapter1);
                }
                if(i==2)
                {
                    myarraylist=new ArrayList<String>();
                    myarraylist.add("Ankara");
                    myarraylist.add("Eskişehir");
                    myarraylist.add("Konya");
                    myarraylist.add("Aksaray");

                    arrayAdapter1=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,myarraylist);
                    mylist.setAdapter(arrayAdapter1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

}