package com.example.videoswipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.videoswipe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    private String emailVerificationCode = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        SharedPreferences sp = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();

        if (sp.contains("username") && sp.contains("password")) {
            Intent PreIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(PreIntent);
        } else
            mBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (emailVerification() && passwordVerification()) {
                        if (mBinding.chkBoxRememberMe.isChecked()) {
                            ed.putString("username",mBinding.username.getText().toString());
                            ed.putString("password",mBinding.username.getText().toString().trim());
                            ed.apply();
                        }
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            });
    }

    private boolean emailVerification() {
        if (mBinding.username.getText().toString().matches(emailVerificationCode))
            return true;
        else {
            mBinding.username.setError("Invalid Email");
            return false;
        }
    }

    private boolean passwordVerification() {
        if (mBinding.password.getText().toString().trim().length() >= 6)
            return true;
        else {
            mBinding.password.setError("Password is very short");
            return false;
        }
    }
}