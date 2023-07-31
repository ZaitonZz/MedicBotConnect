package com.example.medicbotconnect;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;

public class TypewriterEffect extends androidx.appcompat.widget.AppCompatTextView {
    private CharSequence myText;
    private int myIndex;
    private long myDelay = 50;
    private boolean done= false;
    public TypewriterEffect(Context context) {
        super(context);
        Log.d(TAG, "TypewriterEffect: help");
    }


    public TypewriterEffect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler myHandler = new Handler();

    private  Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(myText.subSequence(0,myIndex++));
            if (myIndex<myText.length()){
                myHandler.postDelayed(characterAdder, myDelay);
            }
            else if(myIndex==myText.length()){
                myHandler.postDelayed(characterAdder, myDelay);
                done = true;
                Log.d(TAG, "lads");
            }
        }
    };
    public void animateText(CharSequence myTxt){
        myText = myTxt;
        myIndex = 0;
        done = false;
        setText("");
        myHandler.removeCallbacks(characterAdder);
        myHandler.postDelayed(characterAdder, myDelay);
    }

    public void setCharacterDelay(long m){
        myDelay = m;
    }

    public boolean isDone() { return done; }
}
