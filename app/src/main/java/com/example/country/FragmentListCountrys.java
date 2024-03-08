package com.example.country;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

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

        countryArrayLists = new ArrayList<>();
        countryArrayLists.add(new Country("Russia", R.drawable.russia, "Moscow", 17098242));
        countryArrayLists.add(new Country("China", R.drawable.china, "Beijing", 9596961));
        countryArrayLists.add(new Country("Germany", R.drawable.germany, "Berlin", 357578));
        countryArrayLists.add(new Country("India", R.drawable.india, "New Delhi", 3287263));
        countryArrayLists.add(new Country("Italia", R.drawable.italia, "Rome", 301340));
        countryArrayLists.add(new Country("France", R.drawable.france, "Paris", 543965));
        countryArrayLists.add(new Country("Canada", R.drawable.canada, "Ottawa", 9984670));
        countryArrayLists.add(new Country("USA", R.drawable.usa, "Washington", 9826675));
        countryArrayLists.add(new Country("Vietnam", R.drawable.vietnam, "Hanoi", 331212));
        countryArrayLists.add(new Country("Great Britain", R.drawable.great_britain, "London", 242495));
        countryArrayLists.add(new Country("Portugal", R.drawable.portugal, "Lisbon", 92212));
        countryArrayLists.add(new Country("Spain", R.drawable.spain, "Madrid", 505992));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.simpleListView);

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