package com.geek99;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigUtil {
	SharedPreferences sp;
	SharedPreferences.Editor editor;
	String userJson;
	public static final String USER_KEY = "user_key";
	
	public String getUserJson() {
		return sp.getString(USER_KEY, ""); //获取数据，默认值为空
	}
	
	public void setUserJson(String userJson) {
		editor.putString(USER_KEY, userJson);
		editor.commit();
	}

	public ConfigUtil(Context ctx){
		sp = ctx.getSharedPreferences("my_sp", Context.MODE_PRIVATE);
		editor = sp.edit();
	}
	
}
