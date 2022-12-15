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

    List<Person> Data = new ArrayList<Person>();
    DatabaseHelper dbAdapter;
    ListView listView ;
    EditText name,color,age;
    RadioButton man,woman;
    Button add,delete,edit,list;

    int selected_id=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DatabaseHelper(this);

        listView = findViewById(R.id.list);
        name=findViewById(R.id.twname);
        age=findViewById(R.id.twage);
        color=findViewById(R.id.twcolor);
        man=findViewById(R.id.rman);
        woman=findViewById(R.id.rwoman);

        add=findViewById(R.id.badd);
        delete=findViewById(R.id.bdel);
        edit=findViewById(R.id.bedit);
        list=findViewById(R.id.blist);

        Data=dbAdapter.getList();
        PersonAdaptor adaptor = new PersonAdaptor(MainActivity.this,Data);
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Person tmp = (Person) adapterView.getAdapter().getItem(i);
                name.setText(tmp.getName());
                age.setText(tmp.getAge());
                color.setText(tmp.getColor());

                if(tmp.getWoman().equals("Woman"))
                {
                    woman.setChecked(true);
                }
                else
                {
                   man.setChecked(true);
                }

                selected_id=Integer.parseInt(tmp.getID());
            }

        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender="";
                if(woman.isChecked()) { gender = "Woman"; }
                else  { gender = "Man"; }

                dbAdapter.add(name.getText().toString(),age.getText().toString(),gender,color.getText().toString());

                adaptor.notifyDataSetChanged();
                List();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbAdapter.delete(Integer.toString(selected_id));
                adaptor.notifyDataSetChanged();

                List();

            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender="";
                if(woman.isChecked()) { gender = "Woman"; }
                else  { gender = "Man"; }

                dbAdapter.update(new Person(String.valueOf(selected_id),name.getText().toString(),age.getText().toString(),color.getText().toString(),gender));
                adaptor.notifyDataSetChanged();

                List();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List();
            }
        });
    }

    public void List() {
        Data=dbAdapter.getList();
        PersonAdaptor customAdaptor = new PersonAdaptor(MainActivity.this, Data);
        listView.setAdapter(customAdaptor);
    }
}