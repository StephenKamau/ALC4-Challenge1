package com.example.alc4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.webkit.WebView;

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
        loadAboutALCWebView();
    }

    private void loadAboutALCWebView() {
       aboutALCWebView.loadUrl(ABOUT_ALC_URL);
    }
}
