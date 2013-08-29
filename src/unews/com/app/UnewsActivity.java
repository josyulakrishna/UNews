package unews.com.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class UnewsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	WebView myWebView = (WebView) findViewById(R.layout.webview);
    	myWebView.loadUrl("http://www.google.com");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        WebView myWebView1 = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}