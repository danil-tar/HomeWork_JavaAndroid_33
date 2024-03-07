package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentListCountrys.OnFragmentSendDataListener {
    private FragmentListCountrys fragmentListCountrys;
    private FragmentDetails fragmentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentDetails = new FragmentDetails();
        fragmentListCountrys = new FragmentListCountrys();

        setContentView(R.layout.activity_main);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, fragmentListCountrys).commit();

    }

    @Override
    public void onSendData(Country country) {
        fragmentDetails.setSelectedItem(country);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_main, fragmentDetails)
                .addToBackStack(null)
                .commit();
    }
}