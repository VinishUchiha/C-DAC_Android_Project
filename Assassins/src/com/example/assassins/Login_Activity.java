package com.example.assassins;




import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends Activity implements OnClickListener {
	Button b1,b2;
	EditText e1,e2;
	SQLiteDatabase db;
	String s="",s1="";
	int f=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		db=openOrCreateDatabase("mydb",0,null);
	    db.execSQL("create table if not exists sample(username varchar(20),password varchar(20))");
		
	}

	@Override
	public void onClick(View v) {
		ContentValues cv = new ContentValues();
		// TODO Auto-generated method stub
		Cursor c = db.rawQuery("select * from sample",null);
		if(v==b1){
			c.moveToFirst();
			do{
				s = c.getString(c.getColumnIndex("username"));
				s1 = c.getString(c.getColumnIndex("password"));
				if(s.equals(e1.getText().toString()))
				{
					if(s1.equals(e2.getText().toString())){
						Intent i=new Intent(this,FirstActivity.class);
						startActivity(i);
						f=1;
						break;	
					}
				}
			
				
				
			}while(c.moveToNext());
			
			if(f==0)
			{
				
			Toast.makeText(this, "invalid user",Toast.LENGTH_LONG).show();	
				
			}
		}
		if(v==b2)
		{
			Intent i=new Intent(this,RegisterActivity.class);
			startActivity(i);
		}
		}
		
	

	}

