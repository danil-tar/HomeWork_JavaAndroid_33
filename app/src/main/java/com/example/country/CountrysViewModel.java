package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountrysViewModel extends ViewModel {
    MutableLiveData<List<CountryDtoDb>> countryArrayLists = new MutableLiveData<>();

    public CountrysViewModel() {
        ArrayList<CountryDtoDb> countries = new ArrayList<>();
        App.getInstance().getDatabase().countryDao().getAllCountries().forEach(country -> {
            countries.add(country);
        });

        this.countryArrayLists.setValue(countries);
    }

    public MutableLiveData<List<CountryDtoDb>> getCountryArrayLists() {
        return countryArrayLists;
    }

    public void setCountryArrayLists(MutableLiveData<List<CountryDtoDb>> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }
}
