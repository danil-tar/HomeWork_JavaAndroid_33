package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {
    private FragmentListCountrys fragmentListCountrys;
    private FragmentDetails fragmentDetails;

    public FragmentListCountrys getFragmentListCountrys() {
        return fragmentListCountrys;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        DetalsViewModel detalsViewModel = viewModelProvider.get(DetalsViewModel.class);
        CountrysViewModel countrysViewModel = viewModelProvider.get(CountrysViewModel.class);

        fragmentDetails = new FragmentDetails();

        fragmentListCountrys = new FragmentListCountrys(country -> {

            fragmentDetails.setSelectedItem(country);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_main, fragmentDetails)
                    .addToBackStack(null)
                    .commit();

        });

        setContentView(R.layout.activity_main);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragmentListCountrys)
                .commit();
    }

}