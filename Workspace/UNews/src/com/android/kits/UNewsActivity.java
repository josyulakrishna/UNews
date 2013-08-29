package com.android.kits;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;


public class UNewsActivity extends Activity {
    /** Called when the activity is first created. */
    
    private static final String LOG_TAG = "WebViewDemo";
    private WebView mWebView;
    private static final int DIALOG_ID = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Request for Custom TitleBar
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);             
        
        //Set the veiw to my.xml
        
        setContentView(R.layout.my);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_title);                     
        ((TextView)findViewById(R.id.title)).setText("About");
        
        //Intialize the setting for webview,Enable javascript
        
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        mWebView.loadUrl("file:///android_asset/structure.html");
        //Set the clicklistener for the About Dialog box
        
        findViewById(R.id.title).setOnClickListener(new OnClickListener() {
        
                public void onClick(View v) {
                	
                	showDialog(DIALOG_ID);
                }      	
        });
    }   
    	protected Dialog onCreateDialog(int id) {
    		// TODO Auto-generated method stub
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialog_title);
            builder.setMessage(R.string.dialog_message);
            builder.setIcon(android.R.drawable.btn_star);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                    } });
            return builder.create();
        }
        
        //show dialog when clicked on the view 
        
    	  public void onDialogButtonClick(View v) {
    		  showDialog(DIALOG_ID);  
    	  }	



    }

