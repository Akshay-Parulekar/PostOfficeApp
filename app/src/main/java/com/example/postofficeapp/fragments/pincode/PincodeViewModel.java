package com.example.postofficeapp.fragments.pincode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PincodeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PincodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}