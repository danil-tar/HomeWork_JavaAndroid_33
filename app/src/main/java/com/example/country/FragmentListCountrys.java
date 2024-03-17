package com.example.country;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentListCountrys extends Fragment implements CountrySelectListener{
    List<Country> countryArrayLists;
    private AdapterListCountrys adapterListCountrys;
    private FragmentDetails fragmentDetails = new FragmentDetails();
    CountrySelectListener listener;

    public FragmentListCountrys() {
    }

    public FragmentListCountrys(CountrySelectListener countrySelectListener) {
        this.listener = countrySelectListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
//        CountrysListViewModel countrysListViewModel
//                = viewModelProvider.get(CountrysListViewModel.class);
//        countryArrayLists = countrysListViewModel.getCountryArrayList().getValue();
//        countrysListViewModel.getCountryArrayList()
//                .observe(this, countryArrayList -> {
//                    countryArrayLists.clear();
//                    countryArrayLists.addAll(countryArrayList);
//                });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d( "TEST", "onCreateView:fragment_list_countrys");
        return inflater.inflate(R.layout.fragment_list_countrys, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.simpleListView);

        adapterListCountrys = new AdapterListCountrys(getContext(), countryArrayLists);
        listView.setAdapter(adapterListCountrys);

        Log.d("TEST", "onViewCreated:fragment_list_countrys");

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            listener.onCountrySelected(countryArrayLists.get(position));

            Log.d("TEST", "onItemClick:fragment_list_countrys");
        });

    }

    @Override
    public void onCountrySelected(Country country) {
        fragmentDetails.setSelectedItem(country);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_main, fragmentDetails)
                .addToBackStack(null)
                .commit();
    }
}