package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FragmentListCountrys fragmentListCountrys;
    private FragmentDetails fragmentDetails;

    public FragmentListCountrys getFragmentListCountrys() {
        return fragmentListCountrys;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TEST", "onCreate:MainActivity");

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        CountrysListViewModel countrysListViewModel = viewModelProvider.get(CountrysListViewModel.class);
        DetalsViewModel detalsViewModel = viewModelProvider.get(DetalsViewModel.class);

        fragmentDetails = new FragmentDetails();

        fragmentListCountrys = new FragmentListCountrys(country -> {

            Log.d("TEST", "onCountrySelected:MainActivity");

            detalsViewModel.selectedCountry.setValue(country);

            fragmentDetails.setSelectedItem(detalsViewModel.selectedCountry.getValue());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_main, fragmentDetails)
                    .addToBackStack(null)
                    .commit();
        });

        setContentView(R.layout.activity_main);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        fragmentListCountrys.countryArrayLists = countrysListViewModel.getCountryArrayList().getValue();

        countrysListViewModel.getCountryArrayList().observe(this, countryArrayList -> {
            fragmentListCountrys.countryArrayLists = countryArrayList;
        });

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragmentListCountrys)
                .commit();
    }

}