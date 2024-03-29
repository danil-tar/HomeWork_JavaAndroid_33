package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.country.http.CountryDto;
import com.example.country.http.HttpService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CountryDtoDb> countryList = new ArrayList<>();
    RecyclerView recycleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        HttpService httpService = new HttpService();
        httpService.getCountries(new HttpService.CountriesCallback() {
            @Override
            public void onSuccess(List<CountryDto> countries) {
                Log.d("onSuccess Countries", countries.toString());
                for (CountryDto countryDto : countries) {
                    CountryDto.Flags flags = countryDto.getFlags();
                    String png = flags.getPng();

                    CountryDto.Name name = countryDto.getName();
                    String nameCommone = name.getCommon();
                    countryList.add(new CountryDtoDb(countryDto.getCode(), nameCommone, png));
                }

                recycleList = findViewById(R.id.recyclerView);
                recycleList.setAdapter(new CountryRecyclerAdapter(countryList, MainActivity.this));
                CountryDao countryDao = App.getInstance().getDatabase().countryDao();

                for (CountryDtoDb country : countryList) {
                    if (!countryDao.isCountryExist(country.country)) {
                        countryDao.insertCountry(country);
                    }
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d("onFailure", throwable.getMessage());
            }
        });

    }


}