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
    void insertCountry(CountryDtoDb country);

    @Query("SELECT * FROM CountryDtoDb")
    List<CountryDtoDb> getAllCountries();

    @Query("SELECT * FROM CountryDtoDb WHERE country = :country")
    CountryDtoDb getCountry(String country);

    @Query("SELECT EXISTS(SELECT * FROM CountryDtoDb WHERE country = :country)")
    boolean isCountryExist(String country);

    @Delete
    void deleteCountry(CountryDtoDb country);

    @Update
    void updateCountry(CountryDtoDb country);

    @Query("DELETE FROM CountryDtoDb")
    void deleteAllCountries();
}
