package com.example.alc4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

import java.net.MalformedURLException;
import java.net.URL;

public class AboutALCActivity extends AppCompatActivity {

    private WebView aboutALCWebView;
    private ProgressBar mProgressBar;
    public static final String ABOUT_ALC_URL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        setTitle(R.string.toolbar_title_b);

        mProgressBar = findViewById(R.id.load_progressbar);

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

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    displaySnackBar();
                }

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    displaySnackBar();
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    mProgressBar.setVisibility(View.INVISIBLE);
                    aboutALCWebView.setVisibility(View.VISIBLE);
                }
            });

            aboutALCWebView.loadUrl(ABOUT_ALC_URL);

        } else {
            Log.d("WebView", "Null WebView");
        }
    }

    private void displaySnackBar() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.about_alc_coordinator_layout),
                R.string.load_error, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(R.string.retry, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutALCWebView.setVisibility(View.INVISIBLE);
                mProgressBar.setVisibility(View.VISIBLE);
                loadUrl();
            }
        });

        snackbar.show();
    }

}
