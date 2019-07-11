package com.example.alc4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.snackbar.Snackbar;

import java.net.MalformedURLException;
import java.net.URL;

public class AboutALCActivity extends AppCompatActivity {

    private WebView aboutALCWebView;
    public static final String ABOUT_ALC_URL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        setTitle(R.string.toolbar_title_b);

        aboutALCWebView = findViewById(R.id.wbview_about_alc);
        loadUrl();

    }

    private void loadUrl() {

        if (aboutALCWebView != null) {
            WebSettings webSettings = aboutALCWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            aboutALCWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            });

            aboutALCWebView.loadUrl(ABOUT_ALC_URL);

        } else {
            Log.d("WebView", "Null WebView");
        }
    }

}
