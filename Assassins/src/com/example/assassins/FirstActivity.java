package com.example.assassins;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
	}

	public void ins(View v) {
		// TODO Auto-generated method stub
      Intent i=new Intent(this,InsertActivity.class);
      startActivity(i);
	}
	public void upd(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this,UpdateActivity.class);
	      startActivity(i);
	}
	public void del(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this,DeleteActivity.class);
	      startActivity(i);
	}
	public void disp(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(this,DisplayActivity.class);
	      startActivity(i);
	}
}

