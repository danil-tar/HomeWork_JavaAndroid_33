package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalsViewModel extends ViewModel {
    MutableLiveData<Country> selectedCountry = new MutableLiveData<>();
//    MutableLiveData <String> country = new MutableLiveData<>();
//    MutableLiveData <Long> flagId = new MutableLiveData<>();
//
//    MutableLiveData <String> capital = new MutableLiveData<>();
//    MutableLiveData <Long> area = new MutableLiveData<>();
    public DetalsViewModel() {
    }

    public MutableLiveData<Country> getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Country selectedCountry) {
        this.selectedCountry.setValue(selectedCountry);
    }
}
