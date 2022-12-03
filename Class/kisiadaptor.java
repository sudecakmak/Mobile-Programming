package com.example.aaaaaaaaaaaa;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class kisiadaptor extends BaseAdapter {
    List<kisi> myUserList;
    LayoutInflater userInflater;

    public kisiadaptor (Activity activity, List<kisi> myUserList)
    {
        this.myUserList = myUserList;
        userInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myUserList.size();
    }

    @Override
    public Object getItem(int i) {
        return myUserList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View lineView;
        lineView = userInflater.inflate(R.layout.satir,null);

        TextView lbAd = lineView.findViewById(R.id.lbAd);
        TextView lbYas = lineView.findViewById(R.id.lbYas);
        ImageView img = lineView.findViewById(R.id.img_Resim);

        kisi tmpkisi = myUserList.get(i);
        lbAd.setText(tmpkisi.getKisiAd());
        lbYas.setText(tmpkisi.getKisiYas());

        if(tmpkisi.getKadinmi())
        {
            if(Integer.parseInt(tmpkisi.getKisiYas()) < 16)
            {
                img.setImageResource(R.drawable.kid_girl);
            }
            else if(16 < Integer.parseInt(tmpkisi.getKisiYas()) && Integer.parseInt(tmpkisi.getKisiYas()) < 60)
            {
                img.setImageResource(R.drawable.woman);
            }
            else if(Integer.parseInt(tmpkisi.getKisiYas()) > 60)
            {
                img.setImageResource(R.drawable.old_woman);
            }
        }
        else
        {
            if(Integer.parseInt(tmpkisi.getKisiYas()) < 16)
            {
                img.setImageResource(R.drawable.kid_boy);
            }
            else if(16 < Integer.parseInt(tmpkisi.getKisiYas()) && Integer.parseInt(tmpkisi.getKisiYas()) < 60)
            {
                img.setImageResource(R.drawable.man);
            }
            else if(Integer.parseInt(tmpkisi.getKisiYas()) > 60)
            {
                img.setImageResource(R.drawable.old_man);
            }
        }

        return lineView;
    }
}
