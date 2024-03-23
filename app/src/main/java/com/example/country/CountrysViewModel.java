package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountrysViewModel extends ViewModel {
    MutableLiveData<List<Country>> countryArrayLists = new MutableLiveData<>();

    public CountrysViewModel() {
        ArrayList<Country> countries = new ArrayList<>();
        App.getInstance().getDatabase().countryDao().getAllCountries().forEach(country -> {
            countries.add(country);
        });

        this.countryArrayLists.setValue(countries);
    }

    public MutableLiveData<List<Country>> getCountryArrayLists() {
        return countryArrayLists;
    }

    public void setCountryArrayLists(MutableLiveData<List<Country>> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }
}
