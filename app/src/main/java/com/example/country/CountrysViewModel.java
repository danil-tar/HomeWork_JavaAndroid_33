package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountrysViewModel extends ViewModel {
    MutableLiveData<List<Country>> countryArrayLists = new MutableLiveData<>();

    public CountrysViewModel() {
        ArrayList<Country> countryes = new ArrayList<>();
        countryes.add(new Country("Russia", R.drawable.russia, "Moscow", 17098242));
        countryes.add(new Country("China", R.drawable.china, "Beijing", 9596961));
        countryes.add(new Country("Germany", R.drawable.germany, "Berlin", 357578));
        countryes.add(new Country("India", R.drawable.india, "New Delhi", 3287263));
        countryes.add(new Country("Italia", R.drawable.italia, "Rome", 301340));
        countryes.add(new Country("France", R.drawable.france, "Paris", 543965));
        countryes.add(new Country("Canada", R.drawable.canada, "Ottawa", 9984670));
        countryes.add(new Country("USA", R.drawable.usa, "Washington", 9826675));
        countryes.add(new Country("Vietnam", R.drawable.vietnam, "Hanoi", 331212));
        countryes.add(new Country("Great Britain", R.drawable.great_britain, "London", 242495));
        countryes.add(new Country("Portugal", R.drawable.portugal, "Lisbon", 92212));
        countryes.add(new Country("Spain", R.drawable.spain, "Madrid", 505992));
        this.countryArrayLists.setValue(countryes);
    }

    public MutableLiveData<List<Country>> getCountryArrayLists() {
        return countryArrayLists;
    }

    public void setCountryArrayLists(MutableLiveData<List<Country>> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }
}
