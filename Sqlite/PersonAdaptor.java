package com.example.aaaaaaaaaaaa;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdaptor extends BaseAdapter {
    List<Person> myUserList;
    LayoutInflater userInflater;

    public PersonAdaptor(Activity activity, List<Person> myUserList)
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
        lineView = userInflater.inflate(R.layout.row,null);

        TextView Age = lineView.findViewById(R.id.lbAge);
        TextView Name = lineView.findViewById(R.id.lbName);
        TextView Color = lineView.findViewById(R.id.lbColor);
        ImageView Img = lineView.findViewById(R.id.img);

        Person tmp = myUserList.get(i);
        Name.setText(tmp.getName());
        Age.setText(tmp.getAge());
        Color.setText(tmp.getColor());

        if(tmp.getWoman().equals("Woman"))
        {
            if(Integer.parseInt(tmp.getAge()) < 16)
            {
                Img.setImageResource(R.drawable.kid_girl);
            }
            else if(16 < Integer.parseInt(tmp.getAge()) && Integer.parseInt(tmp.getAge()) < 60)
            {
                Img.setImageResource(R.drawable.woman);
            }
            else if(Integer.parseInt(tmp.getAge()) > 60)
            {
                Img.setImageResource(R.drawable.old_woman);
            }
        }
        else
        {
            if(Integer.parseInt(tmp.getAge()) < 16)
            {
                Img.setImageResource(R.drawable.kid_boy);
            }
            else if(16 < Integer.parseInt(tmp.getAge()) && Integer.parseInt(tmp.getAge()) < 60)
            {
                Img.setImageResource(R.drawable.man);
            }
            else if(Integer.parseInt(tmp.getAge()) > 60)
            {
                Img.setImageResource(R.drawable.old_man);
            }
        }

        return lineView;
    }
}
