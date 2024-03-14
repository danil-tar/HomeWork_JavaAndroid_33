package com.example.country;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;


public class FragmentListCountrys extends Fragment {
    private List<Country> countryArrayLists;
    private AdapterListCountrys adapterListCountrys;

    interface CountrySelectListener {
        void onCountrySelected(Country country);
    }
    CountrySelectListener listener;

    public List<Country> getCountryArrayLists() {
        return countryArrayLists;
    }

    public void setCountryArrayLists(List<Country> countryArrayLists) {
        this.countryArrayLists = countryArrayLists;
    }

    public FragmentListCountrys(CountrySelectListener countrySelectListener) {
        this.listener = countrySelectListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list_countrys, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.simpleListView);

        adapterListCountrys = new AdapterListCountrys(getContext(), countryArrayLists);
        listView.setAdapter(adapterListCountrys);

        listView.setOnItemClickListener((parent, view1, position, id) -> {

            DetalesViewModel detalesViewModel
                    = new ViewModelProvider(requireActivity()).get(DetalesViewModel.class);
            detalesViewModel.setSelectedItem(countryArrayLists.get(position));

            listener.onCountrySelected(detalesViewModel.getSelectedItem());

        });

    }


}