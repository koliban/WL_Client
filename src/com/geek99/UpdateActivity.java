package com.geek99;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UpdateActivity extends Activity {
	DbAdapter adAdapter;
	List<Menu> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		adAdapter = new DbAdapter(this);
	}

	String getMenuList(String url) {
		return HttpUtil.doPost(url, null);
	}

	class MyTask extends AsyncTask<String, Integer, String> {
		@Override
		protected String doInBackground(String... params) {
			return getMenuList(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), result, 1).show();
			Gson gson = new Gson();
			Type type = new TypeToken<List<Menu>>() {
			}.getType();
			list = gson.fromJson(result, type);
			if (list != null) {
				adAdapter.deleteMenu();
				for (Menu m : list) {
					int id = m.getId();
					String name = m.getName();

					int tid = m.getTid();
					int price = m.getPrice();
					String description = m.getDesc();
					adAdapter.addMenu(id, name, tid, price, description);
				}
			}

		}
	}

	public void update(View v) {
		// 1. networking
		// 2. AsyncTask
		// 3. SQLite
		String url = "http://10.10.10.102:8080/WL_Server/MenuServlet";
		new MyTask().execute(url);
	}
}
