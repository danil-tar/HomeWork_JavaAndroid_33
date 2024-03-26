package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList = new ArrayList<>();
    RecyclerView recycleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        App.getInstance().getDatabase().countryDao().deleteAllCountries();

        recycleList = findViewById(R.id.recyclerView);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        CountrysViewModel countrysViewModel = viewModelProvider.get(CountrysViewModel.class);

        countryList = countrysViewModel.getCountryArrayLists().getValue();

        countrysViewModel.getCountryArrayLists().observe(this, countryArrayLists -> {
            this.countryList = countryArrayLists;
        });

        recycleList.setAdapter(new CountryRecyclerAdapter(countryList, this));

        findViewById(R.id.AddCountry_button).setOnClickListener(v -> {
           startActivity(new Intent(MainActivity.this, AddDeleteCountryActivity.class));
        });

//        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList);
//        simpleList.setAdapter(customAdapter);

//        simpleList.setOnItemClickListener((parent, view, position, id) -> {
//            Intent intent = new Intent(MainActivity.this, Details.class);
//            intent.putExtra(Country.class.getSimpleName(), countryList.get(position));
//            startActivity(intent);
//        });

    }

//    private static class CustomAdapter extends BaseAdapter {
//        Context context;
//        List<Country> countryArrayLists;
//        LayoutInflater inflater;
//
//
//        public CustomAdapter(Context applicationContext, List<Country> countryArrayLists) {
//            this.context = applicationContext;
//            this.countryArrayLists = countryArrayLists;
//            inflater = (LayoutInflater.from(applicationContext));
//        }
//
//        @Override
//        public int getCount() {
//            return countryArrayLists.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View view = inflater.inflate(R.layout.activity_item, null);
//
//            TextView country = (TextView) view.findViewById(R.id.textView);
//            ImageView flag = (ImageView) view.findViewById(R.id.icon);
//
//            country.setText(countryArrayLists.get(position).country);
//            flag.setImageResource(countryArrayLists.get(position).flagId);
//
//            return view;
//        }
//    }
}