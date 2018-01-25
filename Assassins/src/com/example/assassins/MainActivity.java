package com.example.assassins;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements Runnable {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Thread a = new Thread(this);
		a.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
		Intent i = new Intent(this,HomeActivity.class);
		startActivity(i);
		finish();
	}

	
}
