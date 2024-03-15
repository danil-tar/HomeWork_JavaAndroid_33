package com.example.country;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentListCountrys extends Fragment {
    private List<Country> countryArrayLists;
    private AdapterListCountrys adapterListCountrys;
    private FragmentDetails fragmentDetails = new FragmentDetails();

    interface CountrySelectListener {
        void onCountrySelected(Country country);
    }

    CountrySelectListener listener;


    public FragmentListCountrys(CountrySelectListener countrySelectListener) {
        this.listener = countrySelectListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.simpleListView);

        CountrysViewModel countrysViewModel
                = new ViewModelProvider(requireActivity()).get(CountrysViewModel.class);

        countrysViewModel.getCountryArrayLists().observe(getViewLifecycleOwner(), countries -> {
            countryArrayLists = countries;
        });

        adapterListCountrys = new AdapterListCountrys(getContext(), countryArrayLists);
        listView.setAdapter(adapterListCountrys);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            listener.onCountrySelected(countryArrayLists.get(position));
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_countrys, container, false);
    }

}