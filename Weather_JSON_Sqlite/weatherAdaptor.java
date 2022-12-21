package com.example.weather;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class weatherAdaptor extends BaseAdapter {
    List<Weather> myList;
    LayoutInflater Inflater;

    public weatherAdaptor(Activity activity, List<Weather> myList)
    {
        this.myList = myList;
        Inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View lineView;
        lineView = Inflater.inflate(R.layout.row,null);

        TextView city = lineView.findViewById(R.id.city);
        TextView weather = lineView.findViewById(R.id.weather);
        TextView temperature = lineView.findViewById(R.id.temperature);
        TextView tw_date = lineView.findViewById(R.id.date);
        ImageView img = lineView.findViewById(R.id.img);

        Weather w = myList.get(i);
        city.setText(w.getCity());
        weather.setText(w.getWeather());
        temperature.setText(w.getTemperature());
        tw_date.setText(w.getDate());

        Picasso.get().load(w.getWeatherImg()).into(img);
        img.setBackgroundColor(Color.BLACK);

        return lineView;
    }
}
