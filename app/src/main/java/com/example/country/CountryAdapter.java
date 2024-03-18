package com.example.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Country> countryList;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.activity_item, null);
        return new CountryViewHolder(view, view.findViewById(R.id.flag_country), view.findViewById(R.id.name_country));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Country country = countryList.get(position);
        CountryViewHolder countryViewHolder = (CountryViewHolder) holder;
        countryViewHolder.flag.setBackgroundResource(country.flagId);
        countryViewHolder.name.setText(country.country);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    private static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView flag;
        private final TextView name;

        public CountryViewHolder(@NonNull View itemView, ImageView flag, TextView name) {
            super(itemView);
            this.flag = flag;
            this.name = name;
        }
    }
}
