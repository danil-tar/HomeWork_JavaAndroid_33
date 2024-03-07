package com.example.country;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentDetails extends Fragment {
    TextView nameCountry;
    ImageView flagCountry;
    TextView nameCapital;
    TextView areaCountry;
    Button  buttonGoBack;

    public FragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);

        nameCountry = view.findViewById(R.id.name_country);
        flagCountry = view.findViewById(R.id.flag_country);
        nameCapital = view.findViewById(R.id.name_capital);
        areaCountry = view.findViewById(R.id.area_country);
        buttonGoBack = view.findViewById(R.id.button_go_back);

        buttonGoBack.setOnClickListener(v -> getActivity().finish());
        return view;
    }
    public void setSelectedItem(Country country) {
        nameCountry.setText(country.country);
        flagCountry.setImageResource(country.flagId);
        nameCapital.setText(country.capital);
        areaCountry.setText(String.valueOf(country.area));
    }
}