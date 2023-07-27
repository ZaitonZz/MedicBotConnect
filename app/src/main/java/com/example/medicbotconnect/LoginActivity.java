package com.example.medicbotconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText textFieldEmail, textFieldPassword;
    private Button loginButton;
    private String inputEmail, validEmail, inputPass, validPass;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        validEmail = "admin@email.com";
        validPass = "1234";
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        textFieldEmail = findViewById(R.id.textFieldEmail);
        textFieldPassword = findViewById(R.id.textFieldPass);
        errorMessage = findViewById(R.id.error1);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEmail = textFieldEmail.getText().toString();
                inputPass = textFieldPassword.getText().toString();

                if(inputEmail.equals(validEmail)){
                    if (inputPass.equals(validPass)){
                        Intent intent = new Intent(LoginActivity.this, CPPairActivity.class);
                        startActivity(intent);
                    }else {
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                }else {
                    errorMessage.setVisibility(View.VISIBLE);
                }

            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        textFieldEmail.setText(null);
        textFieldPassword.setText(null);
        errorMessage.setVisibility(View.INVISIBLE);
    }
}