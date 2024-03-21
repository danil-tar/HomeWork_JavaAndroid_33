package com.example.country;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    List<Country> getAllCountries();

    @Query("SELECT * FROM country WHERE country = :country")
    Country getCountry(String country);

    @Insert
    void insertCountry(Country country);

    @Delete
    void deleteCountry(Country country);

    @Update
    void updateCountry(Country country);

    @Query("DELETE FROM country")
    void deleteAllCountries();
}
