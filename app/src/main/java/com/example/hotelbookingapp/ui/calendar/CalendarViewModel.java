package com.example.hotelbookingapp.ui.calendar;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Calendar;

public class CalendarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CalendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}