package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalsViewModel extends ViewModel {
    MutableLiveData<Country> selectedCountry = new MutableLiveData<>();

    public DetalsViewModel() {
    }

    public MutableLiveData<Country> getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(MutableLiveData<Country> selectedCountry) {
        this.selectedCountry = selectedCountry;
    }
}
