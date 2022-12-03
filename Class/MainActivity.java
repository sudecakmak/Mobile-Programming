package com.example.aaaaaaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<kisi> KisiList = new ArrayList<kisi>();
    ListView listView ;
    EditText et1,et2;
    RadioButton r1,r2;
    Button b1,b2,b3;
    Boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.liste);
        et1=findViewById(R.id.twname);
        et2=findViewById(R.id.twyas);
        r1=findViewById(R.id.rman);
        r2=findViewById(R.id.rwoman);

        b1=findViewById(R.id.badd);
        b2=findViewById(R.id.bdel);
        b3=findViewById(R.id.bedit);

        kisiadaptor adaptor = new kisiadaptor(MainActivity.this,KisiList);
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                kisi tmp = (kisi) adapterView.getAdapter().getItem(i);
                et1.setText(tmp.getKisiAd());
                et2.setText(tmp.getKisiYas());

                if(tmp.getKadinmi())
                {
                    r2.setChecked(true);
                    b=true;
                }
                else
                {
                    r1.setChecked(true);
                    b=false;
                }

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        KisiList.remove(i);
                        adaptor.notifyDataSetChanged();

                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        kisi tmp = (kisi) adapterView.getAdapter().getItem(i);
                        tmp.setKisiAd(et1.getText().toString());
                        tmp.setKisiYas(et2.getText().toString());

                        if(r2.isChecked()) { tmp.setKadinmi(true); }
                        else  { tmp.setKadinmi(false); }

                        adaptor.notifyDataSetChanged();
                    }
                });
            }


        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KisiList.add(new kisi(et1.getText().toString(),et2.getText().toString(),r2.isChecked()));
                adaptor.notifyDataSetChanged();
            }
        });


    }
}