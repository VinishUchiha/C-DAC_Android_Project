package com.example.assassins;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener  {
	EditText e1,e2,e3;
	Button b1,b2;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		db=openOrCreateDatabase("mydb",0,null);
		db.execSQL("create table if not exists sample(username varchar(20),password varchar(20))");
		
	}

	@Override
	public void onClick(View v) {
		ContentValues cv=new ContentValues();
		// TODO Auto-generated method stub
		if(v==b1)
		{
			if(e2.getText().toString().equals(e3.getText().toString()))
			{
	          cv.put("username",e1.getText().toString());
	          cv.put("password",e2.getText().toString());
	          db.insert("sample", null, cv);
	          
	          
	      	  Toast.makeText(this, "Registered successfully", Toast.LENGTH_LONG).show();	
			  
	    
			
			}
			else
			{
				
			Toast.makeText(this, "password mismatch", Toast.LENGTH_LONG).show();	
				
			}
		}
		if(v==b2)
		{
			
			Intent i=new Intent(this,Login_Activity.class);
			startActivity(i);
			
			
		}
	}


}
