package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class AddCountryActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        CountryDao countryDao = App.getInstance().getDatabase().countryDao();
        findViewById(R.id.AddDefaultCountrys_button).setOnClickListener(v -> {

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

        });

        findViewById(R.id.button_go_back).setOnClickListener(v -> {
            startActivity(new Intent(AddCountryActivity.this, MainActivity.class));
        });

        findViewById(R.id.AddNewCountry_button).setOnClickListener(v -> {
            View addNewCountry_relativeLayout = findViewById(R.id.AddNewCountry_relativeLayout);

            findViewById(R.id.DeleteAllCountries_button).setVisibility(View.GONE);
            addNewCountry_relativeLayout.setVisibility(View.VISIBLE);
        });

        findViewById(R.id.SaveCountry_button).setOnClickListener(v1 -> {
            View addNewCountry_relativeLayout = findViewById(R.id.AddNewCountry_relativeLayout);

            EditText nameText = findViewById(R.id.AddNameNewCountry_editText);
            EditText urlFlagText = findViewById(R.id.AddUrlFlag_editText);
            EditText capitalText = findViewById(R.id.AddCapitalNewCountry_editText);
            EditText areaText = findViewById(R.id.AddAreaNewCountry_editText);

            String nameString = nameText.getText().toString();
            if (checkNameCountry(countryDao, nameText, nameString)) return;
            String name = nameString;

            String urlFlagString = urlFlagText.getText().toString();
            if (checkUrlFlag(urlFlagText, urlFlagString)) return;
            String urlFlag = urlFlagString;

            String capitalString = capitalText.getText().toString();
            if (checkCapital(capitalText, capitalString)) return;
            String capital = capitalText.getText().toString();

            String stringArea = areaText.getText().toString();
            if (checkArea(areaText, stringArea)) return;
            Integer area = Integer.parseInt(stringArea);

            countryDao.insertCountry(new Country(name, urlFlag, capital, area));
            Toast.makeText(this, "New Country is saved", Toast.LENGTH_SHORT).show();
            addNewCountry_relativeLayout.setVisibility(View.GONE);

            findViewById(R.id.DeleteAllCountries_button).setVisibility(View.VISIBLE);
        });


        findViewById(R.id.DeleteAllCountries_button).setOnClickListener(v -> {
            countryDao.deleteAllCountries();
        });


    }

    private boolean checkArea(EditText areaText, String stringArea) {
        if (!stringArea.matches("[0-9]+")) {
            Toast.makeText(this, "Area should contain only numbers", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (stringArea.isEmpty()) {
            Toast.makeText(this, "Area is empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean checkCapital(EditText capitalText, String capitalString) {
        if (capitalString.isEmpty()) {
            Toast.makeText(this, "Capital name is empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (!capitalString.matches("[a-zA-Z]+")) {
            Toast.makeText(this, "Capital name should contain only letters", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean checkUrlFlag(EditText urlFlagText, String urlFlagString) {
        if (!isUrlCorrect(urlFlagText, urlFlagString)) {
            Toast.makeText(this, "URL is incorrect", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private boolean checkNameCountry(CountryDao countryDao, EditText nameText, String nameString) {
        if (countryDao.isCountryExist(nameString)) {
            Toast.makeText(this, "Country already exists", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (nameString.isEmpty()) {
            Toast.makeText(this, "Country name is empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private static boolean isUrlCorrect(EditText urlText, String urlString) {
        try {
            URL url = new URL(urlString);
            urlText.setTextColor(Color.BLACK);
            return true;

        } catch (Exception e) {
            urlText.setTextColor(Color.RED);
            return false;
        }
    }
}