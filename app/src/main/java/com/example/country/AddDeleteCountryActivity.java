package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.util.List;

public class AddDeleteCountryActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_country);

        View btnGoBack = findViewById(R.id.button_go_back);
        View btnDeleteCountry = findViewById(R.id.DeleteCountry_button);

        btnGoBack.setOnClickListener(v -> {
            startActivity(new Intent(AddDeleteCountryActivity.this, MainActivity.class));
        });

        CountryDao countryDao = App.getInstance().getDatabase().countryDao();



        List<CountryDtoDb> countries = countryDao.getAllCountries();

        ListView listDeleteCountries = findViewById(R.id.deleteCountries_listView);
        CountryDeleteAdapter countryDeleteAdapter = new CountryDeleteAdapter(this, countries);
        listDeleteCountries.setAdapter(countryDeleteAdapter);


        View deleteCountries_RelativeLayout = findViewById(R.id.deleteCountries_RelativeLayout);

        btnDeleteCountry.setOnClickListener(v -> {
            if (deleteCountries_RelativeLayout.getVisibility() == (View.VISIBLE)) {
                deleteCountries_RelativeLayout.setVisibility(View.GONE);
                return;
            }
            deleteCountries_RelativeLayout.setVisibility(View.VISIBLE);

        });

        findViewById(R.id.DeleteSelectedCountries_button).setOnClickListener(v1 -> {
            for (int i = 0; i < listDeleteCountries.getChildCount(); i++) {
                View view = listDeleteCountries.getChildAt(i);
                CheckBox checkBox = view.findViewById(R.id.checkBoxDeletingCountry);
                if (checkBox.isChecked()) {
                    CountryDtoDb country = countries.get(i);
                    countryDao.deleteCountry(country);
                }
            }
            countryDeleteAdapter.notifyDataSetChanged();
            deleteCountries_RelativeLayout.setVisibility(View.GONE);
            Toast.makeText(this, "Selected countries are deleted", Toast.LENGTH_SHORT).show();
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