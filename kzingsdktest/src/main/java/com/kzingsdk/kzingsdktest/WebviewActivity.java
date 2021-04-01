package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.kzingsdk.core.WebViewHelper;
import com.kzingsdk.requests.KzingAPI;

public class WebviewActivity extends AppCompatActivity {
    private final String TAG = "WebviewActivity";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = findViewById(R.id.webview);
        webView = WebViewHelper.gameWebViewSetup(webView);
//        String url = "http://172.105.224.156:8888/#/lobby/1";
//        String url = "https://demo.leg666.com/";
//        webView.loadUrl(url);
        KzingAPI.enterGame()
//        new TestEnterGameAPI()
//                .setGamePlatform(null)
//                .setPlayable(null)
//                .setIsAutoTransfer(false)
                .requestRx(this)
                .subscribe(url -> {
                    Log.d(TAG, "enterGame = " + url);
                    webView.loadUrl(url);
                }, th -> {
                    Log.d(TAG, "enterGame Exception = " + th.toString());
                });
    }

}

