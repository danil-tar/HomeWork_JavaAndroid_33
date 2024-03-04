package com.example.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Country implements Serializable {
    String country;
    int flagId;
    String capital;
    int area;

    public Country(String country, int flagId, String capital, int area) {
        this.country = country;
        this.flagId = flagId;
        this.capital = capital;
        this.area = area;

    }

}
