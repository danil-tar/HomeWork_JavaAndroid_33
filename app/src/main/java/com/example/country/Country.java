package com.example.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Country implements Serializable {
    @PrimaryKey
    @NonNull
    String country;
    String urlFlag;
    String capital;
    Integer area;

    public Country(String country, String urlFlag, String capital, Integer area) {
        this.country = country;
        this.capital = capital;
        this.area = area;
        this.urlFlag = urlFlag;

    }

}
