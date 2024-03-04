package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowCountryData extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_country_data);

        TextView nameCountry = findViewById(R.id.name_country);
        ImageView flagCountry = findViewById(R.id.flag_country);
        TextView nameCapital = findViewById(R.id.name_capital);
        TextView areaCountry = findViewById(R.id.area_country);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Country serializableCountry =
                (Country) bundle.getSerializable(Country.class.getSimpleName());

        nameCountry.setText(serializableCountry.country);
        flagCountry.setBackgroundResource(serializableCountry.flagId);
        nameCapital.setText(serializableCountry.capital);
        areaCountry.setText(serializableCountry.area + " km²");

        View buttonGoBack = findViewById(R.id.button_go_back);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}