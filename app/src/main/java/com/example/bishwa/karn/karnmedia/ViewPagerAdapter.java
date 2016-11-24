package com.example.bishwa.karn.karnmedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by acer on 11/19/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FragmentSocial();
        }
        else if(position==1){
            return new FragmentSport();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
