package com.example.assassins;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends Activity {
EditText e1,e2,e3,e4;
SQLiteDatabase db;
ContentValues cv=new ContentValues();
String a="",c="",d="",e="";

@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert);
	    e1=(EditText) findViewById(R.id.editText1);
	    e2=(EditText) findViewById(R.id.editText2);
	    e3=(EditText) findViewById(R.id.editText3);
	    e4=(EditText) findViewById(R.id.editText4);
	   db=openOrCreateDatabase("mydb", 0, null);
	   db.execSQL("create table if not exists det(id integer primary key autoincrement,name varchar(20),age varchar(20),qualification varchar(20),email varchar(20))");
	    
	}

	
	public void ins(View v) {
		// TODO Auto-generated method stub
	  
	  
      AlertDialog.Builder b=new AlertDialog.Builder(this);
      b.setMessage("Do you want to insert");
      b.setPositiveButton("YES",new OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			a=e1.getText().toString();
			c=e2.getText().toString();
			d=e3.getText().toString();
			e=e4.getText().toString();
			cv.put("name",a);
			cv.put("age",c);
			cv.put("qualification",d);
			cv.put("email",e);
			db.insert("det", null,cv);
			Toast.makeText(InsertActivity.this, "Inserted ", Toast.LENGTH_LONG).show();
			
		}
	});
      b.setNegativeButton("NO", new OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			Toast.makeText(InsertActivity.this, "Insert Cancelled", Toast.LENGTH_LONG).show();
		}
	});
      AlertDialog ad=b.create();
      ad.show();
	}
	public void back(View v) {
		// TODO Auto-generated method stub
      finish();
	}
}

