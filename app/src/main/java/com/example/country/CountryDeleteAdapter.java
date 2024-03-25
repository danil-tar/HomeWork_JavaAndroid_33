package com.example.country;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CountryDeleteAdapter {
    Context context;
    List<Country> allCountries = new ArrayList<>();

    public CountryDeleteAdapter(Context context) {
        this.context = context;
        allCountries = App.getInstance().getDatabase().countryDao().getAllCountries();
    }

    BaseAdapter baseAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return allCountries.size();
        }

        @Override
        public Object getItem(int position) {
            return allCountries.get(position);
        }

        @Override
        public long getItemId(int position) {
            return allCountries.get(position).id;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).
                    inflate(R.layout.activity_add_delete_country, parent, false);

            Country country = allCountries.get(position);


            return null;
        }
    };

}
