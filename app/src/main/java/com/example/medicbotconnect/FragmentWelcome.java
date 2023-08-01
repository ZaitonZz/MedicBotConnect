package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentWelcome extends Fragment {
    TypewriterEffect welcomeText;
    CustomViewPager viewPager;

    public FragmentWelcome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_welcome, container, false);
        welcomeText = root.findViewById(R.id.welcomeText1);
        viewPager = requireActivity().findViewById(R.id.viewPager);
        return root;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            welcomeText.setCharacterDelay(35);
            welcomeText.animateText("Welcome Patient X, I am Medic Bot.\nReady and at your service!");
            startRunner();
        } else{
            cancelRunner();
        }
    }

    private Handler handler = new Handler();
    private Runnable delayedCodeRunnable = new Runnable() {

        @Override
        public void run() {
            viewPager.setCurrentItem(2);
        }
    };

    // Method to control the delayed code execution
    private void executeDelayedCode() {
        handler.postDelayed(delayedCodeRunnable, 4000);
    }

    // Call this method to start the delayed code execution
    private void startRunner() {
        executeDelayedCode();
    }

    // Call this method to cancel the delayed code execution if needed
    private void cancelRunner() {
        handler.removeCallbacks(delayedCodeRunnable);
    }
}