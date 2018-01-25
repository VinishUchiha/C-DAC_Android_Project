package com.example.assassins;






import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	GridView g;
	String num[]={"1","2","3","4","5","6","7","8","9","*","0","#"};
	EditText e1;
	String s,s1="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		g=(GridView) findViewById(R.id.gridView1);
		ArrayAdapter<String> ad=new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1,num);
        g.setAdapter(ad);
        e1=(EditText) findViewById(R.id.editText1);
        g.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        		// TODO Auto-generated method stub
        		s=(String) g.getItemAtPosition(arg2);
        		s1+=s;
        		e1.setText(s1);
        		
        	}
		});
      
	}
	public void change(View v) {
		if(e1.getText().toString().equals("1234"))
		{
			Intent i= new Intent(this,Login_Activity.class);
			startActivity(i);
		}
		else
		{
			Toast.makeText(HomeActivity.this,"INVALID PIN TRY AGAIN" ,Toast.LENGTH_LONG).show();
			s1="";
			e1.setText(" ");
		}
	}
}
