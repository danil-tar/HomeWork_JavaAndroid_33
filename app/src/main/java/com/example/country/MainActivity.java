package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    String[] countryList = {"Russia", "China",
            "Germany", "India", "Italia", "France",
            "Canada", "USA", "Vietnam", "Great Britain",
            "Portugal", "Spain"};

    int[] flags ={R.drawable.canada, R.drawable.china,
            R.drawable.france, R.drawable.germany,
            R.drawable.india, R.drawable.italia,
            R.drawable.portugal, R.drawable.russia,
            R.drawable.spain, R.drawable.usa,
            R.drawable.vietnam, R.drawable.great_britain};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.textView, countryList);
        simpleList.setAdapter(arrayAdapter);
    }
}