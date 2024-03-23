package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        findViewById(R.id.AddDefaultCountrys_button).setOnClickListener(v -> {
            CountryDao countryDao = App.getInstance().getDatabase().countryDao();

            countryDao.insertCountry(new Country("Russia", "https://flagsapi.com/RU/shiny/64.png", "Moscow", 17098242));
            countryDao.insertCountry(new Country("China", "https://flagsapi.com/CN/shiny/64.png", "Beijing", 9596961));
            countryDao.insertCountry(new Country("Germany", "https://flagsapi.com/DE/shiny/64.png", "Berlin", 357578));
            countryDao.insertCountry(new Country("India", "https://flagsapi.com/IN/shiny/64.png", "New Delhi", 3287263));
            countryDao.insertCountry(new Country("Italia", "https://flagsapi.com/IT/shiny/64.png", "Rome", 301340));
            countryDao.insertCountry(new Country("France", "https://flagsapi.com/FR/shiny/64.png", "Paris", 543965));
            countryDao.insertCountry(new Country("Canada", "https://flagsapi.com/CA/shiny/64.png", "Ottawa", 9984670));
            countryDao.insertCountry(new Country("USA", "https://flagsapi.com/US/shiny/64.png", "Washington", 9826675));
            countryDao.insertCountry(new Country("Vietnam", "https://flagsapi.com/VN/shiny/64.png", "Hanoi", 331212));
            countryDao.insertCountry(new Country("Great Britain", "https://flagsapi.com/GB/shiny/64.png", "London", 242495));
            countryDao.insertCountry(new Country("Portugal", "https://flagsapi.com/PT/shiny/64.png", "Lisbon", 92212));
            countryDao.insertCountry(new Country("Spain", "https://flagsapi.com/ES/shiny/64.png", "Madrid", 505992));

            startActivity(getIntent());
        });

        findViewById(R.id.button_go_back).setOnClickListener(v -> {
            startActivity(new Intent(AddCountryActivity.this, MainActivity.class));
        });

        findViewById(R.id.AddNewCountry_button).setOnClickListener(v -> {
            View addNewCountry_relativeLayout = findViewById(R.id.AddNewCountry_relativeLayout);

            findViewById(R.id.DeleteAllCountries_button).setVisibility(View.GONE);
            addNewCountry_relativeLayout.setVisibility(View.VISIBLE);

            EditText nameText = findViewById(R.id.AddNameNewCountry_editText);
            String nameString  = nameText.getText().toString();
            String name = nameString.isEmpty() ? "Unknown" : nameString;

            EditText urlFlagText = findViewById(R.id.AddUrlFlag_editText);
            String urlFlagString = urlFlagText.getText().toString();
            String urlFlag = urlFlagString.isEmpty() ? "https://flagsapi.com/RU/shiny/64.png" : urlFlagString;

            EditText capitalText = findViewById(R.id.AddCapitalNewCountry_editText);
            String capitalString = capitalText.getText().toString();
            String capital = capitalString.isEmpty() ? "Unknown" : capitalString;

            EditText areaText = findViewById(R.id.AddAreaNewCountry_editText);
            String stringArea = areaText.getText().toString();
            stringArea = stringArea.isEmpty() ? "0" : stringArea;
            Integer area = Integer.parseInt(stringArea);

            findViewById(R.id.SaveCountry_button).setOnClickListener(v1 -> {

                CountryDao countryDao = App.getInstance().getDatabase().countryDao();
                countryDao.insertCountry(new Country(name, urlFlag, capital, area));
                addNewCountry_relativeLayout.setVisibility(View.GONE);

                findViewById(R.id.DeleteAllCountries_button).setVisibility(View.VISIBLE);
            });
        });

        findViewById(R.id.DeleteAllCountries_button).setOnClickListener(v -> {
            App.getInstance().getDatabase().countryDao().deleteAllCountries();
            startActivity(getIntent());
        });


    }
}