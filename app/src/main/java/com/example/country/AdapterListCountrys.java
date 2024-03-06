package com.example.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListCountrys extends BaseAdapter {

    Context context;
    List<Country> countryArrayLists;
    LayoutInflater inflater;

    public AdapterListCountrys(Context applicationContext, List<Country> countryArrayLists) {
        this.context = applicationContext;
        this.countryArrayLists = countryArrayLists;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryArrayLists.size();
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

        View view = inflater.inflate(R.layout.activity_item, null);

        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView flag = (ImageView) view.findViewById(R.id.icon);

        country.setText(countryArrayLists.get(position).country);
        flag.setImageResource(countryArrayLists.get(position).flagId);

        return view;
    }
}


