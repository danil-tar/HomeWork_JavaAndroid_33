package com.example.country;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {CountryDtoDb.class}, version = 1)
public abstract class CountrysDataBase extends RoomDatabase {
    public abstract CountryDao countryDao();
}
