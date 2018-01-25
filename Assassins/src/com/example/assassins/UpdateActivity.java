package com.example.assassins;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends Activity {
	EditText e1,e2,e3,e4,e;
	SQLiteDatabase db;
	TextView t1;
	String s="",s1="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		e1=(EditText)findViewById(R.id.editText2);
		e2=(EditText)findViewById(R.id.editText3);
		e3=(EditText)findViewById(R.id.editText4);
		e4=(EditText)findViewById(R.id.editText5);
		//b3=(Button) findViewById(R.id.textView8);
		t1=(TextView) findViewById(R.id.textView7);
		db=openOrCreateDatabase("mydb",0,null);
	    db.execSQL("create table if not exists det(id integer primary key autoincrement,name varchar(20),age varchar(20),qualification varchar(20),email varchar(20))");
	   
	}
	public void click(View v){
		
		
		AlertDialog.Builder ad=new AlertDialog.Builder(this);
		LayoutInflater li=LayoutInflater.from(this);
		final View v1 = li.inflate(R.layout.idd,null);
		ad.setView(v1);
		ad.setPositiveButton("Ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				e=(EditText) v1.findViewById(R.id.editText1);
				t1.setText(e.getText().toString());
			}
		});
		ad.setNegativeButton("Cancel", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
		AlertDialog b = ad.create();
		b.show();
		
	}
	

	public void update(View v) {
		
		// TODO Auto-generated method stub
		Toast.makeText(UpdateActivity.this, "Inserted Successfully", 2000).show();
		ContentValues cv = new ContentValues();
		    s=e.getText().toString();
		    s1=e1.getText().toString();
		    cv.put("name",s1);
			cv.put("age",e2.getText().toString());
			cv.put("qualification",e3.getText().toString());
			cv.put("email",e4.getText().toString());
			db.update("det", cv, "id=?", new String[]{s});
		
	}
			
	 public void back(View v) {
		// TODO Auto-generated method stub
		 Intent i = new Intent(this,FirstActivity.class);
			startActivity(i);
	}		
	 
			
			
		
		
		
		
	}



