package com.example.country;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.StartForegroundCalledOnStoppedServiceException;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

public class CustomDialog extends DialogFragment {
    public Country country;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String urlFlag = country.urlFlag;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View inflate = inflater.inflate(R.layout.dialog_show_or_delete, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dialogFlag_imageView);
        TextView nameCountry = (TextView) inflate.findViewById(R.id.show_or_delete_nameCountry_textView);
        TextView capitalCountry = (TextView) inflate.findViewById(R.id.show_or_delete_capital_textView);

        Glide.with(getActivity())
                .load(urlFlag)
                .into(imageView);

        nameCountry.setText(country.country);
        capitalCountry.setText(country.capital);

        AlertDialog.Builder dialogWindow = new AlertDialog.Builder(getActivity())
                .setView(inflate)
                .setPositiveButton("Delete", (dialog, which) -> {
                    CountryDao countryDao = App.getInstance().getDatabase().countryDao();
                    countryDao.deleteCountry(country);

                    CountrysViewModel countrysViewModel = new ViewModelProvider(requireActivity()).get(CountrysViewModel.class);
                    countrysViewModel.countryArrayLists.setValue(countryDao.getAllCountries());
                })
                .setNegativeButton("More details", (dialog, which) -> {
                    startActivity(new Intent(getActivity(), DetailsActivity.class)
                            .putExtra(Country.class.getSimpleName(), country));
                });

        return dialogWindow.create();
    }
}
