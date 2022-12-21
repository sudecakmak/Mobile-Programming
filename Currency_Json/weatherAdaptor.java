package com.example.weather;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class weatherAdaptor extends BaseAdapter {
    List<Money> myList;
    LayoutInflater Inflater;

    public weatherAdaptor(Activity activity, List<Money> myList)
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

        Money w = myList.get(i);

        city.setText(w.getCurrencyName());
        weather.setText(w.getForexBuying());
        temperature.setText(w.getForexSelling());
        tw_date.setText(w.getDate());


        return lineView;
    }
}
