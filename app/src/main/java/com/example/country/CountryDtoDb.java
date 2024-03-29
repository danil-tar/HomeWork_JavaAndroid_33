package com.example.country;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CountryDtoDb implements Serializable {
    @PrimaryKey
    @NonNull
    String code;
    String country;
    String urlFlag;


    public CountryDtoDb(@NonNull String code, String country, String urlFlag) {
        this.code = code;
        this.country = country;
        this.urlFlag = urlFlag;

    }

}
