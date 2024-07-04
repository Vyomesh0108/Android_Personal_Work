package com.example.web_viewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etSearch;
    Button btn;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch=findViewById(R.id.etSearch);
        btn=findViewById(R.id.btn);
        webView=findViewById(R.id.webView);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String url = etSearch.getText().toString();
                //Enabling JavaScript
                //For security reasons, JavaScript is diasbled in the WebView by default.
                //You can enable/disable JavaScript using setJavaScriptEnabled() method.
                webView.getSettings().setJavaScriptEnabled(true);
                //Use setWebViewClient() method to initialize MyWebViewClient class Object.
                webView.setWebViewClient(new MyWebViewClient());
                //Use loadUrl() method to load web page.
                webView.loadUrl(url);

                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //Use loadurl() method to load link in WebView.Return true.
            view.loadUrl(url);
            return true;
        }
    }
}