package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDiagnosis extends Fragment {
    TypewriterEffect diagnosisText;
    CustomViewPager viewPager;

    public FragmentDiagnosis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_diagnosis, container, false);
        diagnosisText = root.findViewById(R.id.diagnosisText);
        viewPager = requireActivity().findViewById(R.id.viewPager);
        return root;
    }
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            diagnosisText.setCharacterDelay(35);
            diagnosisText.animateText("This is my diagnosis for you.");
            startRunner();
        } else{
            cancelRunner();
        }
    }
    private Handler handler = new Handler();
    private Runnable delayedCodeRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(4);
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