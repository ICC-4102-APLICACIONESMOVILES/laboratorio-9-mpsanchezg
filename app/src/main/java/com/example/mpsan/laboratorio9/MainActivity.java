package com.example.mpsan.laboratorio9;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/");

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebChromeClient(new WebChromeClient(){
            public void onConsoleMessage(String message, int lineNumber, String sourceID){
                Log.d("MyApplication", message + " -- Form line" + lineNumber + "of" + sourceID);
            }
        });

        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()){
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed(){
        
    }
}
