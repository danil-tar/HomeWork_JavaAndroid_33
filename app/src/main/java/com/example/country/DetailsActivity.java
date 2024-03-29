package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.country.http.CountryDetailsDto;
import com.example.country.http.CountryDto;
import com.example.country.http.HttpService;

import java.io.Serializable;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Serializable serializable =
                bundle.getSerializable(CountryDtoDb.class.getSimpleName());
        if (serializable == null) {
            return;
        }
        CountryDtoDb serializableCountry = (CountryDtoDb) serializable;

        String code = serializableCountry.code;
        HttpService httpService = new HttpService();
        httpService.getCountry(code, new HttpService.CountryCallback() {
            @Override
            public void onSuccess(List<CountryDetailsDto> country) {

                TextView nameCountry = findViewById(R.id.name_country);
                ImageView flagCountry = findViewById(R.id.flag_country);
                TextView nameCapital = findViewById(R.id.name_capital);
                TextView areaCountry = findViewById(R.id.area_country);
                TextView populationCountry = findViewById(R.id.population_textView);
//
                nameCountry.setText(country.get(0).name.getCommon());
                nameCapital.setText(country.get(0).capital.get(0));
                areaCountry.setText(country.get(0).area + " km²");
                populationCountry.setText(country.get(0).population + " people");
                Glide.with(DetailsActivity.this)
                        .load(country.get(0).flags.getSvg())
                        .into(flagCountry);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });


//        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
//        DetalsViewModel detalsViewModel = viewModelProvider.get(DetalsViewModel.class);
//        detalsViewModel.setSelectedCountry(serializableCountry);

//        detalsViewModel.getSelectedCountry().observe(this, country -> {
//            nameCountry.setText(country.country);
////            nameCapital.setText(country.capital);
////            areaCountry.setText(country.area + " km²");
//            Glide.with(this)
//                    .load(country.urlFlag)
//                    .into(flagCountry);
//
//        });

        View buttonGoBack = findViewById(R.id.button_go_back);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}