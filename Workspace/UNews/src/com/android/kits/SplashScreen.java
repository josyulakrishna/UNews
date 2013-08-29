package com.android.kits;

import java.util.Timer;
import java.util.TimerTask;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class SplashScreen extends Activity {
	protected int splashTime = 5000; 
	
	private Thread splashTread;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	    setContentView(R.layout.splashscreen); 
	    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_title1);                     
        ((TextView)findViewById(R.id.title1)).setText("UNews");
        
	    TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mainIntent = new Intent().setClass(SplashScreen.this, UNewsActivity.class);
				startActivity(mainIntent);
			}
		};
	    
		Timer time = new Timer();
		time.schedule(task,splashTime);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	    if (event.getAction() == MotionEvent.ACTION_DOWN) {
	    	synchronized(splashTread){
	    		splashTread.notifyAll();
	    	}
	    }
	    return true;
	}
	}

