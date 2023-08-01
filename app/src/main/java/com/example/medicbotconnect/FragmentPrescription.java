package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPrescription extends Fragment {
    TypewriterEffect prescriptionText;
    CustomViewPager viewPager;

    public FragmentPrescription() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_prescription, container, false);
        prescriptionText = root.findViewById(R.id.prescriptionText);
        viewPager = requireActivity().findViewById(R.id.viewPager);
        return root;
    }
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            prescriptionText.setCharacterDelay(35);
            prescriptionText.animateText("Nurse Y will hand you the prescription\nwith the instructions and do's and dont's.");
            startRunner();
        } else{
           cancelRunner();
        }
    }
    private Handler handler = new Handler();
    private Runnable delayedCodeRunnable = new Runnable() {

        @Override
        public void run() {
            viewPager.setCurrentItem(5);
        }
    };

    // Method to control the delayed code execution
    private void executeDelayedCode() {
        handler.postDelayed(delayedCodeRunnable, 5000);
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