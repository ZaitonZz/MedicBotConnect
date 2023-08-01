package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentThankYou extends Fragment {
    TypewriterEffect thankYouText;
    CustomViewPager viewPager;
    public FragmentThankYou() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_welcome, container, false);
        thankYouText = root.findViewById(R.id.welcomeText1);
        viewPager = requireActivity().findViewById(R.id.viewPager);
        return root;
    }
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            thankYouText.setCharacterDelay(35);
            thankYouText.animateText("Thank you Patient X for your time today!" +
                    "\nHoping for your speedy recovery!");
            Toast.makeText(requireContext(),"Saving patient Data...", Toast.LENGTH_LONG).show();
            startRunner();
        } else{
            cancelRunner();
        }
    }
    private Handler handler = new Handler();
    private Runnable delayedCodeRunnable = new Runnable() {

        @Override
        public void run() {
            viewPager.setCurrentItem(0);
        }
    };

    // Method to control the delayed code execution
    private void executeDelayedCode() {
        handler.postDelayed(delayedCodeRunnable, 6000);
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