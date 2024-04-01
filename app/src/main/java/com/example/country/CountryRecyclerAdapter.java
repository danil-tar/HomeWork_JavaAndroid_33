package com.example.country;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Country> countryList;
    private final LayoutInflater inflater;

    public CountryRecyclerAdapter(List<Country> countryList, Context context) {

        this.countryList = countryList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Country country = countryList.get(position);
        CountryViewHolder countryViewHolder = (CountryViewHolder) holder;
        countryViewHolder.name.setText(country.country);
        Glide.with(countryViewHolder.flag).load(country.urlFlag).into(countryViewHolder.flag);

        holder.itemView.setOnClickListener(v -> {

            CustomDialog customDialog = new CustomDialog();
            customDialog.country = country;
            customDialog.show(((MainActivity) v.getContext()).getSupportFragmentManager(), "dialog");

//            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
//            intent.putExtra(Country.class.getSimpleName(), country);
//            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    private static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView flag;
        private final TextView name;

        public CountryViewHolder(@NonNull View view) {
            super(view);
            flag = view.findViewById(R.id.flagCountry);
            name = view.findViewById(R.id.nameCountry);
        }
    }
}
