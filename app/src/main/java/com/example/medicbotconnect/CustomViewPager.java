package com.example.medicbotconnect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    private boolean swipeEnabled;

    public CustomViewPager(@NonNull Context context) {
        super(context);
        swipeEnabled = true; // Enable swiping by default
        setOffscreenPageLimit(0);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        swipeEnabled = true;
        setOffscreenPageLimit(0);// Enable swiping by default
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Disable swiping to the left (previous fragment)
        if (!swipeEnabled) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Disable swiping to the left (previous fragment)
        if (!swipeEnabled) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    // Method to enable or disable swiping
    public void setSwipeEnabled(boolean swipeEnabled) {
        this.swipeEnabled = swipeEnabled;
    }
}