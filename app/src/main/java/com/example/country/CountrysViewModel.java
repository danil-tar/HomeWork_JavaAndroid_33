package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountrysViewModel extends ViewModel {
    MutableLiveData<List<Country>> countryArrayLists = new MutableLiveData<>();

    public CountrysViewModel() {
        ArrayList<Country> countryes = new ArrayList<>();
        countryes.add(new Country("Russia", "https://flagsapi.com/RU/shiny/64.png", "Moscow", 17098242));
        countryes.add(new Country("China", "https://flagsapi.com/CN/shiny/64.png", "Beijing", 9596961));
        countryes.add(new Country("Germany", "https://flagsapi.com/DE/shiny/64.png", "Berlin", 357578));
        countryes.add(new Country("India", "https://flagsapi.com/IN/shiny/64.png", "New Delhi", 3287263));
        countryes.add(new Country("Italia", "https://flagsapi.com/IT/shiny/64.png", "Rome", 301340));
        countryes.add(new Country("France", "https://flagsapi.com/FR/shiny/64.png", "Paris", 543965));
        countryes.add(new Country("Canada", "https://flagsapi.com/CA/shiny/64.png", "Ottawa", 9984670));
        countryes.add(new Country("USA", "https://flagsapi.com/US/shiny/64.png", "Washington", 9826675));
        countryes.add(new Country("Vietnam", "https://flagsapi.com/VN/shiny/64.png", "Hanoi", 331212));
        countryes.add(new Country("Great Britain", "https://flagsapi.com/GB/shiny/64.png", "London", 242495));
        countryes.add(new Country("Portugal", "https://flagsapi.com/PT/shiny/64.png", "Lisbon", 92212));
        countryes.add(new Country("Spain", "https://flagsapi.com/ES/shiny/64.png", "Madrid", 505992));
        this.countryArrayLists.setValue(countryes);
    }

    public MutableLiveData<List<Country>> getCountryArrayLists() {
        return countryArrayLists;
    }

    public void setCountryArrayLists(MutableLiveData<List<Country>> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }
}
