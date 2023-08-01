package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentInterview extends Fragment {
    TypewriterEffect interviewText;
    TextView question1, question2;
    private boolean isVisible;

    public FragmentInterview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_interview, container, false);
        interviewText = root.findViewById(R.id.interviewText);
        question1 = root.findViewById(R.id.question1);
        question2 = root.findViewById(R.id.question2);
        isVisible = false;
        return root;
    }
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            interviewText.setCharacterDelay(35);
            interviewText.animateText("I have successfully processed your pre-diagnosis check-up" +
                    "\nand I have a few follow up questions.");
            startRunner(3500);
        } else{
            cancelRunner();
        }
    }
    private Handler handler = new Handler();
    private Runnable delayedCodeRunnable = new Runnable() {
        @Override
        public void run() {
            CustomViewPager viewPager = requireActivity().findViewById(R.id.viewPager);
            if (!isVisible){
                question1.setVisibility(View.VISIBLE);
                question2.setVisibility(View.VISIBLE);
                startRunner(5000);
                isVisible = true;
            } else {
                viewPager.setCurrentItem(3);
            }
        }
    };

    // Method to control the delayed code execution
    private void executeDelayedCode(int miliSecs) {
        handler.postDelayed(delayedCodeRunnable, miliSecs);
    }

    // Call this method to start the delayed code execution
    private void startRunner(int miliSecs) {
        executeDelayedCode(miliSecs);
    }

    // Call this method to cancel the delayed code execution if needed
    private void cancelRunner() {
        handler.removeCallbacks(delayedCodeRunnable);
    }
}