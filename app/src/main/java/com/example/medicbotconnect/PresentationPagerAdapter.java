package com.example.medicbotconnect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PresentationPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 1; // Replace with the total number of slides

    public PresentationPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the appropriate Fragment for each slide
        switch (position) {
            case 0:
                return new StartFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}