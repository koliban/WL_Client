package com.geek99;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText usernameEt,passwordEt;
	ConfigUtil configUtil;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		usernameEt = (EditText)findViewById(R.id.editText1);
		passwordEt = (EditText)findViewById(R.id.editText2);
		configUtil = new ConfigUtil(this);
	}
	
	//3
	String doLogin(String url){
	//String url ="http://10.0.2.2:8080/WL_Server/LoginServlet";
		String username = usernameEt.getText().toString();
		String password = passwordEt.getText().toString();
		// 1. apache client
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		NameValuePair p1 = new BasicNameValuePair("username",username);
		NameValuePair p2 = new BasicNameValuePair("password",password);
		
		list.add(p1);
		list.add(p2);
		
		String msg = HttpUtil.doPost(url, list);
		return msg;
	}	
	
	    // handler
		// Asynctask  2
		class MyTask extends AsyncTask<String, Integer, String>{

			@Override
			protected String doInBackground(String... params) {
				String url = params[0];
				String result = doLogin(url);
				return result;
			}
			
			//4 显示服务器返回的信息
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				Toast.makeText(getApplicationContext(), result, 1).show();
				if(result!=null&&result.equals("-1")) {
					Toast.makeText(getApplicationContext(), "登陆失败", 1).show();
					return;
				}else {
					//json保存
					configUtil.setUserJson(result);
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
				}
		}
}
			
	//1		
public void login(View v){
	String url = "http://10.10.10.102:8080/WL_Server/LoginServlet";
	new MyTask().execute(url);
    }
}