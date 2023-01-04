package com.example.postofficeapp.fragments.article_tracking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticleTrackingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ArticleTrackingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}