package com.example.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Country extends BaseAdapter {
    Context context;
    String[] countryList;
    int[] flags;
    LayoutInflater inflater;

    public Country(Context applicationContext, String[] countryList, int[] flags) {
        this.context = applicationContext;
        this.countryList = countryList;
        this.flags = flags;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.activity_main, null);

        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView flag = (ImageView) view.findViewById(R.id.icon);

        int i = position;
        country.setText(countryList[i]);
        flag.setImageResource(flags[i]);

        return view;
    }
}
