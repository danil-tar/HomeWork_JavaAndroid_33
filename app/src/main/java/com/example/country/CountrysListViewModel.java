package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountrysListViewModel extends ViewModel {
    MutableLiveData<List<Country>> countryArrayList = new MutableLiveData<>();
    public CountrysListViewModel() {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Russia", R.drawable.russia, "Moscow", 17098242));
        countryList.add(new Country("China", R.drawable.china, "Beijing", 9596961));
        countryList.add(new Country("Germany", R.drawable.germany, "Berlin", 357578));
        countryList.add(new Country("India", R.drawable.india, "New Delhi", 3287263));
        countryList.add(new Country("Italia", R.drawable.italia, "Rome", 301340));
        countryList.add(new Country("France", R.drawable.france, "Paris", 543965));
        countryList.add(new Country("Canada", R.drawable.canada, "Ottawa", 9984670));
        countryList.add(new Country("USA", R.drawable.usa, "Washington", 9826675));
        countryList.add(new Country("Vietnam", R.drawable.vietnam, "Hanoi", 331212));
        countryList.add(new Country("Great Britain", R.drawable.great_britain, "London", 242495));
        countryList.add(new Country("Portugal", R.drawable.portugal, "Lisbon", 92212));
        countryList.add(new Country("Spain", R.drawable.spain, "Madrid", 505992));
        countryArrayList.setValue(countryList);
    }

    public MutableLiveData<List<Country>> getCountryArrayList() {
        return countryArrayList;
    }

    public void setCountryArrayList(MutableLiveData<List<Country>> countryArrayList) {
        this.countryArrayList = countryArrayList;
    }
}
