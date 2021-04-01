package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.kzingsdk.requests.KzingAPI;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        findViewById(R.id.changeButton)
                .setOnClickListener(v -> {
                    String oldPw = ((EditText) findViewById(R.id.oldPwEditText)).getText().toString();
                    String newPw = ((EditText) findViewById(R.id.newPwEditText)).getText().toString();
                    KzingAPI.changePassword()
                            .setOldParamPassword(oldPw)
                            .setParamNewPassword(newPw)
                            .requestRx(ChangePasswordActivity.this)
                            .subscribe(System.out::println, Throwable::printStackTrace);
                });
    }
}
