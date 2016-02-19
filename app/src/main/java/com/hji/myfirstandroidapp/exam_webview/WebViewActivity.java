package com.hji.myfirstandroidapp.exam_webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.hji.myfirstandroidapp.R;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditAddress;
    private Button mBtnAccess;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mEditAddress = (EditText) findViewById(R.id.address_edit);
        mBtnAccess = (Button) findViewById(R.id.access_btn);
        mWebView = (WebView) findViewById(R.id.webview);

        mBtnAccess.setOnClickListener(this);

        // 요것을 설정하지 않으면 다른 웹 브라우저가 뜸.
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onClick(View v) {

        mWebView.loadUrl(mEditAddress.getText().toString());
    }
}
