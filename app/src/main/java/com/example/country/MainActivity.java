package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList = new ArrayList<>();
    RecyclerView recycleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recycleList = findViewById(R.id.recyclerView);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        CountrysViewModel countrysViewModel = viewModelProvider.get(CountrysViewModel.class);

        countryList = countrysViewModel.getCountryArrayLists().getValue();

        countrysViewModel.getCountryArrayLists().observe(this, countryArrayLists -> {
            this.countryList = countryArrayLists;
            recycleList.setAdapter(new CountryRecyclerAdapter(countryList, this));
        });


        findViewById(R.id.AddCountry_button).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddDeleteCountryActivity.class));
        });
    }
}