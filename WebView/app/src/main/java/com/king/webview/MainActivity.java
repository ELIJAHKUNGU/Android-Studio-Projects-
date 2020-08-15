package com.king.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView mPortfolioPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPortfolioPage = findViewById(R.id.webview);

        WebSettings settings = mPortfolioPage.getSettings();
        settings.setJavaScriptEnabled(true);

        mPortfolioPage.loadUrl("file:///android_asset/index.html");
    }
}
