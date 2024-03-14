package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentListCountrys fragmentListCountrys;
    private FragmentDetails fragmentDetails;

    public FragmentListCountrys getFragmentListCountrys() {
        return fragmentListCountrys;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentDetails = new FragmentDetails();

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);

        DetalesViewModel detalesViewModel = viewModelProvider.get(DetalesViewModel.class);
        CountrysViewModel countrysViewModel = viewModelProvider.get(CountrysViewModel.class);

        fragmentListCountrys = new FragmentListCountrys(country -> {
            detalesViewModel.setSelectedItem(country);
            fragmentDetails.setSelectedItem(detalesViewModel.getSelectedItem());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_main, fragmentDetails)
                    .addToBackStack(null)
                    .commit();
        });

        setContentView(R.layout.activity_main);

        countrysViewModel.getCountryArrayLists().observe(this, countryArrayLists -> {
            fragmentListCountrys.setCountryArrayLists(countryArrayLists);
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_main, fragmentListCountrys)
                .commit();
    }

}