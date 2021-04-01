package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.kzingsdk.core.KzingException;
import com.kzingsdk.entity.RegParam;
import com.kzingsdk.entity.RegSendSmsResult;
import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.requests.RegParamAPI;
import com.kzingsdk.requests.RegSendSmsAPI;

public class RegActivity extends AppCompatActivity {

    private Button regParamButton, regButton, sendSmsButton;
    private EditText vcodeEditText,usernameEdittext,realnameEdittext;
    private ImageView
            memberRegCodeImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        regParamButton = findViewById(R.id.regParamButton);
        sendSmsButton = findViewById(R.id.sendSmsButton);
        regButton = findViewById(R.id.regButton);

        usernameEdittext = findViewById(R.id.usernameEdittext);
        realnameEdittext = findViewById(R.id.realnameEdittext);
        vcodeEditText = findViewById(R.id.vcodeEditText);
        memberRegCodeImageview = findViewById(R.id.memberRegCodeImageview);

        sendSmsButton.setOnClickListener(v -> KzingAPI.regSendSms()
                .setParamLoginName("testsmsm435")
//                        .setParamPhone("152" + (int) (Math.random() * 100000000))
                .setParamPhone("15291513574")
                .addRegSendSmsCallBack(new RegSendSmsAPI.RegSendSmsCallBack() {
                    @Override
                    public void onSuccess(RegSendSmsResult regSendSmsResult) {
                        Log.d("RegActivity", regSendSmsResult.toString());
                    }

                    @Override
                    public void onFailure(KzingException kzingException) {
                        Log.d("RegActivity", kzingException.toString());
                    }
                })
                .request(RegActivity.this));

        regParamButton.setOnClickListener(v -> {
            Log.d("", "onClick");
            KzingAPI.getRegParam()
                    .addRegParamCallBack(new RegParamAPI.RegParamCallBack() {
                        @Override
                        public void onSuccess(RegParam regParam) {
                            Log.d("", regParam.toString());
                            memberRegCodeImageview.setImageBitmap(regParam.getVerifyCodeBitmap());
                        }

                        @Override
                        public void onFailure(KzingException kzingException) {
                            Log.d("", kzingException.toString());

                        }
                    })
                    .request(RegActivity.this);

        });
        regButton.setOnClickListener(v -> KzingAPI.regAccount()
//                        .setParamAgentCode(RegAccountAPI.NO_AGENT)
                .setParamLoginName(usernameEdittext.getText().toString())
                .setParamPassword("q1w2e3")
                .setParamWithdrawPassword("q1w2e3")
                .setParamRealName(realnameEdittext.getText().toString())
                .setParamEmail((int) (Math.random() * 100000000) + "@awegawegh.com")
                .setParamPhone("152" + (int) (Math.random() * 100000000))
                .setParamQq("" + (int) (Math.random() * 1000000000))
                .setParamAgentCode("10000")
                .setParamBirthdayDay(1)
                .setParamBirthdayYear(1990)
                .setParamBirthdayMonth(1)
//                        .setWeiXin("n27yq2ovc22")
                .setParamVerifycode(vcodeEditText.getText().toString())
                .request(RegActivity.this));
    }


}
