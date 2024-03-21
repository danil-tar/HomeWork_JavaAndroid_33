package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class Details extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nameCountry = findViewById(R.id.name_country);
        ImageView flagCountry = findViewById(R.id.flag_country);
        TextView nameCapital = findViewById(R.id.name_capital);
        TextView areaCountry = findViewById(R.id.area_country);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Serializable serializable =
                bundle.getSerializable(Country.class.getSimpleName());
        if (serializable == null) {
            return;
        }
        Country serializableCountry = (Country) serializable;

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        DetalsViewModel detalsViewModel = viewModelProvider.get(DetalsViewModel.class);
        detalsViewModel.setSelectedCountry(serializableCountry);

        detalsViewModel.getSelectedCountry().observe(this, country -> {
            nameCountry.setText(country.country);
            nameCapital.setText(country.capital);
            areaCountry.setText(country.area + " km²");
            Glide.with(this)
                    .load(country.urlFlag)
                    .into(flagCountry);

        });

        View buttonGoBack = findViewById(R.id.button_go_back);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}