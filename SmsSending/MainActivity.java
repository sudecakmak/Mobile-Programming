package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt;
    Button btsave;

    EditText et;
    ListView mylist;
    ArrayList<String> myarraylist;
    ArrayAdapter<String> arrayAdapter1;

    String sms;
    String num,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=findViewById(R.id.bt);

        mylist=findViewById(R.id.myli);

        btsave=findViewById(R.id.btsave);

        et=findViewById(R.id.et);


        SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);


        myarraylist=new ArrayList<String>();
        myarraylist.add("eda;42;05321234567");
        myarraylist.add("yağmur;11;05321267867");
        myarraylist.add("sude;14;05123234567");
        arrayAdapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myarraylist);
        mylist.setAdapter(arrayAdapter1);


        msg=preferences.getString("sms","no");
        et.setText(msg);


        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences= getSharedPreferences("Kullanici_Ayar",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("sms",et.getText().toString());
                editor.apply();
            }
        });



        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                {
                    sms = preferences.getString("sms","no");

                    sms=sms.replace("$name$","eda");
                    sms=sms.replace("$age$","42");

                    num="05321234567";
                }
                if(i==1)
                {
                    sms = preferences.getString("sms","no");

                    sms=sms.replace("$name$","yağmur");
                    sms=sms.replace("$age$","11");
                    num="05321267867";

                }
                if(i==2)
                {
                    sms = preferences.getString("sms","no");

                    sms=sms.replace("$name$","sude");
                    sms=sms.replace("$age$","14");

                    num="05123234567";
                }
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
                {
                    int smsPermission= checkSelfPermission(Manifest.permission.SEND_SMS);

                    if (smsPermission!= PackageManager.PERMISSION_GRANTED)
                    {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},0);
                    }
                    else if (smsPermission== PackageManager.PERMISSION_GRANTED)
                    {
                        smsSendingFun();
                    }
                }
                else
                {
                    smsSendingFun();
                }
            }
        });
    }


    public void smsSendingFun()
    {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, sms, null, null);
    }

}