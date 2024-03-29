package com.example.country;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalsViewModel extends ViewModel {
    MutableLiveData<CountryDtoDb> selectedCountry = new MutableLiveData<>();
//    MutableLiveData <String> country = new MutableLiveData<>();
//    MutableLiveData <Long> flagId = new MutableLiveData<>();
//
//    MutableLiveData <String> capital = new MutableLiveData<>();
//    MutableLiveData <Long> area = new MutableLiveData<>();
    public DetalsViewModel() {
    }

    public MutableLiveData<CountryDtoDb> getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(CountryDtoDb selectedCountry) {
        this.selectedCountry.setValue(selectedCountry);
    }
}
