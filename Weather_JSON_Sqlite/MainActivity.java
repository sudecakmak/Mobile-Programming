package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

    //String Url ="https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=62cf1105ef0851b016e5ba3f507dc430";

    EditText city;
    Button bfind,bload,bdel;
    RequestQueue mqueue;

    List<Weather> Data = new ArrayList<Weather>();
    DatabaseHelper dbAdapter;
    ListView lw;
    int selected_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw=findViewById(R.id.list);
        city = findViewById(R.id.et_city);
        bfind=findViewById(R.id.btn_find);
        bload=findViewById(R.id.btn_load);
        bdel=findViewById(R.id.btn_del);

        dbAdapter = new DatabaseHelper(this);
        mqueue = Volley.newRequestQueue(this);

        Data=dbAdapter.getList();
        weatherAdaptor adaptor = new weatherAdaptor(MainActivity.this,Data);
        lw.setAdapter(adaptor);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Weather tmp = (Weather) adapterView.getAdapter().getItem(i);
                selected_id=Integer.parseInt(tmp.getID());
            }
        });

        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbAdapter.delete(Integer.toString(selected_id));
                List();
            }
        });


        bfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String City_name = city.getText().toString();
                String Url = "https://api.openweathermap.org/data/2.5/weather?q="+City_name+"&appid=62cf1105ef0851b016e5ba3f507dc430";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                            String stringDate = sdf.format(new Date());

                            String City = response.getString("name");

                            JSONObject jsonObjectMain = response.getJSONObject("main");
                            String temperature = jsonObjectMain.getString("temp");

                            JSONArray weather = response.getJSONArray("weather");
                            String main = ((JSONObject)weather.get(0)).getString("main");

                            String icon = ((JSONObject)weather.get(0)).getString("icon");
                            String imgUrl = "https://openweathermap.org/img/wn/"+icon+"@2x.png";


                            dbAdapter.add(City,main,temperature,imgUrl,stringDate);

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