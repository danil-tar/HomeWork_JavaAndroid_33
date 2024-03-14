package com.example.country;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
    Button buttonGoBack;
    private Country country;

    public FragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    DetalesViewModel detalesViewModel = new DetalesViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameCountry = view.findViewById(R.id.name_country);
        flagCountry = view.findViewById(R.id.flag_country);
        nameCapital = view.findViewById(R.id.name_capital);
        areaCountry = view.findViewById(R.id.area_country);
        buttonGoBack = view.findViewById(R.id.button_go_back);

        nameCountry.setText(country.country);
        flagCountry.setImageResource(country.flagId);
        nameCapital.setText(country.capital);
        areaCountry.setText(String.valueOf("Area: " + country.area + " km²"));

        buttonGoBack.setOnClickListener(v -> {
            FragmentListCountrys fragmentListCountrys =
                    ((MainActivity) getActivity()).getFragmentListCountrys();

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_main, fragmentListCountrys)
                    .commit();

//            getActivity().getOnBackPressedDispatcher().onBackPressed()
        });
    }

    public void setSelectedItem(Country country) {
        this.country = country;
    }
}