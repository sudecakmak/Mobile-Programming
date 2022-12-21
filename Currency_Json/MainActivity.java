package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bfind,bload;
    RequestQueue mqueue;

    List<Money> Data = new ArrayList<Money>();
    DatabaseHelper dbAdapter;
    ListView lw;
    int selected_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw=findViewById(R.id.list);
        bfind=findViewById(R.id.btn_find);
        bload=findViewById(R.id.btn_load);

        dbAdapter = new DatabaseHelper(this);
        mqueue = Volley.newRequestQueue(this);

        Data=dbAdapter.getList();
        weatherAdaptor adaptor = new weatherAdaptor(MainActivity.this,Data);
        lw.setAdapter(adaptor);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Money tmp = (Money) adapterView.getAdapter().getItem(i);
                selected_id=Integer.parseInt(tmp.getID());
            }
        });

        bfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Url = "http://hasanadiguzel.com.tr/api/kurgetir";

                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            for(int i=0;i<23;i++)
                            {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                                String stringDate = sdf.format(new Date());

                                JSONArray weather = response.getJSONArray("TCMB_AnlikKurBilgileri");
                                String CurrencyName = ((JSONObject)weather.get(i)).getString("Isim");
                                String ForexSelling = ((JSONObject)weather.get(i)).getString("ForexSelling");
                                String ForexBuying = ((JSONObject)weather.get(i)).getString("ForexBuying");

                                dbAdapter.add(CurrencyName,ForexSelling,ForexBuying,stringDate);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                mqueue.add(request);
                List();
            }

        });


        bload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List();
            }
        });

    }


    public  void List() {
        Data=dbAdapter.getList();
        weatherAdaptor adaptor = new weatherAdaptor(MainActivity.this,Data);
        lw.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();
    }
}