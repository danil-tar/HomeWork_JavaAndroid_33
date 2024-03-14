package com.example.country;

import androidx.lifecycle.ViewModel;

public class DetalesViewModel extends ViewModel {
    private Country selectedItem;

    public Country getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Country selectedItem) {
        this.selectedItem = selectedItem;
    }
}
