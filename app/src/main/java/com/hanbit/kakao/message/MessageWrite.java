package com.hanbit.kakao.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MessageWrite extends AppCompatActivity {
    String temp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = MessageWrite.this;

        LinearLayout frame = new LinearLayout(context);
        LinearLayout.LayoutParams mm = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        frame.setLayoutParams(mm);
        Intent intent = this.getIntent();
        String receiverInfo = intent.getExtras().getString("IdANDPhone").toString();
        Log.d("넘어온ID,이름,전화번호:",receiverInfo);
        WebView wv = new WebView(context);
        wv.setLayoutParams(mm);
        WebSettings settings = wv.getSettings();
        settings.setUseWideViewPort(true); // html을 가능케 하는것
        settings.setJavaScriptEnabled(true); // js를 가능케 하는것
        wv.setWebViewClient(new WebViewClient());

        wv.addJavascriptInterface(new JavascriptInterface() {
            @Override @android.webkit.JavascriptInterface
            public void showToast(String message) {
                Toast.makeText(context,temp,Toast.LENGTH_LONG).show();
            }

            @Override @android.webkit.JavascriptInterface
            public void sendMessage(String message) {
                temp=message;
            }
        }, "Hybrid");

        wv.loadUrl("file:///android_asset/www/html/messageWrite.html");
        frame.addView(wv);
        setContentView(frame);

    }
    public interface JavascriptInterface{
        public void showToast(String message);
        public void sendMessage(String message);
    }
}
