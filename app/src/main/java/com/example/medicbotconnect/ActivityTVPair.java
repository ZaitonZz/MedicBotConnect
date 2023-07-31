package com.example.medicbotconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTVPair extends AppCompatActivity {
    private EditText pairNum;
    private String pass;
    private Button submitButton;
    private ImageButton exitButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_pair);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        pairNum = findViewById(R.id.pairingNumberField);
        submitButton = findViewById(R.id.submitPairingButton);
        exitButton = findViewById(R.id.backButton);
        pass ="000000000";
        errorMessage = findViewById(R.id.errorMessage);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.equals(pairNum.getText().toString())){
                    errorMessage.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(ActivityTVPair.this, ActivityPresentation.class);
                    startActivity(intent);
                } else {
                    errorMessage.setVisibility(View.VISIBLE);
                }
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed(){
        finish();
    }
}