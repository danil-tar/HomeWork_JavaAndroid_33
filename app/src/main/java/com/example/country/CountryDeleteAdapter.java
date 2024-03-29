package com.example.country;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class CountryDeleteAdapter extends BaseAdapter {

    Context context;
    List<CountryDtoDb> countryArrayLists;
    LayoutInflater inflater;

    public CountryDeleteAdapter(Context applicationContext, List<CountryDtoDb> countryArrayLists) {
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

        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.activity_item_delete, null);

        CheckBox checkBox = view.findViewById(R.id.checkBoxDeletingCountry);
        TextView country = (TextView) view.findViewById(R.id.nameDeletingCountry);

        country.setText(countryArrayLists.get(position).country);

        return view;
    }
}

