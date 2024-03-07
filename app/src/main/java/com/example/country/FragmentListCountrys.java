package com.example.country;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

    interface OnFragmentSendDataListener {
        void onSendData(Country country);
    }
    OnFragmentSendDataListener listener = (OnFragmentSendDataListener) getActivity();


    public FragmentListCountrys() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_countrys, container, false);
        ListView listView = view.findViewById(R.id.simpleListView);

        adapterListCountrys = new AdapterListCountrys(getContext(), countryArrayLists);
        listView.setAdapter(adapterListCountrys);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            listener.onSendData(countryArrayLists.get(position));

        });

//        listView.setOnItemClickListener((parent, view1, position, id) -> {
//            Country country = countryArrayLists.get(position);
//            Intent intent = new Intent(getActivity(), Details.class);
//            intent.putExtra(Country.class.getSimpleName(), country);


        return view;
    }
}