package com.example.medicbotconnect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PresentationPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 6; // Replace with the total number of slides

    public PresentationPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the appropriate Fragment for each slide
        switch (position) {
            case 0:
                return new FragmentStart();
            case 1:
                return new FragmentWelcome();
            case 2:
                return new FragmentInterview();
            case 3:
                return new FragmentDiagnosis();
            case 4:
                return new FragmentPrescription();
            case 5:
                return new FragmentThankYou();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}