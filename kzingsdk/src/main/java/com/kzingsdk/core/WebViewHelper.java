package com.kzingsdk.core;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kzingsdk.entity.ClientInfo;
import com.kzingsdk.entity.MemberInfo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.annotations.NonNull;

/**
 * WebViewHelper provide several static function to setup a default setting to webview for playing games, deposit or contact online customer service.
 * You may modify the setting if needed.
 */
public final class WebViewHelper {
    private static final String TAG = "SDK";
    public static WebView gameWebViewSetup(@NonNull WebView webView) throws KzingException{
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        return webView;
    }

    /**
    * Please use {@link WebViewHelper#gameWebViewSetup(WebView) } instead
     */
    @Deprecated
    public static WebView gameWebViewSetup(@NonNull WebView webView,@NonNull ClientInfo clientInfo,@NonNull MemberInfo memberInfo) throws KzingException{
        if(!KzingSDK.getInstance().hasToken()){
            throw new KzingException("You are not logined");
        }
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView,true);
        }
        String cookieVCString = "vc" + clientInfo.getSiteId() + "=" + KzingSDK.getInstance().getVcToken() + "; domain=" + formatCookieDomain(clientInfo.getSiteDomain());
        cookieManager.setCookie(clientInfo.getSiteDomain(), cookieVCString);
        String cookieCCString = "cc" + clientInfo.getSiteId() + "=" + KzingSDK.getInstance().getCcToken() + "; domain=" + formatCookieDomain(clientInfo.getSiteDomain());
        cookieManager.setCookie(clientInfo.getSiteDomain(), cookieCCString);
        String cookieUnameString = "u" + clientInfo.getSiteId() + "=" + memberInfo.getPlayerName() + "; domain=" + formatCookieDomain(clientInfo.getSiteDomain());
        cookieManager.setCookie(clientInfo.getSiteDomain(),cookieUnameString );
        String cookieCfString = "cf=1" + "; domain=" + formatCookieDomain(clientInfo.getSiteDomain());
        cookieManager.setCookie(clientInfo.getSiteDomain(),cookieCfString );
        return webView;
    }

    public static WebView csWebViewSetup(WebView webView){
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        return webView;
    }

    /**
     * Please use {@link WebViewHelper#depositsWebViewSetup(WebView) } instead
     */
    @Deprecated
    public static WebView depositsWebViewSetup(WebView webView)throws KzingException{
        return gameWebViewSetup(webView);
    }

    public static WebView depositsWebViewSetup(WebView webView, ClientInfo clientInfo,MemberInfo memberInfo)throws KzingException{
        return gameWebViewSetup(webView,clientInfo,memberInfo);
    }

    private static String formatCookieDomain(String domain){
        return domain.replaceFirst("http://","").replaceFirst("https://","");
    }

}
