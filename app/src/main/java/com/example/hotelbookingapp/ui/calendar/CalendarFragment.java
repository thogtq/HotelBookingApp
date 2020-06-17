package com.example.hotelbookingapp.ui.calendar;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.ui.calendar.CalendarViewModel;
import com.example.hotelbookingapp.ui.calendar.tab.DaHuyFragment;
import com.example.hotelbookingapp.ui.calendar.tab.HoanTatFragment;
import com.example.hotelbookingapp.ui.calendar.tab.SapToiFragment;
import com.example.hotelbookingapp.ui.calendar.tab.TabViewAdapter;

import java.util.Calendar;

public class CalendarFragment extends Fragment {

    private CalendarViewModel calendarViewModel;
    private TabLayout tabLayout;
    //private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModel = ViewModelProviders.of(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        tabLayout = (TabLayout) root.findViewById(R.id.tab_calendar);
        viewPager = (ViewPager) root.findViewById(R.id.view_tab_calendar);
        TabViewAdapter adapter = new TabViewAdapter(getChildFragmentManager());
        // add fragment
        adapter.AddFragment(new SapToiFragment(),"Sắp tới");
        adapter.AddFragment(new HoanTatFragment(),"Hoàn tất");
        adapter.AddFragment(new DaHuyFragment(),"Đã hủy");
        //appBarLayout = (AppBarLayout) appBarLayout.findViewById(R.id.)
        //final TextView textView = root.findViewById(R.id.text_calendar);
        //calendarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
         //   @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
       //     }
      //  });
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }


}
