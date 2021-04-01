package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.kzingsdk.requests.KzingAPI;

public class ChangeWithdrawPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_withdraw_password);
        findViewById(R.id.changeButton)
                .setOnClickListener(v -> {
                    String accPw = ((EditText) findViewById(R.id.accPwEditText)).getText().toString();
                    String oldPw = ((EditText) findViewById(R.id.oldPwEditText)).getText().toString();
                    String newPw = ((EditText) findViewById(R.id.newPwEditText)).getText().toString();
                    KzingAPI.changeWithdrawPasswordAPI()
                            .setParamAccPassword(accPw)
                            .setParamOldPassword(oldPw)
                            .setParamNewPassword(newPw)
                            .requestRx(ChangeWithdrawPasswordActivity.this)
                            .subscribe(System.out::println, Throwable::printStackTrace);
                });


    }
}
