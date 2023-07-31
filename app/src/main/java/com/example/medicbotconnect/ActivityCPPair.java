package com.example.medicbotconnect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class ActivityCPPair extends AppCompatActivity {
    private int first3digits, second3digits, third3digits;
    private ImageButton backButton;
    private TextView code;
    private Handler handler = new Handler();
    private Runnable goToNextActivityRunnable;
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_pair);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);

        Random random = new Random();
        first3digits = 100 + random.nextInt(899);
        second3digits = 100 + random.nextInt(899);
        third3digits = 100 + random.nextInt(899);
        code = findViewById(R.id.pairingNumber);
        code.setText(String.format("%d-%d-%d", first3digits,second3digits,third3digits));
        backButton = findViewById(R.id.backButton1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmExitDialog();
            }
        });
        // Set up the Runnable that will navigate to the next activity after 5 seconds
        goToNextActivityRunnable = new Runnable() {
            @Override
            public void run() {
                goToNextActivity();
            }
        };
    }

    @Override
    public void onBackPressed() {
        showConfirmExitDialog();
    }

    private void showConfirmExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Exit the app
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog and stay in the app
                dialog.dismiss();
            }
        });
        builder.show();
    }

    // Start the timer in onResume
    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    // Stop the timer in onPause
    @Override
    protected void onPause() {
        super.onPause();
        pauseTimer();
    }

    // Method to start the timer
    private void startTimer() {
        if (!isTimerRunning) {
            handler.postDelayed(goToNextActivityRunnable, 5000); // 5 seconds delay
            isTimerRunning = true;
        }
    }

    // Method to pause the timer
    private void pauseTimer() {
        if (isTimerRunning) {
            handler.removeCallbacks(goToNextActivityRunnable);
            isTimerRunning = false;
        }
    }

    // Method to navigate to the next activity
    private void goToNextActivity() {
        // Replace NextActivity with the desired activity class
        Intent intent = new Intent(ActivityCPPair.this, ActivityMaster.class);
        startActivity(intent);
        finish(); // Optional, to close this activity if needed
    }

}