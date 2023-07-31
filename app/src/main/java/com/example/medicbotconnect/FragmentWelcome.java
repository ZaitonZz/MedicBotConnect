package com.example.medicbotconnect;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentWelcome extends Fragment {
    TypewriterEffect welcomeText;

    public FragmentWelcome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_welcome, container, false);
        welcomeText = (TypewriterEffect) root.findViewById(R.id.welcomeText1);
        welcomeText.setCharacterDelay(35);
        welcomeText.animateText("Welcome Patient X, I am Medic Bot.\nReady and at your service!");
        return root;
    }
}