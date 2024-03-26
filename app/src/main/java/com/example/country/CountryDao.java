package com.example.country;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountry(Country country);

    @Query("SELECT * FROM country")
    List<Country> getAllCountries();

    @Query("SELECT * FROM country WHERE country = :country")
    Country getCountry(String country);

    @Query("SELECT EXISTS(SELECT * FROM country WHERE country = :country)")
    boolean isCountryExist(String country);

    @Delete
    void deleteCountry(Country country);

    @Update
    void updateCountry(Country country);

    @Query("DELETE FROM country")
    void deleteAllCountries();
}
