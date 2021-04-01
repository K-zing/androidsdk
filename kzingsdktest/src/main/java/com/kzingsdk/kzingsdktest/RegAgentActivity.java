package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.kzingsdk.core.KzingException;
import com.kzingsdk.entity.RegAgentParam;
import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.requests.RegAccountAPI;
import com.kzingsdk.requests.RegAgentParamAPI;

public class RegAgentActivity extends AppCompatActivity {

    private Button regParamButton, regButton;
    private EditText vcodeEditText, usernameEdittext, realnameEdittext;
    private ImageView
            memberRegCodeImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        regParamButton = findViewById(R.id.regParamButton);

        regButton = findViewById(R.id.regButton);

        usernameEdittext = findViewById(R.id.usernameEdittext);
        realnameEdittext = findViewById(R.id.realnameEdittext);
        vcodeEditText = findViewById(R.id.vcodeEditText);
        memberRegCodeImageview = findViewById(R.id.memberRegCodeImageview);

        regParamButton.setOnClickListener(v -> {
            Log.d("", "onClick");
            KzingAPI.getRegAgentParam()
                    .addRegAgentParamCallBack(new RegAgentParamAPI.RegAgentParamCallBack() {
                        @Override
                        public void onSuccess(RegAgentParam regParam) {
                            Log.d("", regParam.toString());
                            memberRegCodeImageview.setImageBitmap(regParam.getVerifyCodeBitmap());
                        }

                        @Override
                        public void onFailure(KzingException kzingException) {
                            Log.d("", kzingException.toString());

                        }
                    })
                    .request(RegAgentActivity.this);

        });
        regButton.setOnClickListener(v -> KzingAPI.regAgentAccount()
                .setParamAgentCode(RegAccountAPI.NO_AGENT)
                .setParamLoginName(usernameEdittext.getText().toString())
                .setParamPassword("q1w2e3")
                .setParamRealName(realnameEdittext.getText().toString())
                .setParamEmail((int) (Math.random() * 100000000) + "@awegawegh.com")
                .setParamPhone("152" + (int) (Math.random() * 100000000))
//                        .setParamQq("")
//                        .setWeiXin("n27yq2ovc22")
                .setParamVerifycode(vcodeEditText.getText().toString())
                .request(RegAgentActivity.this));
    }


}
