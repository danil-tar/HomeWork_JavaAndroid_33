package com.example.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Country {
    String country;
    int flagId;

    public Country(String country, int flagId) {
        this.country = country;
        this.flagId = flagId;
    }


}
