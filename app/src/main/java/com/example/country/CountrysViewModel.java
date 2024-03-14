package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CountrysViewModel extends ViewModel {
    MutableLiveData<List<Country>> countryArrayLists = new MutableLiveData<>();

    public CountrysViewModel() {
    }

    public MutableLiveData<List<Country>> getCountryArrayLists() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Russia", R.drawable.russia, "Moscow", 17098242));
        countries.add(new Country("China", R.drawable.china, "Beijing", 9596961));
        countries.add(new Country("Germany", R.drawable.germany, "Berlin", 357578));
        countries.add(new Country("India", R.drawable.india, "New Delhi", 3287263));
        countries.add(new Country("Italia", R.drawable.italia, "Rome", 301340));
        countries.add(new Country("France", R.drawable.france, "Paris", 543965));
        countries.add(new Country("Canada", R.drawable.canada, "Ottawa", 9984670));
        countries.add(new Country("USA", R.drawable.usa, "Washington", 9826675));
        countries.add(new Country("Vietnam", R.drawable.vietnam, "Hanoi", 331212));
        countries.add(new Country("Great Britain", R.drawable.great_britain, "London", 242495));
        countries.add(new Country("Portugal", R.drawable.portugal, "Lisbon", 92212));
        countries.add(new Country("Spain", R.drawable.spain, "Madrid", 505992));

        countryArrayLists.setValue(countries);

        return countryArrayLists;
    }

    public void setCountryArrayLists(MutableLiveData<List<Country>> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }

}
