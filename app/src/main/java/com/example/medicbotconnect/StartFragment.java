package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        Button startButton = rootView.findViewById(R.id.button);
        ImageView logo = rootView.findViewById(R.id.logo1);

        // Load the fade-in animation from the resource
        Animation fadeInAnimation_fast = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_fast);
        Animation fadeInAnimation_slow = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_slow);
        // Apply the animation to the view
        startButton.startAnimation(fadeInAnimation_slow);
        logo.startAnimation(fadeInAnimation_fast);
        return rootView;
    }
}