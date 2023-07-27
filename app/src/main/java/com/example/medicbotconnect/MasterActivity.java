package com.example.medicbotconnect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MasterActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isRunningAI, isRunningMusic;
    private Button saveButton, overrideButton, pauseButton, endButton, musicButton, reportButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);
        saveButton = findViewById(R.id.saveButton);
        overrideButton = findViewById(R.id.overrideButton);
        pauseButton = findViewById(R.id.pauseButton);
        endButton = findViewById(R.id.endButton);
        musicButton = findViewById(R.id.musicButton);
        reportButton = findViewById(R.id.reportButton);
        backButton = findViewById(R.id.backButton2);

        saveButton.setOnClickListener(this);
        overrideButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        endButton.setOnClickListener(this);
        musicButton.setOnClickListener(this);
        reportButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        isRunningAI = true;
        isRunningMusic = true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveButton){
            showToastWithDelay("Saving Patient Data...", Toast.LENGTH_SHORT, 0);
            showToastWithDelay("Patient Data Saved!", Toast.LENGTH_SHORT, 3000);
        } else if (v.getId() == R.id.overrideButton) {
            showToastWithDelay("Overriding AI and Saving Current Progress...", Toast.LENGTH_SHORT, 0);
            showToastWithDelay("Override Successful!", Toast.LENGTH_SHORT, 5000);
        } else if (v.getId() == R.id.pauseButton) {
            if (isRunningAI) {
                showToastWithDelay("AI Paused.", Toast.LENGTH_SHORT, 0);
                isRunningAI = false;
            } else {
                showToastWithDelay("Resuming AI...", Toast.LENGTH_SHORT, 0);
                showToastWithDelay("AI resumed!", Toast.LENGTH_SHORT, 3000);
                isRunningAI = true;
            }
        } else if (v.getId() == R.id.endButton) {
            showToastWithDelay("Ending Patient Session Prematurely...", Toast.LENGTH_SHORT, 0);
            showToastWithDelay("Ended Successfully!", Toast.LENGTH_SHORT, 3000);
        } else if (v.getId() == R.id.musicButton) {
            if (isRunningMusic) {
                showToastWithDelay("Music Paused.", Toast.LENGTH_SHORT, 0);
                isRunningMusic = false;
            } else {
                showToastWithDelay("Resuming Music...", Toast.LENGTH_SHORT, 0);
                showToastWithDelay("Music Resumed!", Toast.LENGTH_SHORT, 1500);
                isRunningMusic = true;
            }
        } else if (v.getId() == R.id.reportButton) {
            showToastWithDelay("Generating Log and Issue Report...", Toast.LENGTH_LONG, 0);
            showToastWithDelay("Issue Submitted!", Toast.LENGTH_SHORT, 5000);
        } else if (v.getId() == R.id.backButton2) {
            showConfirmExitDialog();
        }
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

    // Helper method to show a Toast after a specified delay
    private void showToastWithDelay(final String message, final int duration, long delayMillis) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MasterActivity.this, message, duration).show();
            }
        }, delayMillis);
    }

}
